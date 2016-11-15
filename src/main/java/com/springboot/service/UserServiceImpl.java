package com.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDaoInt;
import com.springboot.model.User;

@Service( "userService" )
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    //injection dao
    private UserDaoInt      dao;

    @Autowired
    //injection classe PasswordEncoder
    private PasswordEncoder passwordEncoder;

    //***************************************

    @Override
    public void save( final User user ) {
        //on encode le mot de passe de l'utilisateur durant sa creation
        user.setPassword( this.passwordEncoder.encode( user.getPassword() ) );
        this.dao.saveUserU( user ); //on persiste un utilisateur
    }

    @Override
    public User findBySSO( final String ssoId ) {
        return this.dao.findBySSO( ssoId ); //on recupere un utilisateur grace à son identifiant
    }

    @Override
    public List< User > findAll() {
        // TODO
        return null;
    }

    @Override
    public User findOne( final Integer pId ) {
        // TODO
        return null;
    }

    @Override
    public void update( final User pUtil ) {
        // TODO

    }

    @Override
    public void delete( final Integer pId ) {
        // TODO

    }

    @Override
    public void insert( final User pU ) {
        // TODO

    }

    @Override
    public User findById( final int pId ) {
        // TODO
        return null;
    }

    @Override
    public User getRandom() {
        // TODO
        return null;
    }

    @Override
    public void updateUser( final User pUser ) {
        // TODO

    }

    @Override
    public List< User > listUsers() {
        // TODO
        return null;
    }

    @Override
    public List< User > count() {
        // TODO
        return null;
    }

    @Override
    public void removeUser( final int pId ) {
        // TODO

    }

}
