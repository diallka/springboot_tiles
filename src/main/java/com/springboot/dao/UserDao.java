package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;

public interface UserDao {

    public List< User > findAll();

    public User findOne( final Integer id );

    public void update( final User util );

    public void delete( final Integer id );

    public void insert( final User u );
}
