package com.springboot.model;


public class ProfilUser {

    private int    id;

    private String type = TypeProfilUser.USER.getUserProfileType();

    public int getId() {
        return this.id;
    }

    public void setId( final int id ) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType( final String type ) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + this.id;
        result = ( prime * result ) + ( ( this.type == null ) ? 0 : this.type.hashCode() );
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
        if ( !( obj instanceof ProfilUser ) ) {
            return false;
        }
        final ProfilUser other = (ProfilUser) obj;
        if ( this.id != other.id ) {
            return false;
        }
        if ( this.type == null ) {
            if ( other.type != null ) {
                return false;
            }
        } else if ( !this.type.equals( other.type ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + this.id + ",  type=" + this.type + "]";
    }

}
