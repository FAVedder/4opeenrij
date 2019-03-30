package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;
import com.vitas.vieropeenrij.view.EindeMenu;

public class EindeMenuController {
    private EindeMenu eindeMenu = new EindeMenu();
    private int optie;
    
    public void menu(Speler speler1, Speler speler2) {
        eindeMenu.menu();
        optie = eindeMenu.getOptie();
        switch(optie) {
            case 1:
                SpelController spelController = new SpelController();
                Speelveld speelveld = new Speelveld();
                speelveld.clearSpeelVeld();
                spelController.start(speler1, speler2, speelveld);
                break;
            case 2:
                NieuwSpelMenuController nieuwSpelMenuController = new NieuwSpelMenuController();
                nieuwSpelMenuController.start();
                break;
            case 3:
                HoofdMenuController hoofdMenuController = new HoofdMenuController();
                hoofdMenuController.start();
                break;
        }
    }
}
