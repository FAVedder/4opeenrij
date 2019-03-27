package com.vitas.vieropeenrij.view;

import com.vitas.vieropeenrij.model.Speler;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NieuwSpelMenu {

    private Speler speler1;
    private Speler speler2;
    
    public void menu() {
        Scanner in = new Scanner(System.in);
        
        try {         
        System.out.print("Voer naam speler 1 in: ");
        String spelerNaam1 = in.nextLine();
        
        System.out.print("Voer naam speler 2 in: ");
        String spelerNaam2 = in.nextLine();
        
        maakSpelers(spelerNaam1, spelerNaam2);
        }
        catch(InputMismatchException e) {
            System.out.println("Voer een geldige naam in.");
            menu();
        }
    }
    
    public void maakSpelers(String spelerNaam1, String spelerNaam2) {
        speler1 = new Speler();
        speler1.setNaam(spelerNaam1);
        speler1.setScore(0);
        
        speler2 = new Speler();
        speler2.setNaam(spelerNaam2);
        speler2.setScore(0);
    }

    public Speler getSpeler1() {
        return speler1;
    }

    public Speler getSpeler2() {
        return speler2;
    }
    
    
    
}
