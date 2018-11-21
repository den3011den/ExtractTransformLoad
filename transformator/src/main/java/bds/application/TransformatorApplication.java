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
@ComponentScan({"bds.services","bds.config", "bds", "bds.dao"})
public class TransformatorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TransformatorApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(TransformatorApplication.class, args);
    }

    @Autowired
    TransformatorService transformatorService;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Application started work");

        log.info("Checking if there was previous work ...");

        if (transformatorService.getAllProceedTableRecords().size() == 0) {

            log.info("No previous work found.");

            log.info("Gathering records for work (filling proceed_table) ...");

            if (transformatorService.getProceedList() == false) {
                log.info("Error while gathering records for work (filling proceed_table)! Exit.");
                System.exit(-1);
            }
        }

        log.info("Gathering not proceeded records from proceed_table ...");
        List<ProceedEntity> notDoneProceedTableRecords = transformatorService.getNotDoneProceedTableRecords();
        if (notDoneProceedTableRecords.size() > 0) {
            log.info(" " + notDoneProceedTableRecords.size() + " not proceeded records found");
            log.info("Started proceed ...");
            transformatorService.transformationProcess(notDoneProceedTableRecords,true);
            log.info("Finished proceed");
            }
            else {
                log.info("It seems all data has been proceeded. Cannot find not done records in proceed_table");
        }

        log.info("Application finished work");
        System.exit(0);

    }
}
