package com.github.curriculeon;

import com.github.curriculeon.arcade.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.numberguess.NumberGuessPlayer;

public class MainApplication {
    public static void main(String[] args) {
        NumberGuessPlayer ngp = new NumberGuessPlayer();
        NumberGuessGame ngg = new NumberGuessGame(ngp);
        ngg.play();
    }
}
