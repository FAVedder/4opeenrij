package com.vitas.vieropeenrij.util;

import com.vitas.vieropeenrij.controller.HoofdMenuController;
import com.vitas.vieropeenrij.model.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadGame {
    
    public static Game loadGame() {
        LoadGame loadGame = new LoadGame();
        Game game = loadGame.loadTheGame();
        return game;
    }
    
    private Game loadTheGame () {
        Game game = null;
        try (FileInputStream fileInputStream = new FileInputStream(new File("savedgames.txt"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            
            game = (Game) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
                System.out.println("Geen savegame gevonden.");
                HoofdMenuController hoofdMenuController = new HoofdMenuController();
                hoofdMenuController.start();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        return game;
    }
    
}
