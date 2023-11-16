package com.tp.spectacle;


public class Spectacle {

    private Integer id;
    private String nom;

    public Spectacle() {
    }

    public Spectacle(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Spectacle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
