package bds.config;


import bds.services.TransformatorService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:/transformator.properties")
public class TransformatorConfig {

    @Bean
    public TransformatorService transformatorService() {
        return new TransformatorService();
    }

}