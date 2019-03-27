package com.vitas.vieropeenrij.model;

public class Speelveld {
    
    private char[][] speelVeld = new char[6][7];
    private Beurt beurt;
    public enum Beurt {SPELER1, SPELER2} 

    public char[][] getSpeelVeld() {
        return speelVeld;
    }

    public void setSpeelVeld(char[][] speelVeld) {
        //check of het veld de juiste dimensies heeft
        if(speelVeld.length == 6) {
            for(int i = 1; i < speelVeld.length; i++) {
                if(speelVeld[i].length != 7) {
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
    
    public void clearSpeelVeld() {
        for(int i = 0; i <= speelVeld.length - 1; i++) {
            for(int y = 0; y <=speelVeld[i].length - 1; y++) {
                speelVeld[i][y] = '-';
            }
        }
            
    }
    
    public Beurt getBeurt() {
        return beurt;
    }

    public void setBeurt(Beurt beurt) {
        this.beurt = beurt;
    }
}