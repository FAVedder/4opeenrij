package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Game;
import com.vitas.vieropeenrij.view.HoofdMenu;
import util.LoadGame;

public class HoofdMenuController {

    private HoofdMenu hoofdMenu = new HoofdMenu();
    private int optie;
    
    public void start() {
        hoofdMenu.menu();
        optie = hoofdMenu.getOptie();
        switch(optie) {
            case 1:
                NieuwSpelMenuController nieuwSpelMenuController = new NieuwSpelMenuController();
                nieuwSpelMenuController.start();
                break;
            case 2:
                Game game = LoadGame.loadGame();
                SpelController spelController = new SpelController();
                spelController.start(game.getSpeler1(), game.getSpeler2(), game.getSpeelveld());
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}
