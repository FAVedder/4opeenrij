package com.vitas.vieropeenrij.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EindeMenu {

    int optie;
    
    public void menu() {
        System.out.println("Het spel is afgelopen. Nog een keer spelen?");
        System.out.println("1. Nog een spel met dezelfde spelers");
        System.out.println("2. Nog een spel met andere spelers");
        System.out.println("3. Terug naar het hoofdmenu");
        System.out.print("Kies een optie: ");
        invoer();
    }
    
    private void invoer() {
        Scanner in = new Scanner(System.in);
        
        try {
            optie = in.nextInt();
            if(optie > 3 || optie < 1) {
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
