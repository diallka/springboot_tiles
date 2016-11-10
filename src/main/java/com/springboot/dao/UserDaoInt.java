package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;

public interface UserDaoInt {

    // @Select( "Select * from utilisateur" )
    public List< User > findUsers();

    public void saveUser( final User u );

}
