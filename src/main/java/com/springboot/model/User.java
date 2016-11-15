package com.springboot.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {

    private int               id;

    private String            ssoId;

    private String            password;

    private String            firstName;

    private String            lastName;

    private String            email;

    private Date              date_inscription;

    // ********************************************************
    private String            country;

    private int               age;

    private double            latitude;

    private double            longitude;

    // ********************************************************
    private String            state        = Etat.ACTIVE.getState();

    private Set< ProfilUser > userProfiles = new HashSet< ProfilUser >();

    public int getId() {
        return this.id;
    }

    public void setId( final int id ) {
        this.id = id;
    }

    public String getSsoId() {
        return this.ssoId;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry( final String country ) {
        this.country = country;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge( final int age ) {
        this.age = age;
    }

    public Date getDate_inscription() {
        return this.date_inscription;
    }

    public void setDate_inscription( final Date date_inscription ) {
        this.date_inscription = date_inscription;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude( final double latitude ) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude( final double longitude ) {
        this.longitude = longitude;
    }

    public void setSsoId( final String ssoId ) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword( final String password ) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName( final String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName( final String lastName ) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail( final String email ) {
        this.email = email;
    }

    public String getState() {
        return this.state;
    }

    public void setState( final String state ) {
        this.state = state;
    }

    public Set< ProfilUser > getUserProfiles() {
        return this.userProfiles;
    }

    public void setUserProfiles( final Set< ProfilUser > userProfiles ) {
        this.userProfiles = userProfiles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + this.id;
        result = ( prime * result ) + ( ( this.ssoId == null ) ? 0 : this.ssoId.hashCode() );
        return result;
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( !( obj instanceof User ) ) {
            return false;
        }
        final User other = (User) obj;
        if ( this.id != other.id ) {
            return false;
        }
        if ( this.ssoId == null ) {
            if ( other.ssoId != null ) {
                return false;
            }
        } else if ( !this.ssoId.equals( other.ssoId ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + this.id + ", country=" + this.country + ", age=" + this.age + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", ssoId=" + this.ssoId + ", password="
                + this.password + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", state=" + this.state + ", userProfiles=" + this.userProfiles + "]";
    }

}
