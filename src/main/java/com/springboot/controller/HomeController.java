package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.service.UserService;

@Controller
@EnableAutoConfiguration
public class HomeController {

    @Autowired
    private UserService uService;

    @RequestMapping( "/" )
    public String welcome( final Map< String , Object > model ) {
        model.put( "message", "Bienvenue Spring boot et tiles, accédez à d'autres rubriques Bientot ..." );
        return "home";
    }

    @RequestMapping( "/test" )
    public String test() {

        return "test";
    }

    @RequestMapping( "/test3" )
    public ModelAndView test2() {
        return new ModelAndView( "test3" );
    }

}
