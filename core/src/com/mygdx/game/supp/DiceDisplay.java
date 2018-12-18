package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import static com.mygdx.game.views.PlayScreen.playStage;

public class DiceDisplay {
//    private static int dicePosX = 256;
//    private static int dicePosY = 512;
    private static int dicePosX = 265 * 4;
    private static int dicePosY = 240;

    public static Texture tex;

    public static void diceImage(int dice) {

        tex = new Texture(Gdx.files.internal("dice" + dice + ".png"));


        Image img = new Image(tex);
        img.setPosition(dicePosX, dicePosY);
        img.setSize(tex.getWidth()/10f,tex.getHeight()/10f);
//        img.toBack();

//        tex.dispose();

            playStage.addActor(img);
            switch (dice) {
                case 1:
                    img = new Image(tex);
                    break;

                case 2:
                    img = new Image(tex);
                    break;

                case 3:
                    img = new Image(tex);
                    break;

                case 4:
                    img = new Image(tex);
                    break;

                case 5:
                    img = new Image(tex);
                    break;

                case 6:
                    img = new Image(tex);
                    break;

            }

    }
}
