package com.favedder.vieropeenrij.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Het nieuwe spel menu.
 */
public class NieuwSpelMenu {

    private String spelerNaam1;
    private String spelerNaam2;

    public void menu() {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Voer naam speler 1 in: ");
            spelerNaam1 = in.nextLine();

            System.out.print("Voer naam speler 2 in: ");
            spelerNaam2 = in.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Voer een geldige naam in.");
            menu();
        }
    }

    public String getSpelerNaam1() {
        return spelerNaam1;
    }

    public String getSpelerNaam2() {
        return spelerNaam2;
    }

}
