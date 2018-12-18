package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;


public class DiceSound {

    public static Sound diceShake;


    public static void diceAudio() {

        diceShake = Gdx.audio.newSound(Gdx.files.internal("dice.mp3"));

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            diceShake.play();
        diceShake.dispose();
    }

}

