package com.springboot.model;

public class User {

    private int    id;

    private String nom;

    private String prenom;

    private String email;

    private String login;

    private String mdp;

    public int getId() {
        return this.id;
    }

    public void setId( final int id ) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom( final String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom( final String prenom ) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail( final String email ) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin( final String login ) {
        this.login = login;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setMdp( final String mdp ) {
        this.mdp = mdp;
    }

}
