package com.vitas.vieropeenrij.model;

public class Game {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    
    private String gameName;

    public Game(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
    }
    
    public Speler getSpeler1() {
        return speler1;
    }

    public void setSpeler1(Speler speler1) {
        this.speler1 = speler1;
    }

    public Speler getSpeler2() {
        return speler2;
    }

    public void setSpeler2(Speler speler2) {
        this.speler2 = speler2;
    }

    public Speelveld getSpeelveld() {
        return speelveld;
    }

    public void setSpeelveld(Speelveld speelveld) {
        this.speelveld = speelveld;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    
}
