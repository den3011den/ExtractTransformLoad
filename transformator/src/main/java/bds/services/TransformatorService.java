package bds.services;

import bds.dao.ProceedEntity;
import bds.dao.SourceEntity;
import bds.dao.TargetEntity;
import bds.dao.repo.ProceedRepository;
import bds.dao.repo.SourceRepository;
import bds.dao.repo.TargetRepository;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManagerFactory;
import java.text.ParseException;
import java.util.List;

@Service
@PropertySource("classpath:/transformator.properties")
@EnableJpaRepositories("bds.dao")
@EntityScan(basePackageClasses = {bds.dao.SourceEntity.class, bds.dao.TargetEntity.class, bds.dao.ProceedEntity.class})

public class TransformatorService {

    private static final Logger LOG = LoggerFactory.getLogger(TransformatorService.class);

    //static private List<ProceedEntity> allProceeds;
    //static private List<SourceEntity> allSources;
    //static private List<TargetEntity> allTargets;

    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        return emf.unwrap(SessionFactory.class);
    }


    @Autowired
    ProceedRepository proceedRepository;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    TargetRepository targetRepository;

    @Autowired
    private SessionFactory sessionFactory;


    public boolean getProceedList() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("insert into ProceedEntity(flightIcaoCode, flightNumber, schdDepOnlyDateLt) " +
                " select  distinct flightIcaoCode,"  +
                    " flightNumber," +
                    " schdDepOnlyDateLt" +
                " from SourceEntity");
        int result = query.executeUpdate();

        transaction.commit();

        session.close();

        return (result>0);
    }


    public List<ProceedEntity> getAllProceedTableRecords() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        List<ProceedEntity> allProceedTableRecordsList = (List<ProceedEntity>) proceedRepository.findAll();

        transaction.commit();

        return allProceedTableRecordsList;
    }


    public List<ProceedEntity> getNotDoneProceedTableRecords() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(ProceedEntity.class);
        criteria.add(Restrictions.eq("done", false));

        List<ProceedEntity> notDoneProceedTableRecordsList = criteria.list();

        transaction.commit();

        return notDoneProceedTableRecordsList;
    }


    public boolean transformationProcess(List<ProceedEntity> list, boolean echo) throws ParseException {

        int recordsCount = list.size();

        int counter = 0;

        Session session = sessionFactory.openSession();

        for(ProceedEntity proceedEntity: list) {

            Transaction transaction = session.beginTransaction();

            counter++;

            Query query = session.createQuery("from SourceEntity " +
                    " where flightIcaoCode = :flightIcaoCode and flightNumber = :flightNumber" +
                    " and schdDepOnlyDateLt = :schdDepOnlyDateLt " +
                    " order by createdAt DESC, id DESC");

            query.setParameter("flightIcaoCode", proceedEntity.getFlightIcaoCode());
            query.setParameter("flightNumber", proceedEntity.getFlightNumber());
            query.setParameter("schdDepOnlyDateLt", proceedEntity.getSchdDepOnlyDateLt());

            List<SourceEntity> sourceList = query.list();

            TargetEntity targetEntity = new TargetEntity(sourceList);

            targetRepository.save(targetEntity);

            proceedEntity.setDone(true);

            proceedRepository.save(proceedEntity);

            if (echo)
                LOG.info("TransformationProcess(): proceeded " + counter + " record of " + recordsCount + " records");

            transaction.commit();
        }

        return true;
    }

}










