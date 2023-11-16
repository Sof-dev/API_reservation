package com.model;

public class Personne {
    private String prenom;
    private String nom;
    private Integer id;
    public Personne() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
    public void setNotNull(Personne newData){
        if(newData.getPrenom()!=null){
            this.prenom = newData.getPrenom();

        }
        if(newData.getNom() !=null) {
            this.nom = newData.getNom();
        }
    }

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
}
