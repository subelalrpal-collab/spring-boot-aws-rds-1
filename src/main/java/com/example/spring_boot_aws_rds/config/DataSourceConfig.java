/*
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
   // @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.write")
    public DataSourceProperties  writeDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name="writeDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.write.hikari")
   public HikariDataSource writeDataSource(@Qualifier("writeDataSourceProperties") DataSourceProperties sourceProperties){
     return sourceProperties.initializeDataSourceBuilder()
             .type(HikariDataSource.class)
             .build();
    }

    @Bean(name="getWriteJdbcTemplate")
    @Primary
    public JdbcTemplate getWriteJdbcTemplate( @Qualifier("writeDataSource") HikariDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

   // @Bean(name="readReplicaDataSource")
    @Bean
    @ConfigurationProperties("spring.datasource.read")
    public DataSourceProperties readDataSourceProperties(){
        System.out.println("This is Read Data Source");
        return new DataSourceProperties();
    }

    @Bean(name="readReplicaDataSource")
    @ConfigurationProperties("spring.datasource.read.hikari")
    public HikariDataSource readReplicaDataSource( @Qualifier("readDataSourceProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
    @Bean(name="getReadReplicaJdbcTemplate")
    public JdbcTemplate getReadReplicaJdbcTemplate( @Qualifier("readReplicaDataSource") HikariDataSource dataSource){
        System.out.println("This is Read JDBC TEmplate");
        return new JdbcTemplate(dataSource);
    }
}
*/
