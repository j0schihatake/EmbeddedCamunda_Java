package com.j0schi.template.config;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class CamundaJobExecutorConfig {

    /**
     * Для использования с Postgres,
     * раскомментировать.
     * @param dataSource
     * @param transactionManager
     * @return
     */
    //@Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(
            DataSource dataSource,
            PlatformTransactionManager transactionManager) {

        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setDataSource(dataSource);
        config.setTransactionManager(transactionManager);
        config.setDatabaseSchemaUpdate("true");
        config.setDatabaseTablePrefix("camunda.");
        config.setJobExecutorActivate(true);
        config.setJdbcBatchProcessing(false);
        config.setJobExecutorDeploymentAware(false);
        return config;
    }
}
