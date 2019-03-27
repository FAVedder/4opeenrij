package com.vitas.vieropeenrij.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HoofdMenu {

    private int optie;
    
    public void menu() {
        System.out.println("4 op een rij");
        System.out.println("Kies een optie:");
        System.out.println("1. Nieuw spel");
        System.out.println("2. Stoppen");
        System.out.print("Kies een optie: ");
        invoer();
    }

    private void invoer() {
        Scanner in = new Scanner(System.in);
                
        try {
            optie = in.nextInt();
            if(optie > 2 || optie < 1) {
            System.out.println("Kies een geldige optie.");
            menu();
            } 
        } catch (InputMismatchException e) {
            System.out.println("Voer een nummer in.");
            menu();
        }
        
    }

    public int getOptie() {
        return optie;
    }
    
}
