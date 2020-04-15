package com.favedder.vieropeenrij.controller;

import com.favedder.vieropeenrij.model.Game;
import com.favedder.vieropeenrij.view.HoofdMenu;
import com.favedder.vieropeenrij.util.LoadGame;

/**
 * Verwerkt de invoer van het hoofdmenu.
 */
public class HoofdMenuController {

    private HoofdMenu hoofdMenu = new HoofdMenu();
    private int optie;

    public void start() {
        hoofdMenu.menu();
        optie = hoofdMenu.getOptie();
        switch (optie) {
            case 1: //Start een nieuw spel
                NieuwSpelMenuController nieuwSpelMenuController = new NieuwSpelMenuController();
                nieuwSpelMenuController.start();
                break;
            case 2: //Laad een gesaved spel
                Game game = LoadGame.loadGame();
                SpelController spelController = new SpelController();
                spelController.start(game.getSpeler1(), game.getSpeler2(), game.getSpeelveld());
                break;
            case 3: //Stop het spel
                System.exit(0);
                break;
        }
    }

}
