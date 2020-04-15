package com.favedder.vieropeenrij.controller;

import com.favedder.vieropeenrij.model.Game;
import com.favedder.vieropeenrij.model.Speelveld;
import com.favedder.vieropeenrij.model.Speler;
import com.favedder.vieropeenrij.view.SpelView;
import com.favedder.vieropeenrij.util.SaveGame;

/**
 * Bevat de spellogica.
 */
public class SpelController {

    private EindeMenuController eindeMenuController = new EindeMenuController();

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    private SpelView spelView;

    private int laatsteIndexI; //coordinaat om vier-op-een-rij te kunnen checken
    private int laatsteIndexY; //coordinaat om vier-op-een-rij te kunnen checken
    private char spelerChar; //Speler 1 wordt met een O uitgebeeld, speler 2 met een X;

    //Start een nieuw spel of opgeslagen spel met de ingevoerde spelersobjecten en speelveld
    public void start(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
        spelView = new SpelView(this.speler1, this.speler2, this.speelveld);
        spelloop();
    }

    //Maakt het speelveld 'leeg' (alle chars in de array worden '-')
    void clearSpeelVeld(Speelveld speelveld) {
        char[][] speelVeldArray = speelveld.getSpeelVeld();
        for (int i = 0; i <= speelVeldArray.length - 1; i++) {
            for (int y = 0; y <= speelVeldArray[i].length - 1; y++) {

                speelVeldArray[i][y] = '-';
            }
        }
        speelveld.setSpeelVeld(speelVeldArray);
    }

    //Main loop van het spel, wordt uitgevoerd tot een spel over is of de speler afsluit.
    private void spelloop() {
        while (true) {
            spelView.drawSpeelveld();
            spelView.invoer();
            int invoer = spelView.getInvoer();
            verwerkInvoer(invoer);
            checkWinst();
            checkVol();
            veranderBeurt();
        }
    }

    //Verwerkt de invoer van de speler die aan de beurt is
    private void verwerkInvoer(int invoer) {
        if (invoer == 0) { //Terug naar het hoofdmenu
            HoofdMenuController hoofdMenuController = new HoofdMenuController();
            hoofdMenuController.start();
        } else if (invoer == 8) { //Spel opslaan
            Game game = new Game(speler1, speler2, speelveld);
            SaveGame.saveGame(game);
            System.out.println("Spel opgeslagen.");
        } else {
            invoer--; //Haalt 1 van de invoer af, zodat de invoer overeenkomt met de index van de array

            char[][] speelveldArray = speelveld.getSpeelVeld(); //Haalt de huidige staat van het speelveld op

            if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) { //Zet het juiste symbool voor de speler die aan de beurt is
                spelerChar = 'O';
                speler1.setBeurten(speler1.getBeurten() + 1);
            } else {
                speler2.setBeurten(speler2.getBeurten() + 1);
                spelerChar = 'X';
            }

            //Verander het bovenste vrije vlak in de kolom met het symbool van de speler die aan de beurt is
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

    /* Checkt of de laatste invoer van een speler voor vier op een rij zorgt. 
       Vanuit de laatste zet (coordinaat in de array) wordt zowel horizontaal,
       verticaal als diagonaal gecheckt naar vier spelersymbolen op 1 rij. 
       Omdat een spel alleen gewonnen kan worden vanuit de laatste zet, hoeft
       niet de hele array gecheckt te worden. 
       Als er een 'verkeerd' spelersymbool, leeg symbool of een out of bounds
       error verschijnt, wordt de volgende richting op gecheckt. Als er 4 of meer
       symbolen van de speler die aan de beurt is achter elkaar verschijnen eindigt
       het spel en wint de speler die aan de beurt was. 
       De loops zijn gelabeld, zodat er makkelijk vanuit inner loops gebroken kan worden
       naar een hoger niveau. */
    private void checkWinst() {
        int aantaloprij = 1;
        int indexI = laatsteIndexI;
        int indexY = laatsteIndexY;

        System.out.println("laatsteIndexI = " + laatsteIndexI);
        System.out.println("laatsteIndexY = " + laatsteIndexY);

        //check horizontaal
        HORIZONTAALCHECK:
        while (indexY >= 0 && indexY <= 6) {

            for (int i = 0; i <= 2; i++) {

                try {
                    if (speelveld.getSpeelVeld()[indexI][++indexY] == spelerChar) {
                        System.out.println("Horizontaal + 1 eerste if");
                        aantaloprij++;
                    } else {

                        try {
                            indexY = laatsteIndexY;
                            for (i = 0; i <= 2; i++) {
                                if (speelveld.getSpeelVeld()[indexI][--indexY] == spelerChar) {
                                    System.out.println("Horizontaal + 1 tweede if");
                                    aantaloprij++;
                                } else {
                                    break HORIZONTAALCHECK;
                                }
                            }
                            break HORIZONTAALCHECK;
                        } catch (ArrayIndexOutOfBoundsException exc) {
                            break HORIZONTAALCHECK;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                    indexY = laatsteIndexY;
                    for (i = 0; i <= 2; i++) {
                        if (speelveld.getSpeelVeld()[indexI][--indexY] == spelerChar) {
                            System.out.println("Horizontaal + 1 catch block");
                            aantaloprij++;
                        } else {
                            break HORIZONTAALCHECK;
                        }
                    }
                    break HORIZONTAALCHECK;
                }
            }

        }
        System.out.println("Aantal op rij horizontaal: " + aantaloprij);
        if (aantaloprij >= 4) {
            gewonnen();
        } else {
            aantaloprij = 1;
            indexI = laatsteIndexI;
            indexY = laatsteIndexY;
        }

        //check verticaal
        VERTICAALCHECK:
        while (indexI >= 0 && indexI <= 5) {

            for (int i = 0; i <= 2; i++) {

                try {
                    if (speelveld.getSpeelVeld()[++indexI][indexY] == spelerChar) {
                        System.out.println("Verticaal + 1");
                        aantaloprij++;
                    } else {

                        break VERTICAALCHECK;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break VERTICAALCHECK;
                }
            }

        }
        System.out.println("Aantal op rij verticaal: " + aantaloprij);
        if (aantaloprij >= 4) {
            gewonnen();
        } else {
            aantaloprij = 1;
            indexI = laatsteIndexI;
            indexY = laatsteIndexY;
        }

        //check diagonaal1
        DIAGONAALCHECK1:
        while (indexY >= 0 && indexY <= 6) {

            for (int i = 0; i <= 2; i++) {

                try {
                    if (speelveld.getSpeelVeld()[++indexI][++indexY] == spelerChar) {
                        System.out.println("Diagonaal1 + 1 eerste if");
                        aantaloprij++;
                    } else {

                        try {
                            indexI = laatsteIndexI;
                            indexY = laatsteIndexY;
                            for (i = 0; i <= 2; i++) {
                                if (speelveld.getSpeelVeld()[--indexI][--indexY] == spelerChar) {
                                    System.out.println("Diagonaal1 + 1 tweede if");
                                    aantaloprij++;
                                } else {
                                    break DIAGONAALCHECK1;
                                }
                            }
                            break DIAGONAALCHECK1;
                        } catch (ArrayIndexOutOfBoundsException exc) {
                            break DIAGONAALCHECK1;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                    indexI = laatsteIndexI;
                    System.out.println("indexI" + indexI);
                    indexY = laatsteIndexY;
                    System.out.println("indexY" + indexY);
                    for (i = 0; i <= 2; i++) {
                        try {

                            if (speelveld.getSpeelVeld()[--indexI][--indexY] == spelerChar) {
                                System.out.println("Diagonaal1 + 1 catch block");
                                aantaloprij++;
                            } else {
                                break DIAGONAALCHECK1;
                            }
                        } catch (ArrayIndexOutOfBoundsException exc) {
                            break DIAGONAALCHECK1;
                        }
                    }
                    break DIAGONAALCHECK1;
                }
            }

        }
        System.out.println("Aantal op rij diagonaal1: " + aantaloprij);
        if (aantaloprij >= 4) {
            gewonnen();
        } else {
            aantaloprij = 1;
            indexI = laatsteIndexI;
            indexY = laatsteIndexY;
        }

        //check diagonaal2
        DIAGONAALCHECK2:
        while (indexY >= 0 && indexY <= 6) {

            for (int i = 0; i <= 2; i++) {

                try {
                    if (speelveld.getSpeelVeld()[++indexI][--indexY] == spelerChar) {
                        System.out.println("Diagonaal2 + 1 eerste if");
                        aantaloprij++;
                    } else {

                        try {
                            indexI = laatsteIndexI;
                            indexY = laatsteIndexY;
                            for (i = 0; i <= 2; i++) {
                                if (speelveld.getSpeelVeld()[--indexI][++indexY] == spelerChar) {
                                    System.out.println("Diagonaal2 + 1 tweede if");
                                    aantaloprij++;
                                } else {
                                    break DIAGONAALCHECK2;
                                }
                            }
                            break DIAGONAALCHECK2;
                        } catch (ArrayIndexOutOfBoundsException exc) {
                            break DIAGONAALCHECK2;
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                    try {
                        indexI = laatsteIndexI;
                        indexY = laatsteIndexY;

                        for (i = 0; i <= 2; i++) {
                            if (speelveld.getSpeelVeld()[--indexI][++indexY] == spelerChar) {
                                System.out.println("Diagonaal2 + 1 catch block");
                                aantaloprij++;
                            } else {
                                break DIAGONAALCHECK2;
                            }
                        }
                        break DIAGONAALCHECK2;
                    } catch (ArrayIndexOutOfBoundsException exc) {
                        break DIAGONAALCHECK2;
                    }
                }
            }

        }
        System.out.println("Aantal op rij diagonaal2: " + aantaloprij);
        if (aantaloprij >= 4) {
            gewonnen();
        }

    }

    //Verandert de beurt van de actieve naar de inactieve speler
    private void veranderBeurt() {
        if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            speelveld.setBeurt(Speelveld.Beurt.SPELER2);
        } else {
            speelveld.setBeurt(Speelveld.Beurt.SPELER1);
        }
        spelView.setSpeelveld(speelveld);
    }

    //Checkt of alle vlakken in het speelveld bezet zijn en eindigt dan het spel met een gelijkspel,
    //start tenslotte het eindemenu.
    private void checkVol() {
        int legevelden = 0;

        for (int i = 0; i <= speelveld.getSpeelVeld().length - 1; i++) {
            for (int y = 0; y <= speelveld.getSpeelVeld()[i].length - 1; y++) {
                if (speelveld.getSpeelVeld()[i][y] == '-') {
                    legevelden++;
                }
            }
        }

        if (legevelden == 0) {
            System.out.println("Het speelveld is vol, gelijkspel!");
            eindeMenuController.menu(speler1, speler2);
        }
    }

    //Feliciteerd de speler die gewonnen heeft en start het eindmenu
    private void gewonnen() {
        spelView.drawSpeelveld();
        if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            speler1.setScore(speler1.getScore() + 1);
            System.out.println(speler1.getNaam() + " heeft gewonnen in " + speler1.getBeurten() + " beurten, hoera!");
        } else {
            speler2.setScore(speler2.getScore() + 1);
            System.out.println(speler2.getNaam() + " heeft gewonnen in " + speler2.getBeurten() + " beurten, hoera!");
        }
        eindeMenuController.menu(speler1, speler2);
    }

}
