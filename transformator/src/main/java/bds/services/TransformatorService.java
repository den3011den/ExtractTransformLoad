package bds.services;

import bds.dao.ProceedEntity;
import bds.dao.repo.ProceedRepository;
import bds.dao.repo.SourceRepository;
import bds.dao.repo.TargetRepository;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@Service
@PropertySource("classpath:/transformator.properties")
@EnableJpaRepositories("bds.dao")
@EntityScan(basePackageClasses = {bds.dao.SourceEntity.class, bds.dao.TargetEntity.class, bds.dao.ProceedEntity.class})

public class TransformatorService {

    // максимальное число одновременно работающих потоков (размер thread pool)
    @Value("${transformator.maxProceedThreads.prop}")
    private int maxProceedThreads;

    private static final Logger LOG = LoggerFactory.getLogger(TransformatorService.class);

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

    // составить список сворачиваемых записей из таблицы-источника в таблицу-результат
    public boolean getProceedList() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // заполенние вспомогательной таблицы
        Query query = session.createQuery("insert into ProceedEntity(flightIcaoCode, flightNumber, schdDepOnlyDateLt) " +
                " select  distinct flightIcaoCode," +
                " flightNumber," +
                " schdDepOnlyDateLt" +
                " from SourceEntity");

        int result = query.executeUpdate();

        transaction.commit();

        session.close();

        return (result > 0);
    }

    // Добавление индекса для ускорения запросов к таблице-источнику
    public void addSourceTableIndex() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("create index IF NOT EXISTS aenaflight_2017_01_flight_icao_code_flight_number_schd_dep_only " +
                " on aenaflight_2017_01 (flight_icao_code desc, flight_number desc, schd_dep_only_date_lt desc);");

        query.executeUpdate();

        transaction.commit();

        session.close();

    }

    public void deleteSourceTableIndex() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("DROP INDEX IF EXISTS aenaflight_2017_01_flight_icao_code_flight_number_schd_dep_only");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    // получить все записи proceed_table
    public List<ProceedEntity> getAllProceedTableRecords() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        List<ProceedEntity> allProceedTableRecordsList = (List<ProceedEntity>) proceedRepository.findAll();

        transaction.commit();

        session.close();

        return allProceedTableRecordsList;
    }

    // получить не обработанные записи proceed_table, чтобы не начинать сначала при вылете приложения во время обработки
    public List<ProceedEntity> getNotDoneProceedTableRecords() {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(ProceedEntity.class);
        criteria.add(Restrictions.eq("done", false));

        List<ProceedEntity> notDoneProceedTableRecordsList = criteria.list();

        transaction.commit();
        session.close();

        return notDoneProceedTableRecordsList;
    }


    // запуск процесса обработки записей с запуском каждого запроса в разной нити
    public void transformationProcess(List<ProceedEntity> list, boolean echo) throws ParseException, InterruptedException, ExecutionException {

        int recordsCount = list.size();

        int counter = 0;
        int totalCounter = 0;

        ExecutorService pool = Executors.newFixedThreadPool(maxProceedThreads);
        Set<Future<Boolean>> set = new HashSet<Future<Boolean>>();

        for (ProceedEntity proceedEntity : list) {

            totalCounter++;

            counter++;

            LOG.info("-->> adding a record to the processing queue: " + totalCounter + " of " + recordsCount + " records");

            Callable<Boolean> callable = new ThreadTransformationService(proceedEntity, sessionFactory,
                    proceedRepository, targetRepository);
            Future<Boolean> future = pool.submit(callable);
            set.add(future);

        }

        // ждём окончания работы последних нитей обработки данных
        if (counter >= maxProceedThreads) {
            for (Future<Boolean> future2 : set) {
                future2.get();
            }

        }

    }
}












