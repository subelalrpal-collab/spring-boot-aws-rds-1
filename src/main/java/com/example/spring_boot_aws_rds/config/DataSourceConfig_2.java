package com.example.spring_boot_aws_rds.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig_2 {

    @Bean
    @ConfigurationProperties("spring.datasource.write")
    public DataSource writeDataSource(){
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.read")
    public DataSource readDataSource(){
        return new HikariDataSource();
    }

    @Bean
    public JdbcTemplate writeJdbcTemplate(@Qualifier("writeDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate readJdbcTemplate(@Qualifier("readDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



}
