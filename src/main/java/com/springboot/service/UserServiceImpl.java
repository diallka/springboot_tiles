package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.model.User;

@Service
//On definit la classe comme Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List< User > findAll() {
        return this.dao.findAll();
    }

    @Override
    public User findOne( final Integer id ) {
        return this.dao.findOne( id );
    }

    @Override
    public void update( final User util ) {
        this.dao.update( util );

    }

    @Override
    public void delete( final Integer id ) {
        this.dao.delete( id );

    }

    @Override
    public void insert( final User u ) {
        this.dao.insert( u );

    }

}
