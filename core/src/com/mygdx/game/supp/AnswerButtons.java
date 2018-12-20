package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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

     Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
     Sound correct = Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
     Sound wrong = Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));


    public static void createButton(final String text, final String rightAnswer){
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        final Sound correct = Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
        final Sound wrong = Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));
        final Button button = new TextButton(text,skin);
        button.setTransform(true);
        button.scaleBy(.1f);

        QuestionPopup.getWindow().add(button);
        QuestionPopup.getWindow().row();

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                if(text.equals(rightAnswer))
                {
                    correct.play();

                    if(PlayScreen.activePlayer.equals("player1")){
                        Score.setPlScore1(5);
                    }

                    if(PlayScreen.activePlayer.equals("player2")){
                        Score.setPlScore2(5);
                    }

                    button.addAction(parallel(fadeIn(.2f),color(Color.GREEN)));
                    // Here the hiding of the window and its transparency can
                    // be delayed by adding a runnable action through a sequence or after
                    // action in the above button
                    QuestionPopup.hideQuestionWindow();

                } else{

                    wrong.play();

                    if(PlayScreen.activePlayer.equals("player1"))
                    {
                        PlayScreen.activePlayer = "player2";
                    }else{
                        PlayScreen.activePlayer = "player1";
                    }

                    button.addAction(parallel(fadeIn(.2f),color(Color.RED)));
                    QuestionPopup.hideQuestionWindow();
                    System.out.println("this is not the right answer");
                }
                // Unfreezing the input of the game by activating back the SPACE
                // button as the proceeding mean
                PlayScreen.inputActivationState = PlayScreen.activeInputState;
            }
        });

    }

}
