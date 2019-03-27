package com.vitas.vieropeenrij.controller;

import com.vitas.vieropeenrij.model.Speelveld;
import com.vitas.vieropeenrij.model.Speler;
import com.vitas.vieropeenrij.view.SpelView;

public class SpelController {

    private Speler speler1;
    private Speler speler2;
    private Speelveld speelveld;
    private SpelView spelView;
    
    
    public void start(Speler speler1, Speler speler2, Speelveld speelveld) {
        this.speler1 = speler1;
        this.speler2 = speler2;
        this.speelveld = speelveld;
        spelView = new SpelView(this.speler1, this.speler2, this.speelveld);
        spelView.view();
    }    
}
