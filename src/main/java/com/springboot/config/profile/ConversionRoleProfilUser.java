package com.springboot.config.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.util.Converter;
import com.springboot.model.ProfilUser;
import com.springboot.service.ProfilUserService;

@Component
public abstract class ConversionRoleProfilUser implements Converter< Object , ProfilUser > {

    @Autowired
    ProfilUserService userProfileServie;

    @Override
    public ProfilUser convert( final Object element ) {
        final Integer id = Integer.parseInt( (String) element );
        final ProfilUser profil = this.userProfileServie.findById( id );
        System.out.println( "Profile : " + profil );
        return profil;
    }

}
