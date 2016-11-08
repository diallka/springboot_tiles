package com.springboot.tiles.controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping( "/" )
    public String welcome( final Map< String , Object > model ) {
        model.put( "message", "Bienvenue Spring boot et tiles, accédez à d'autres rubriques Bientot ..." );
        return "home";
    }

    @RequestMapping( "/test" )
    public String test() {

        return "test";
    }
}
