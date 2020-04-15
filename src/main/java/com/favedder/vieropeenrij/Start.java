package com.favedder.vieropeenrij;

import com.favedder.vieropeenrij.controller.HoofdMenuController;

/**
 * Startklasse die de applicatie start en een hoofdmenu klaar zet.
 */
public class Start {

    public static void main(String[] args) {
        HoofdMenuController hoofdMenuController = new HoofdMenuController();
        hoofdMenuController.start();
    }

}
