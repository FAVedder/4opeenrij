package com.favedder.vieropeenrij.util;

import com.favedder.vieropeenrij.model.Game;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

/**
 * Utility klasse die een save game kan bewaren middels ObjectOutputStream.
 */
public class SaveGame {

    LocalDateTime localDateTime;

    String speler1Naam;
    String speler2Naam;

    public static void saveGame(Game game) {
        SaveGame saveGame = new SaveGame();
        saveGame.saveTheGame(game);
    }

    private void saveTheGame(Game game) {
        this.localDateTime = LocalDateTime.now();
        this.speler1Naam = game.getSpeler1().getNaam();
        this.speler2Naam = game.getSpeler2().getNaam();

        //wordt nu nog niet gebruikt, maar is handig voor een toekomstige functie die meerdere saves mogelijk maakt
        String gameName = speler1Naam + " vs. " + speler2Naam + ", " + localDateTime;
        game.setGameName(gameName);

        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("savedgames.txt"));
            outputStream.writeObject(game);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
