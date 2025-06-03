package com.j0schi.template.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Slf4j
@Configuration
public class JdbcConfig {

    //@Bean
    public JdbcTemplate appJdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/myapp");
        dataSource.setUsername("myapp");
        dataSource.setPassword("myapp123");

        return new JdbcTemplate(dataSource);
    }
}
