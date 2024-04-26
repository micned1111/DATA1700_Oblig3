package com.example.data1700_oblig3;

public class Kinobillett {

    private Integer nr;
    private String film;
    private Integer antall;
    private String fornavn;
    private String etternavn;
    private String telefonNr;
    private String epost;

    public Kinobillett(Integer nr, String film, Integer antall, String fornavn, String etternavn, String telefonNr, String epost) {
        this.nr = nr;
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonNr = telefonNr;
        this.epost = epost;
    }

    public Kinobillett() {}

    public Kinobillett(String film, Integer antall, String fornavn, String etternavn, String telefonNr, String epost) {
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonNr = telefonNr;
        this.epost = epost;
    }

    public Integer getNr() {return nr;}
    public void setNr(Integer nr) {this.nr = nr;}

    public String getFilm() {return film;}
    public void setFilm(String film) {this.film = film;}

    public Integer getAntall() {return antall;}
    public void setAntall(Integer antall) {this.antall = antall;}

    public String getFornavn() {return fornavn;}
    public void setFornavn(String fornavn) {this.fornavn = fornavn;}

    public String getEtternavn() {return etternavn;}
    public void setEtternavn(String etternavn) {this.etternavn = etternavn;}

    public String getTelefonNr() {return telefonNr;}
    public void setTelefonNr(String telefonNr) {this.telefonNr = telefonNr;}

    public String getEpost() {return epost;}
    public void setEpost(String epost) {this.epost = epost;}

    public String toString() {
        return nr + " " + film + " " + antall + " " + fornavn + " " + etternavn + " " + telefonNr + " " + epost;
    }
}
