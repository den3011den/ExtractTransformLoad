package bds.services;

import bds.dao.ProceedEntity;
import bds.dao.SourceEntity;
import bds.dao.TargetEntity;
import bds.dao.repo.ProceedRepository;
import bds.dao.repo.SourceRepository;
import bds.dao.repo.TargetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:/transformator.properties")
@EnableJpaRepositories("bds.dao")
@EntityScan(basePackageClasses = {bds.dao.SourceEntity.class, bds.dao.TargetEntity.class, bds.dao.ProceedEntity.class})

public class TransformatorService {

    private static final Logger log = LoggerFactory.getLogger(TransformatorService.class);

    static private List<ProceedEntity> allProceeds;
    static private List<SourceEntity> allSources;
    static private List<TargetEntity> allTargets;

    @Autowired
    ProceedRepository proceedRepository;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    TargetRepository targetRepository;


}
