package com.bework.beworktracking.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.tracking.datasource")
public class TrackingDatasourceConfig extends HikariConfig {

    @Bean
    @Primary
    public DataSource trackingDataSource() {
        return new HikariDataSource(this);
    }

    @Bean
    @Primary
    @Autowired
    public NamedParameterJdbcTemplate trackingJdbcTemplate(@Qualifier("trackingDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
