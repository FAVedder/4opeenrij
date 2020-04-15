package com.favedder.vieropeenrij.model;

import java.io.Serializable;

/**
 * POJO die het speelveld in een array bevat en welke speler aan de beurt is.
 */
public class Speelveld implements Serializable {

    private char[][] speelVeld = new char[6][7];
    private Beurt beurt;

    public enum Beurt {
        SPELER1, SPELER2
    }

    public char[][] getSpeelVeld() {
        return speelVeld;
    }

    public void setSpeelVeld(char[][] speelVeld) {
        //check of het veld de juiste dimensies heeft en maakt een array
        //met de juiste dimensies aan als dat niet zo is
        if (speelVeld.length == 6) {
            for (int i = 1; i < speelVeld.length; i++) {
                if (speelVeld[i].length != 7) {
                    System.out.println("Error");
                    this.speelVeld = new char[6][7];
                } else {
                    this.speelVeld = speelVeld;
                }
            }
        } else {
            System.out.println("error");
            this.speelVeld = new char[6][7];
        }
    }

    public Beurt getBeurt() {
        return beurt;
    }

    public void setBeurt(Beurt beurt) {
        this.beurt = beurt;
    }
}
