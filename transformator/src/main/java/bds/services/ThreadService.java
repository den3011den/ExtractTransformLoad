package bds.services;

import bds.dao.ProceedEntity;
import bds.dao.SourceEntity;
import bds.dao.TargetEntity;
import bds.dao.repo.ProceedRepository;
import bds.dao.repo.SourceRepository;
import bds.dao.repo.TargetRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.util.locale.provider.LocaleServiceProviderPool;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadService implements Callable {

    private static final Logger LOG = LoggerFactory.getLogger(ThreadService.class);

    ProceedEntity proceedEntity;

    SessionFactory sessionFactory;

    ProceedRepository proceedRepository;

    TargetRepository targetRepository;


    public ThreadService(ProceedEntity proceedEntity, SessionFactory sessionFactory,
                         ProceedRepository proceedRepository, TargetRepository targetRepository) {

        this.sessionFactory = sessionFactory;
        this.proceedEntity = proceedEntity;
        this.proceedRepository = proceedRepository;
        this.targetRepository = targetRepository;

    }


    /**
     * Алгоритм работы нити игрока
     */
    @Override
    public Boolean call() throws Exception {
        try {

            LOG.info(Thread.currentThread().getName() + ": " + " thread started");
            Session session = sessionFactory.openSession();
            Query query = session.createQuery("from SourceEntity " +
                    " where flightIcaoCode = :flightIcaoCode and flightNumber = :flightNumber" +
                    " and schdDepOnlyDateLt = :schdDepOnlyDateLt " +
                    " order by createdAt DESC, id DESC");

            query.setParameter("flightIcaoCode", proceedEntity.getFlightIcaoCode());
            query.setParameter("flightNumber", proceedEntity.getFlightNumber());
            query.setParameter("schdDepOnlyDateLt", proceedEntity.getSchdDepOnlyDateLt());

            List<SourceEntity> sourceList = query.list();

            TargetEntity targetEntity = new TargetEntity(sourceList);

            Transaction transaction = session.beginTransaction();

            targetRepository.save(targetEntity);

            proceedEntity.setDone(true);

            proceedRepository.save(proceedEntity);

            transaction.commit();

        } catch (ParseException e) {
              e.printStackTrace();
        }

        return new Boolean(true);
    }
}
