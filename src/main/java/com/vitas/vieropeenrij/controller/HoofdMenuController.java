package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.view.HoofdMenu;

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
                System.exit(0);
                break;
        }
    }
    
}
