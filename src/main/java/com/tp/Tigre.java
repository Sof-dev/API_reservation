package com.tp;

import com.model.Personne;

public class Tigre {

    private Integer id;
    private String nom;
    private int age;
    private String couleur;

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Tigre(Integer id, String nom, int age, String couleur) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.couleur = couleur;
    }

    public Tigre() {
    }

    public void setNotNull(Tigre newData){
        if(newData.getNom()!=null){
            this.nom = newData.getNom();

        }
        if(newData.getAge() != 0) {
            this.age = newData.getAge();
        }
          if(newData.getCouleur() != null) {
            this.couleur = newData.getCouleur();
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tigre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}
