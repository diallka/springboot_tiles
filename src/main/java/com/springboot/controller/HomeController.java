package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.dao.UserDaoInt;
import com.springboot.model.User;

@Controller
@EnableAutoConfiguration
public class HomeController {

    //    @Autowired
    //    private UserService uService;

    @Autowired
    private UserDaoInt dao;

    @RequestMapping( "/" )
    public String welcome( final Map< String , Object > model ) {
        model.put( "message", "Bienvenue Spring boot et tiles ..." );
        return "home";
    }

    // Inscription *********************************************************
    @RequestMapping( value = "/inscription" , method = RequestMethod.GET )
    // unique � chaque fois, sinon erreur
    public String inscriptionGET( final Model m ) {
        final User util = new User();
        util.setEmail( "contact@email.com" );
        m.addAttribute( "util", util );
        m.addAttribute( "lienSenregistrer", "S'enregistrer" );
        return "inscription";
    }

    @RequestMapping( value = "/inscription" , method = RequestMethod.POST )
    public String inscriptionPOST( @ModelAttribute( "util" ) final User u ) {
        this.dao.saveUser( u );

        return "redirect:/connexion";
    } // ******************************************************************

    // Ajout page d'Authentification****************************************
    // Redirige sur cette page au lancement de l'application en utilisant "/"
    // RequestMapping accepte plusieurs valeurs en utilisant "{}"
    @RequestMapping( value = { "/", "/connexion" } , method = RequestMethod.GET )
    public String connexionGET( final Model m ) {
        m.addAttribute( "util", new User() );
        m.addAttribute( "lienSeconnecter", "connexion" );
        return "connexion";
    }

    @RequestMapping( value = { "/", "/connexion" } , method = RequestMethod.POST )
    public String connexionPOST( final Model m ) {

        return "redirect:/espace_personnel";
    }

    //**********************************************************************
    @RequestMapping( value = "/espace_personnel" , method = RequestMethod.GET )
    public String espace_perso( final Model m ) {

        return "espace_personnel";
    }

    @RequestMapping( "/tests" )
    public String test( final Model m ) {
        m.addAttribute( "utilisateurs", this.dao.findUsers() );
        return "test";
    }

    @RequestMapping( "/test3" )
    public ModelAndView test2() {
        return new ModelAndView( "test3" );
    }

}
