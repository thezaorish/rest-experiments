package com.zaorish.stm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.zaorish.stm.persistence"})
@EnableJpaRepositories(basePackages = "com.zaorish.stm.persistence.dao")
@PropertySource("classpath:persistence.properties")
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[] {"com.zaorish.stm.domain"});
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(additionalProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties additionalProperties() {
        final Properties jpaProperties = new Properties();
        // Configures the used database dialect. This allows Hibernate to create SQL that is optimized for the used database.
        jpaProperties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));

        // Specifies the action that is invoked to the database when the Hibernate SessionFactory is created or closed.
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "create-drop"));

        // Configures the naming strategy that is used when Hibernate creates new database objects and schema elements
        // jpaProperties.setProperty("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        // setProperty("hibernate.ejb.naming_strategy", org.hibernate.cfg.ImprovedNamingStrategy.class.getName());

        // If the value of this property is true, Hibernate writes all SQL statements to the console.
        jpaProperties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

        // If the value of this property is true, Hibernate will format the SQL that is written to the console.
        jpaProperties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

        return jpaProperties;
    }

}
