package com.springboot.config.mybatis;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan( "com.springboot.dao" )
@PropertySource( value = { "classpath:application.properties" } )
public class MyBatisConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( this.environment.getRequiredProperty( "spring.datasource.driver-class-name" ) );
        dataSource.setUrl( this.environment.getRequiredProperty( "spring.datasource.url" ) );
        dataSource.setUsername( this.environment.getRequiredProperty( "spring.datasource.username" ) );
        dataSource.setPassword( this.environment.getRequiredProperty( "spring.datasource.password" ) );

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager( this.dataSource() );
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource( this.dataSource() );
        sessionFactory.setDataSource( this.dataSource() );
        //sessionFactory.setMapperLocations( new Resource[]{ new ClassPathResource( "mapper/chemin_fichier.xml" ) } ); //Acceder directement au mapper
        sessionFactory.setConfigLocation( new ClassPathResource( "mapper/mybatis-config.xml" ) ); //accéder à la configuration des mappers grace à "ClassPathResource"
        sessionFactory.setTypeAliasesPackage( "com.springboot.model" );

        return sessionFactory;
    }

}
