package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;
import com.vitas.vieropeenrij.view.SpelView;

public class SpelController {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    private SpelView spelView;
    private int laatsteIndexI;
    private int laatsteIndexY;
    private char spelerChar;
       
    
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
            
            
            if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
                spelerChar = 'O';
            } else {
                spelerChar = 'X';
            }

            for (int i = 5; i >= 0; i--) {
                if (speelveldArray[i][invoer] == '-') {
                    speelveldArray[i][invoer] = spelerChar;
                    laatsteIndexI = i;
                    laatsteIndexY = invoer;
                    break;
                }
            }

        }
    }
    
     private void checkWinst() {
        int aantaloprij = 1;
        int indexI = laatsteIndexI;
        int indexY = laatsteIndexY;
        
        //check horizontaal
        while(indexY >= 0 && indexY < 6) {
            
            for(int i = 0; i <=2; i++) {
                
                try {
                    if(speelveld.getSpeelVeld()[indexI][++indexY] == spelerChar) {
                        aantaloprij++;
                    } else {
                        indexY = laatsteIndexY;
                        for(i = 0; i <=2; i++) {
                            if(speelveld.getSpeelVeld()[indexI][--indexY] == spelerChar) {
                                aantaloprij++;
                            } else {
                                break;
                            }
                        }
                        break;
                    }
                } catch(ArrayIndexOutOfBoundsException e) {
                    break;
                }    
            }
            
        }
        
        System.out.println("Aantal op rij: " + aantaloprij);
        
        //check verticaal
        
        
        //check diagonaal1
       
        
        //check diagonaal2
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
