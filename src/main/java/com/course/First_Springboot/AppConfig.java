package com.course.First_Springboot;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    DataSource realDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url("jdbc:oracle:thin:@localhost:1521:xe")
                .username("SYS AS SYSDBA")
                .password("Oracle@123")
                .build();
        return dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource() {
        return new DataSourceSpy(realDataSource());
    }
}