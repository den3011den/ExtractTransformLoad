package bds.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication

public class TransformatorApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TransformatorApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(TransformatorApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        log.info("Application run");

        log.info("Application stopped");

        System.exit(0);

    }
}
