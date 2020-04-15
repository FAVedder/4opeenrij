package com.favedder.vieropeenrij.model;

import java.io.Serializable;

/**
 * POJO met gegevens over een speler.
 */
public class Speler implements Serializable {

    private String naam;
    private int score;
    private int beurten;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBeurten() {
        return beurten;
    }

    public void setBeurten(int beurten) {
        this.beurten = beurten;
    }

}
