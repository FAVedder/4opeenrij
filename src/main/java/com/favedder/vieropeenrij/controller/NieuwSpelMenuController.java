package com.favedder.vieropeenrij.controller;

import com.favedder.vieropeenrij.model.Speelveld;
import com.favedder.vieropeenrij.model.Speler;
import com.favedder.vieropeenrij.view.NieuwSpelMenu;

/**
 * Verwerkt de invoer van het nieuwe spel menu en maakt een nieuw spel aan.
 */
public class NieuwSpelMenuController {

    private NieuwSpelMenu nieuwSpelMenu = new NieuwSpelMenu();
    private SpelController spelController = new SpelController();

    private Speler speler1;
    private Speler speler2;

    private String spelerNaam1;
    private String spelerNaam2;

    public void start() {
        nieuwSpelMenu.menu();
        spelerNaam1 = nieuwSpelMenu.getSpelerNaam1();
        spelerNaam2 = nieuwSpelMenu.getSpelerNaam2();
        maakSpelers(spelerNaam1, spelerNaam2);
        Speelveld speelveld = new Speelveld();
        spelController.clearSpeelVeld(speelveld);
        speelveld.setBeurt(Speelveld.Beurt.SPELER1);
        spelController.start(speler1, speler2, speelveld);
    }

    //Maak twee nieuwe spelerobjecten aan met de ingevoerde namen
    public void maakSpelers(String spelerNaam1, String spelerNaam2) {
        speler1 = new Speler();
        speler1.setNaam(spelerNaam1);
        speler1.setScore(0);
        speler1.setBeurten(0);

        speler2 = new Speler();
        speler2.setNaam(spelerNaam2);
        speler2.setScore(0);
        speler2.setBeurten(0);
    }

}
