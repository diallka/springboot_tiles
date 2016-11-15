package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;

public interface UserDaoInt {

    //exécuté dans data-mapper.xml******************************************
    // @Select( "Select * from utilisateur" )
    public List< User > findUsers();

    /* @Insert( "INSERT INTO Users(ssoId, password, firstName, lastName, email, age, country, latitude, longitude) VALUES"
             + "(#{ssoId},#{password}, #{firstName}, #{lastName}, #{email}, #{age}), #{country}, #{latitude}, #{longitude}))" )
     @Options( useGeneratedKeys = true , keyProperty = "id") */
    public void saveUserU( final User user );

    //***********************************************************************

    //exécuté dans login-mapper.xml******************************************
    // @Select( "Select ssoid, password from users where ssoid=#{ssoId}" )
    public User findBySSO( final String ssoId );

    //**********************************************************************

}
