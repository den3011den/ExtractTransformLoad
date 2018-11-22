package bds.application;

import bds.dao.ProceedEntity;
import bds.services.TransformatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan({"bds.services", "bds.config", "bds", "bds.dao"})
public class TransformatorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TransformatorApplication.class);
    @Autowired
    TransformatorService transformatorService;

    public static void main(String args[]) {
        SpringApplication.run(TransformatorApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        log.info(" -->> Application started work");

        log.info(" -->> Checking if there was previous work ...");

        if (transformatorService.getAllProceedTableRecords().size() == 0) {

            log.info(" -->> Previous work not found");
            log.info(" -->> Deleting source table index if exists");
            transformatorService.deleteSourceTableIndex();
            log.info(" -->> Gathering records for work (filling proceed_table) ...");

            if (transformatorService.getProceedList() == false) {
                log.info(" -->> Error while gathering records for work (filling proceed_table)! Exit.");
                System.exit(-1);
            }

         }

        log.info(" -->> Indexing source table (if not exists)... ");
        transformatorService.addSourceTableIndex();
        log.info(" -->> Finished indexing source table");

        log.info(" -->> Gathering unprocessed records from proceed_table ...");

        List<ProceedEntity> notDoneProceedTableRecords = transformatorService.getNotDoneProceedTableRecords();
        if (notDoneProceedTableRecords.size() > 0) {
            log.info(" -->> " + notDoneProceedTableRecords.size() + " unprocessed records found");
            log.info(" -->> Processing started ...");
            transformatorService.transformationProcess(notDoneProceedTableRecords, true);

            notDoneProceedTableRecords = transformatorService.getNotDoneProceedTableRecords();

            if (notDoneProceedTableRecords.size() > 0) {
                log.warn(" -->> There was some problems with some records during proceeding data");
                log.warn(" -->> Not all data were processed.");
                log.warn(" -->> You have to run this application one more time again to process the raw data.");
            } else {
                log.info(" -->> The process has been completed. All records has been processed");
            }

        } else {
            log.info(" -->> It seems all data has been processed. Cannot find unprocessed records in proceed_table");
        }

        log.info("Application finished work");
        System.exit(0);

    }
}
