package com.springboot.config;

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
//@EnableTransactionManagement
//@ComponentScan( { "com.springboot.config" } )
@MapperScan( "com.springboot.dao" )
//@MapperScan( basePackages = "com.springboot.dao" )
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

        //        final JdbcTemplate jdbcTemplate = new JdbcTemplate( dataSource );
        //        System.out.println( "Creating tables" );
        //        jdbcTemplate.execute( "drop table if exists users" );
        //        jdbcTemplate.execute( "create table users(id serial, firstName varchar(255), lastName varchar(255), email varchar(255))" );
        //        jdbcTemplate.update( "INSERT INTO users(firstName, lastName, email) values (?,?,?)", "Mike", "Lanyon", "lanyonm@gmail.com" );

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager( this.dataSource() );
    }

    //    @Bean
    //    public SqlSessionFactory sqlSessionFactory() throws Exception {
    //        final SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
    //        ssfb.setDataSource( this.dataSource() );
    //
    //        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    //        ssfb.setMapperLocations( resolver.getResources( "mybatis.config-location" ) );
    //        return ssfb.getObject();
    //    }

    //    @Bean
    //    public SqlSessionFactory sqlSessionFactory() throws Exception {
    //        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    //        sessionFactory.setDataSource( this.dataSource() );
    //        sessionFactory.setTypeAliasesPackage( "com.spring.model" );
    //        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    //        sessionFactory.setMapperLocations( resolver.getResources( "classpath*:application.properties:mybatis.config-location" ) );
    //        sessionFactory.setMapperLocations( resolver.getResources( "classpath*:mapper/login-mapper.xml" ) );
    //        return sessionFactory.getObject();
    //
    //    }
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {

        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource( this.dataSource() );
        sessionFactory.setDataSource( this.dataSource() );
        //sessionFactory.setMapperLocations( new Resource[]{ new ClassPathResource( "mapper/chemin_fichier.xml" ) } ); //Acceder directement au mapper
        sessionFactory.setConfigLocation( new ClassPathResource( "mapper/mybatis-config.xml" ) ); //accéder à la configuration des mappers grace a "ClassPathResource"
        sessionFactory.setTypeAliasesPackage( "com.springboot.model" );

        return sessionFactory;
    }

}
