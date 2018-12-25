package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.views.PlayScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;



public class AnswerButtons {


     static int correctStats ;
     static int wrongtStats ;
     public static boolean checkForRightAnswer ;



     public static void createButton(final String text, final String rightAnswer) {

        checkForRightAnswer =  text.equals(rightAnswer) ;

        final Sound correct=Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
        final Sound wrong=Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));

//        final Button button=new TextButton(text, skin);

          final Button button = new TextButton(text,
                  (TextButton.TextButtonStyle) TextButtonStyle.myButtonStyle());// better question/ans text display
        button.setTransform(false);
        button.scaleBy(.2f, .2f);
        button.row();
        button.pack();



        QuestionPopup.getWindow().add(button);
        QuestionPopup.getWindow().row();
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (text.equals(rightAnswer)) {

                    correctStats += 1 ;
                    correct.play();

                    if (PlayScreen.activePlayer.equals("player1")) {
                        Score.increasePlScore1(5);
                        ScoreWindow.updateScoreTable1();
                    }

                    if (PlayScreen.activePlayer.equals("player2")) {
                        Score.increasePlScore2(5);
                        ScoreWindow.updateScoreTable2();
                    }

                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
                    // Here the hiding of the window and its transparency can
                    // be delayed by adding a runnable action through a sequence or after
                    // action in the above button
                    QuestionPopup.hideQuestionWindow();

                } else {

                    wrong.play();
                    wrongtStats += 1 ;

                    if (PlayScreen.activePlayer.equals("player1")) {
                        PlayScreen.activePlayer="player2";
                    } else {
                        PlayScreen.activePlayer="player1";
                    }

                    button.addAction(parallel(fadeIn(.2f), color(Color.RED)));
                    QuestionPopup.hideQuestionWindow();
                    System.out.println("this is not the right answer");
                }

                // Unfreezing the input of the game by activating back the SPACE
                // button and letting players play again.
                // Scheduling the above task after a small delay

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        System.out.println("\nSPACE IS ENABLED AGAIN");
                        PlayScreen.inputActivationState = PlayScreen.activeInputState;
                    }
                }, .3f);
            }
        });
     }
}


