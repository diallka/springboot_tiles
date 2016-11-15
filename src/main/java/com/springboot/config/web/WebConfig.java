package com.springboot.config.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.springboot.config.profile.ConversionRoleProfilUser;

@SpringBootApplication
@EnableWebMvc
@Configuration
@ComponentScan( basePackages = "com.springboot" )
public class WebConfig extends WebMvcConfigurerAdapter {

    //@Autowired
    ConversionRoleProfilUser roleToUserProfileConverter;

    //    @Override
    //    public void addFormatters( final FormatterRegistry registry ) {
    //        registry.addConverter( this.roleToUserProfileConverter );
    //    }

    //Configuration tiles *********************************************************
    @Bean
    public UrlBasedViewResolver tilesViewResolver() {

        final UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass( TilesView.class );
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {

        final TilesConfigurer tconf = new TilesConfigurer();
        tconf.setDefinitions( new String[]{ "/WEB-INF/tiles/tiles.xml" } );
        return tconf;

    }

    //**************************************************************************

    // On configure le dossier source des ressourrces internes tel CSS/ Javascript etc...
    @Override
    public void addResourceHandlers( final ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( "/static/**" ).addResourceLocations( "/static/" );
    }

    //************************************************************************
    //    @Bean( name = "simpleMappingExceptionResolver" )
    //    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
    //        final SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
    //
    //        final Properties mappings = new Properties();
    //        mappings.setProperty( "DatabaseException", "databaseError" );
    //        mappings.setProperty( "InvalidCreditCardException", "creditCardError" );
    //
    //        r.setExceptionMappings( mappings );  // None by default
    //        r.setDefaultErrorView( "error" );    // No default
    //        r.setExceptionAttribute( "ex" );     // Default is "exception"
    //        r.setWarnLogCategory( "example.MvcLogger" );     // No default
    //        return r;
    //    }

}
