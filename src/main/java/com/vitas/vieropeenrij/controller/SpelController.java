package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;
import com.vitas.vieropeenrij.view.SpelView;

public class SpelController {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    private SpelView spelView;
       
    
    public void start(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
        spelView = new SpelView(this.speler1, this.speler2, this.speelveld);
        spelloop();
    }   
    
    private void spelloop() {
        while(true) {
            spelView.drawSpeelveld();
            spelView.invoer();
            int invoer = spelView.getInvoer();
            verwerkInvoer(invoer);
            checkWinst();
            veranderBeurt();
        }
    }
    
    private void verwerkInvoer(int invoer) {
        if (invoer == 0) {
            HoofdMenuController hoofdMenuController = new HoofdMenuController();
            hoofdMenuController.start();
        } else {
            invoer--;
            
            char[][] speelveldArray = speelveld.getSpeelVeld();
            char spelerChar;
            
            if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
                spelerChar = 'O';
            } else {
                spelerChar = 'X';
            }

            for (int i = 5; i >= 0; i--) {
                if (speelveldArray[i][invoer] == '-') {
                    speelveldArray[i][invoer] = spelerChar;
                    break;
                } 
            }

        }
    }
    
     private void checkWinst() {
        //TODO
    }
    
    private void veranderBeurt() {
        if(speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            speelveld.setBeurt(Speelveld.Beurt.SPELER2);
        } else {
            speelveld.setBeurt(Speelveld.Beurt.SPELER1);
        }
        spelView.setSpeelveld(speelveld);
    }
}
