package com.favedder.vieropeenrij.controller;

import com.favedder.vieropeenrij.model.Speelveld;
import com.favedder.vieropeenrij.model.Speler;
import com.favedder.vieropeenrij.view.EindeMenu;

/**
 * Verwerkt de invoer van een speler aan het einde van het spel.
 */
public class EindeMenuController {

    private EindeMenu eindeMenu = new EindeMenu();
    private int optie;

    public void menu(Speler speler1, Speler speler2) {
        eindeMenu.menu();
        optie = eindeMenu.getOptie();
        switch (optie) {
            case 1: //Start nog een spel met dezelfde spelers
                SpelController spelController = new SpelController();
                Speelveld speelveld = new Speelveld();
                spelController.clearSpeelVeld(speelveld);
                spelController.start(speler1, speler2, speelveld);
                break;
            case 2: //Start nog een spel met nieuwe spelers
                NieuwSpelMenuController nieuwSpelMenuController = new NieuwSpelMenuController();
                nieuwSpelMenuController.start();
                break;
            case 3: //Ga terug naar het hoofdmenu
                HoofdMenuController hoofdMenuController = new HoofdMenuController();
                hoofdMenuController.start();
                break;
        }
    }
}
