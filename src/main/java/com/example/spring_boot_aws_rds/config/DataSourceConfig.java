package com.example.spring_boot_aws_rds.config;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name="writeDataSourceProperties")
    @Primary
    @ConfigurationProperties("spring.datasource.write")
    public DataSource writeDataSourceProperties(){
        return new HikariDataSource();
    }
    @Bean(name="getWriteJdbcTemplate")
    @Primary
    public JdbcTemplate getWriteJdbcTemplate( @Qualifier("writeDataSourceProperties") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="readReplicaDataSource")
    @ConfigurationProperties("spring.datasource.read")
    public DataSource readReplicaDataSource(){
        return new HikariDataSource();
    }
    @Bean(name="getReadReplicaJdbcTemplate")
    public JdbcTemplate getReadReplicaJdbcTemplate( @Qualifier("readReplicaDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
