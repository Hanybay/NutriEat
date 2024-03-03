package com.gestrestau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;



@SpringBootApplication
public class GestrestauApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("classpath:data.sql")
    private org.springframework.core.io.Resource[] dataScript;

    public static void main(String[] args) {
        SpringApplication.run(GestrestauApplication.class, args);
    }

    @Override
    @DependsOn("flywayInitializer")
    public void run(String... args) throws Exception {
        // Run your data script here using jdbcTemplate
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(dataScript);
        DatabasePopulatorUtils.execute(populator, jdbcTemplate.getDataSource());
    }
}
