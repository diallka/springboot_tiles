package com.springboot.model;

public enum TypeProfilUser {

    USER("USER") , DBA("DBA") , ADMIN("ADMIN");

    String userProfileType;

    private TypeProfilUser( final String userProfileType ) {
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType() {
        return this.userProfileType;
    }
}
