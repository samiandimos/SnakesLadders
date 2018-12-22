package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.views.PlayScreen;

import static com.mygdx.game.views.PlayScreen.playStage;

public class DiceDisplay {
//    private static int dicePosX = 256;
//    private static int dicePosY = 512;
    private static int dicePosX = 265 * 4;
    private static int dicePosY = 240;
    public static Texture tex;
    public static Image diceImage;

    private static void createDiceImage(int dice)
    {
    }

    public static void updateDiceImage(int dice) {

        tex = new Texture(Gdx.files.internal("dice" + dice + ".png"));
        diceImage.setName("Dice");
        diceImage.setPosition(dicePosX, dicePosY);
        diceImage.setSize(tex.getWidth()/10f,tex.getHeight()/10f);
        diceImage.toBack();

        //        tex.dispose();

            playStage.addActor(diceImage);
            switch (dice) {
                case 1:
                    diceImage = new Image(tex);
                    break;

                case 2:
                    diceImage = new Image(tex);
                    break;

                case 3:
                    diceImage = new Image(tex);
                    break;

                case 4:
                    diceImage = new Image(tex);
                    break;

                case 5:
                    diceImage = new Image(tex);
                    break;

                case 6:
                    diceImage = new Image(tex);
                    break;
            }
    }
}
