package com.tp.spectacle;

public class Reservation {
    enum EtatResa {
        CONFIMER, ANNULER,REFUSER
    }

    private Integer id;
    private Integer spectacleId;
    private String pseudo;
    private boolean confirme;

    public Reservation() {
        confirme = false;
    }

    public Reservation(Integer id, Integer spectacleId, String pseudo, boolean confirme) {
        this.id = id;
        this.spectacleId = spectacleId;
        this.pseudo = pseudo;
        this.confirme = confirme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpectacleId() {
        return spectacleId;
    }

    public void setSpectacleId(Integer spectacleId) {
        this.spectacleId = spectacleId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean isConfirme() {
        return confirme;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }
}
