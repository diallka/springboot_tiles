package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.dao.UserDaoInt;
import com.springboot.model.User;
import com.springboot.service.UserService;

@Controller
@EnableAutoConfiguration
public class HomeController {

    @Autowired
    private UserService uService;

    @Autowired
    private UserDaoInt  dao;

    @RequestMapping( value = { "/", "/home" } )
    public String welcome( final Map< String , Object > model ) {
        model.put( "message", "Bienvenue Spring boot et tiles ..." );
        return "home";
    }

    @RequestMapping( value = "/liste" , method = RequestMethod.GET )
    public String listeUser( final Model m ) {
        m.addAttribute( "liste", this.dao.findUsers() );
        return "liste";
    }

    // Ajout page d'Authentification****************************************
    // RequestMapping accepte plusieurs valeurs en utilisant "{}"
    @RequestMapping( value = "/connexion" , method = RequestMethod.GET )
    public String connexionGET( final Model m ) {
        m.addAttribute( "util", new User() );
        m.addAttribute( "lienSeconnecter", "connexion" );
        return "connexion";
    }

    @RequestMapping( value = "/connexion" , method = RequestMethod.POST )
    public String connexionPOST( final Model m ) {

        return "redirect:/espace_personnel";
    }

    //**********************************************************************
    @RequestMapping( value = "/espace_personnel" , method = RequestMethod.GET )
    public String espace_perso( final Model m ) {
        m.addAttribute( "nbr", this.dao.findUsers().size() );
        return "espace_personnel";
    }

    @RequestMapping( "/tests" )
    public String test( final Model m ) {
        m.addAttribute( "utilisateurs", this.dao.findUsers() );
        return "test";
    }

    @RequestMapping( "/test3" )
    public ModelAndView test2( final Model m ) {
        final User user = new User();
        user.setLastName( "Diallo" );
        m.addAttribute( "liste", this.dao.findUsers() );
        return new ModelAndView( "test3" );
    }

}
