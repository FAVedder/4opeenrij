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
        while (true) {
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
                    
                    for (i = 0; i <= 2; i++) {
                        try {
                            indexI = laatsteIndexI;
                            indexY = laatsteIndexY;
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
        } else {
            aantaloprij = 1;
            indexI = laatsteIndexI;
            indexY = laatsteIndexY;
        }
    
    }

    private void veranderBeurt() {
        if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            speelveld.setBeurt(Speelveld.Beurt.SPELER2);
        } else {
            speelveld.setBeurt(Speelveld.Beurt.SPELER1);
        }
        spelView.setSpeelveld(speelveld);
    }

    public void gewonnen() {
        if (speelveld.getBeurt() == Speelveld.Beurt.SPELER1) {
            System.out.println(speler1.getNaam() + " heeft gewonnen,hoera!");
        } else {
            System.out.println(speler2.getNaam() + " heeft gewonnen,hoera!");
        }
        EindeMenuController eindeMenuController = new EindeMenuController();
        eindeMenuController.menu(speler1, speler2);
    }
}
