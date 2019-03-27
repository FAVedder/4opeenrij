package com.vitas.vieropeenrij.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HoofdMenu {

    private int optie;
    
    public void menu() {
        System.out.println(" _   _ _                                                  _ _ ");
        System.out.println("| | | (_)                                                (_|_)");
        System.out.println("| | | |_  ___ _ __    ___  _ __     ___  ___ _ __    _ __ _ _ ");
        System.out.println("| | | | |/ _ \\ '__|  / _ \\| '_ \\   / _ \\/ _ \\ '_ \\  | '__| | |");
        System.out.println("\\ \\_/ / |  __/ |    | (_) | |_) | |  __/  __/ | | | | |  | | |");
        System.out.println(" \\___/|_|\\___|_|     \\___/| .__/   \\___|\\___|_| |_| |_|  |_| |");
        System.out.println("                          | |                             _/ |");
        System.out.println("                          |_|                            |__/");
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
