package com.example.spring_boot_aws_rds.config;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://database-1.c5wo6wu84ktu.ap-south-1.rds.amazonaws.com:3306/my_student_db");
        dataSource.setUsername("admin");
        dataSource.setPassword("mysqlubqroot");

        return dataSource;


    }
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
