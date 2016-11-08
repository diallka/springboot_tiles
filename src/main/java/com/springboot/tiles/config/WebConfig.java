package com.springboot.tiles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

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

}
