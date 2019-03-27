package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;
import com.vitas.vieropeenrij.view.NieuwSpelMenu;

public class NieuwSpelMenuController {

    private NieuwSpelMenu nieuwSpelMenu = new NieuwSpelMenu();
    private Speler speler1;
    private Speler speler2;
    private SpelController spelController = new SpelController();
    
    public void start() {
        nieuwSpelMenu.menu();
        speler1 = nieuwSpelMenu.getSpeler1();
        speler2 = nieuwSpelMenu.getSpeler2();
        Speelveld speelveld = new Speelveld();
        speelveld.clearSpeelVeld();
        speelveld.setBeurt(Speelveld.Beurt.SPELER1);
        spelController.start(speler1, speler2, speelveld);
    }
    
}
