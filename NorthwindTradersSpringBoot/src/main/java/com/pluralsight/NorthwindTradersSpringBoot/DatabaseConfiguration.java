package com.pluralsight.NorthwindTradersSpringBoot;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    private BasicDataSource ds;

    @Autowired
    public DatabaseConfiguration(@Value("${connectionUrl}") String url,
                                 @Value("${username}") String username,
                                 @Value("${password}") String password) {
        ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
    }

    @Bean
    public DataSource dataSource() {
        return ds;
    }
}
