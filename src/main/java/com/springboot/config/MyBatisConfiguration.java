package com.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan( { "com.springboot.config" } )
@PropertySource( value = { "classpath:application.properties" } )
public class MyBatisConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( this.environment.getRequiredProperty( "spring.datasource.driver-class-name" ) );
        dataSource.setUrl( this.environment.getRequiredProperty( "spring.datasource.url" ) );
        dataSource.setUsername( this.environment.getRequiredProperty( "spring.datasource.username" ) );
        dataSource.setPassword( this.environment.getRequiredProperty( "jdbc.password" ) );
        return dataSource;
    }

    //    @Bean
    //    public DataSourceTransactionManager transactionManager() {
    //        return new DataSourceTransactionManager( this.getDataSource() );
    //    }
    //    @Bean
    //    public DataSource getDataSource() {
    //        final BasicDataSource dataSource = new BasicDataSource();
    //        dataSource.setDriverClassName( "org.postgresql.Driver" );
    //        dataSource.setUrl( "jdbc:postgresql://localhost:5432/test" );
    //        dataSource.setUsername( "postgres" );
    //        dataSource.setPassword( "postgres" );
    //        return dataSource;
    //    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setDataSource( this.dataSource() );

        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ssfb.setMapperLocations( resolver.getResources( "mybatis.config-location" ) );

        return ssfb.getObject();
    }

}
