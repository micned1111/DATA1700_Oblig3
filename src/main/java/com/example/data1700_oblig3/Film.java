package com.example.data1700_oblig3;

public class Film {

    private Integer filmNr;
    private String tittel;

    public Film() {}

    public Film(Integer filmNr, String tittel) {
        this.filmNr = filmNr;
        this.tittel = tittel;
    }

    public Integer getFilmNr() {return filmNr;}
    public void setFilmNr(Integer filmNr) {this.filmNr = filmNr;}

    public String getTittel() {return tittel;}
    public void setTittel(String tittel) {this.tittel = tittel;}
}
