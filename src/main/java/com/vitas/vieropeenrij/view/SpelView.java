package com.vitas.vieropeenrij.view;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;

public class SpelView {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    
    public SpelView(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
    }
    
    public void view() {
        drawSpeelveld();
    }
    
    private void drawSpeelveld() {
        System.out.printf("Speler 1: " + speler1.getNaam() + " (%3d) O\tSpeler 2: " + speler2.getNaam() + " (%3d) X\n", speler1.getScore(), speler2.getScore());
        System.out.println("--------");
        System.out.printf("\t1\t2\t3\t4\t5\t6\t7\n");
        for(int i = 0; i <= speelveld.getSpeelVeld().length - 1; i++) {
            for(int y = 0; y <= speelveld.getSpeelVeld()[i].length - 1; y++) {
                System.out.printf("\t" + speelveld.getSpeelVeld()[i][y]);
            }
        System.out.printf("\n");    
        }
        
    }
    
}
