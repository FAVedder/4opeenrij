package com.vitas.vieropeenrij.model;

public class Speelveld {
    
    private char[][] speelVeld;

    public Speelveld() {
        speelVeld = new char[7][6];
    }
    
    public char[][] getSpeelVeld() {
        return speelVeld;
    }

    public void setSpeelVeld(char[][] speelVeld) {
        //check of het veld de juiste dimensies heeft
        if(speelVeld.length == 7) {
            for(int i = 1; i < speelVeld.length; i++) {
                if(speelVeld[i].length != 6) {
                    System.out.println("Error");
                    this.speelVeld = new char[7][6];
                } else {
                    this.speelVeld = speelVeld;
                }
            }    
        } else {
            System.out.println("error");
            this.speelVeld = new char[7][6];
        }    
    }
    
}