package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class AnswerButtons {

    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Image transparentImg;


    public static void createButton(final String text, final String rightAnswer){

//        QuestionPopup.transparentBackground();

        final Button button = new TextButton(text,skin);
        button.setTransform(true);
        button.scaleBy(.1f);

        QuestionPopup.getWindow().add(button);
        QuestionPopup.getWindow().row();

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                if(text.equals(rightAnswer)){

                    if(PlayScreen.activePlayer.equals("player1")){
                    Score.setPlScore1(5);

                    }

                    if(PlayScreen.activePlayer.equals("player2")){
                        Score.setPlScore2(5);
                    }

                    button.addAction(parallel(fadeIn(.2f),color(Color.GREEN)));
                    QuestionPopup.getWindow().addAction(Actions.fadeOut(1.5f, Interpolation.smooth));
                    QuestionPopup.hideTransparency();
//                    PlayScreen.activePlayer = "player1";

                } else{
                    if(PlayScreen.activePlayer.equals("player1")){
                        PlayScreen.activePlayer = "player2";
                    }else{
                        PlayScreen.activePlayer = "player1";
                    }

                    button.addAction(parallel(fadeIn(.2f),color(Color.RED)));
                    QuestionPopup.getWindow().addAction(Actions.fadeOut(1.5f, Interpolation.smooth));
                    QuestionPopup.hideTransparency();

                    System.out.println("this is not the right answer");
                }

            }
        });

    }

}
