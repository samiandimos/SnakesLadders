package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.after;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


public class AnswerButtons {

    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Image transparentImg;


    public static void createButton(final String text, final String rightAnswer){

        QuestionPopup.transparentBackground();

        Button button = new TextButton(text,skin);
        button.setTransform(true);
        button.scaleBy(.1f);

        QuestionPopup.getWindow().add(button);
        QuestionPopup.getWindow().row();

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                if(text.equals(rightAnswer)){
                    QuestionPopup.getWindow().addAction(Actions.fadeOut(.6f, Interpolation.smooth));
//                    transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    PlayScreen.activePlayer = "player1";

                } else{
                    System.out.println("this is not the right answer");
                }

            }
        });

    }
}
