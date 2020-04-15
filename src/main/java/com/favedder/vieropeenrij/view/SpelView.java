package com.favedder.vieropeenrij.view;

import com.favedder.vieropeenrij.model.Speelveld;
import com.favedder.vieropeenrij.model.Speler;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * De UI van een spel dat gespeeld wordt.
 */
public class SpelView {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;

    private int invoer;

    public SpelView(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
    }

    public void drawSpeelveld() {
        String naamHuidigeSpeler;

        if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            naamHuidigeSpeler = speler1.getNaam();
        } else {
            naamHuidigeSpeler = speler2.getNaam();
        }

        System.out.printf("Speler 1: " + speler1.getNaam() + " O (score %3d)\tSpeler 2: " + speler2.getNaam() + " X (score %3d)\n", speler1.getScore(), speler2.getScore());
        System.out.println("Aan de beurt: " + naamHuidigeSpeler);
        System.out.println("---------------");
        System.out.println(" 1 2 3 4 5 6 7");
//        System.out.printf("\t1\t2\t3\t4\t5\t6\t7\n");
        for (int i = 0; i <= speelveld.getSpeelVeld().length - 1; i++) {
            for (int y = 0; y <= speelveld.getSpeelVeld()[i].length - 1; y++) {
                System.out.printf(" " + speelveld.getSpeelVeld()[i][y]);
//                System.out.printf("\t" + speelveld.getSpeelVeld()[i][y]);
            }
            System.out.printf("\n");
        }
        System.out.println("---------------");

    }

    public void invoer() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Kies een kolom, 8 om op te slaan, of 0 om af te sluiten");
            invoer = in.nextInt();
            if (invoer > 8 || invoer < 0) {
                System.out.println("Kies een geldige optie.");
                invoer();
            } else if (invoer == 0 || invoer == 8) {
                //doe niets
            } else if (speelveld.getSpeelVeld()[0][invoer - 1] == 'O' || speelveld.getSpeelVeld()[0][invoer - 1] == 'X') {
                System.out.println("Kolom is vol, kies een andere.");
                drawSpeelveld();
                invoer();
            }
        } catch (InputMismatchException e) {
            System.out.println("Voer een nummer in.");
            invoer();
        }

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

    public int getInvoer() {
        return invoer;
    }

}
