package bds.config;


import bds.services.TransformatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/transformator.properties")
public class TransformatorConfig {

    @Bean
    public TransformatorService transformatorService() {
        return new TransformatorService();
    }


}