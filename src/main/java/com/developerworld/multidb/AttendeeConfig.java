package com.developerworld.multidb;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "attendeeEntityManagerFactory",
        transactionManagerRef = "attendeeTransactionManager",
        basePackages = {"com.developerworld.multidb.multidb.attendee.repo"}
)
public class AttendeeConfig {


   /* @Bean(name = "attendeeDataSource")
    @ConfigurationProperties(prefix = "multidb.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/


    @Bean(name = "attendeeDataSource")
    @ConfigurationProperties(prefix = "multidb.datasource")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/attendee");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean(name = "attendeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    barEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("attendeeDataSource") DataSource dataSource
    ) {
        return
                builder
                        .dataSource(dataSource)
                        .packages("com.developerworld.multidb.multidb.attendee.domain")
                        .persistenceUnit("attendee")
                        .build();
    }


    @Bean(name = "attendeeTransactionManager")
    public PlatformTransactionManager barTransactionManager(
            @Qualifier("attendeeEntityManagerFactory") EntityManagerFactory
                    barEntityManagerFactory
    ) {
        return new JpaTransactionManager(barEntityManagerFactory);
    }
}
