package bds.services;

import bds.dao.ProceedEntity;
import bds.dao.SourceEntity;
import bds.dao.TargetEntity;
import bds.dao.repo.ProceedRepository;
import bds.dao.repo.TargetRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.Callable;


// класс для обработки каждой записи из proceed_table в отдельном потоке
class ThreadTransformationService implements Callable {

    private static final Logger LOG = LoggerFactory.getLogger(ThreadTransformationService.class);

    private final ProceedEntity proceedEntity;

    private final SessionFactory sessionFactory;

    private final ProceedRepository proceedRepository;

    private final TargetRepository targetRepository;

    public ThreadTransformationService(ProceedEntity proceedEntity, SessionFactory sessionFactory,
                                       ProceedRepository proceedRepository, TargetRepository targetRepository) {

        this.sessionFactory = sessionFactory;
        this.proceedEntity = proceedEntity;
        this.proceedRepository = proceedRepository;
        this.targetRepository = targetRepository;

    }


    /**
     * Алгоритм работы нити
     */
    //@Override
    public Boolean call() {
        try {

            LOG.info("-->> " + Thread.currentThread().getName() + ": " + " thread started. Work with record id " + proceedEntity.getId());
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

            // считает запись обработанной, чтобы больше не обрабатывать повторно
            proceedEntity.setDone(true);

            proceedRepository.save(proceedEntity);

            transaction.commit();

            session.close();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Boolean.TRUE;
    }
}
