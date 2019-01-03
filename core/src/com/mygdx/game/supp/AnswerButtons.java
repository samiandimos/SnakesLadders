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
import static com.mygdx.game.views.PlayScreen.*;


public class AnswerButtons {


    public static void createButton(final String text, final String rightAnswer) {

        final Sound correct=Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
        final Sound wrong=Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));
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
                    correct.play();


                   if (PlayScreen.activePlayer.equals( "player1")){
                       Score.increasePlScore1(5);

                       StatisticCollector1.setAnswerRightP1(1);
                       StatisticCollector1.setPl1QuestionCounter(1);

                       StatisticCollector1.setAlgRightP1(1, true);// setters with boolean check
                       StatisticCollector1.setOopRightP1(1, true);// for each course
                       StatisticCollector1.setPblRightP1(1, true);

                       StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
                       StatisticCollector1.setPl1OopQuestionsCounter(1,true);
                       StatisticCollector1.setPl1PblQuestionsCounter(1,true);

                       ScoreWindow.updateScoreTable1();

                   }

                    if (PlayScreen.activePlayer.equals( "player2")){

                        Score.increasePlScore2(5);
                        StatisticCollector1.setAnswerRightP2(1);
                        StatisticCollector1.setPl2QuestionCounter(1);

                        StatisticCollector1.setAlgRightP2(1, true);
                        StatisticCollector1.setOopRightP2(1, true);
                        StatisticCollector1.setPblRightP2(1, true);

                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);

                        ScoreWindow.updateScoreTable2();

                    }
                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
                    QuestionPopup.hideQuestionWindow();


                } else {
                        wrong.play();

                    if (PlayScreen.activePlayer.equals("player1")) {
                        StatisticCollector1.setPl1QuestionCounter(1);
                        StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl1OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl1PblQuestionsCounter(1,true);


                        PlayScreen.activePlayer="player2";


                    } else {
                        PlayScreen.activePlayer="player1";
                        StatisticCollector1.setPl2QuestionCounter(1);
                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);

                    }


                    button.addAction(parallel(fadeIn(.2f), color(Color.RED)));
                    QuestionPopup.hideQuestionWindow();

                }

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        System.out.println("\nSPACE IS ENABLED AGAIN");
                        inputActivationState = activeInputState;
                    }
                }, .3f);
            }
        });
    }
}