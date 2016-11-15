package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.dao.UserDaoInt;
import com.springboot.model.User;
import com.springboot.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService uservice;

    @Autowired
    private UserDaoInt  dao;

    @RequestMapping( value = "/login" , method = RequestMethod.GET )
    public String loginGET( final Model m ) {
        final User user = new User();
        m.addAttribute( "user", user );
        m.addAttribute( "lienSeconnecter", "connexion" );
        return "login";
    }

    @RequestMapping( value = "/login" , method = RequestMethod.POST )
    public String loginPOST() {

        return "redirect:/espace_personnel";
    }

    // Inscription *********************************************************
    @RequestMapping( value = "/inscription" , method = RequestMethod.GET )
    // unique � chaque fois, sinon erreur
    public String inscriptionGET( final Model m ) {
        final User user = new User();
        user.setEmail( "contact@email.com" );
        user.setState( "Active" );
        user.setCountry( "FRANCE" );
        user.setLatitude( 63.254568 );
        user.setLongitude( 3.548704 );
        m.addAttribute( "user", user );
        return "inscription";
    }

    @RequestMapping( value = "/inscription" , method = RequestMethod.POST )
    public String inscriptionPOST( @ModelAttribute( "user" ) final User user , final BindingResult result ) {
        this.uservice.save( user );

        return "redirect:/login";
    } // ******************************************************************

}
