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
                    correct.play();

                    if (PlayScreen.activePlayer.equals("player1")) {

                        Score.increasePlScore1(5);             // score counter
                        StatisticCollector1.setAnswerRightP1(1);// pl1 right answer counter
                        StatisticCollector1.setPl1QuestionCounter(1);// questions asked counter

                        if (CourseProperties.checkForAlgebra()) {
                            StatisticCollector1.setAlgRightP1(1);
                            StatisticCollector1.setPl1AlgQuestionsCounter(1);// pl1 alg question counter
                        } else if (CourseProperties.checkForOop()) {
                            StatisticCollector1.setOopRightP1(1);
                            StatisticCollector1.setPl1OopQuestionsCounter(1);// pl1 oop question counter
                        } else if (CourseProperties.checkForPbl()) {
                            StatisticCollector1.setPblRightP1(1);
                            StatisticCollector1.setPl1PblQuestionsCounter(1);// pl1 pbl question counter
                        }
                        System.out.printf("number of questions player1 %d\n", StatisticCollector1.getPl1QuestionCounter());

                        System.out.printf("pl1 correct stat %d \n", StatisticCollector1.getAnswerRightP1());
                        System.out.printf("pl1 alg CorrStats stat %d \n", StatisticCollector1.getAlgRightP1());
                        System.out.printf("pl1 oop corrStat %d \n", StatisticCollector1.getOopRightP1());
                        System.out.printf("pl1 pbl stat %d \n", StatisticCollector1.getPblRightP1());

                        System.out.printf("nr alg %d ; nr oop %d ; nr pbl %d ;\n", StatisticCollector1.getPl1AlgQuestionsCounter(),
                                StatisticCollector1.getPl1OopQuestionsCounter(), StatisticCollector1.getPl1PblQuestionsCounter());

                        ScoreWindow.updateScoreTable1();
                    }

                    if (PlayScreen.activePlayer.equals("player2")) {

                        Score.increasePlScore2(5);                 // pl2 score counter
                        StatisticCollector1.setAnswerRightP2(1);   //  pl2 right ans counter
                        StatisticCollector1.setPl2QuestionCounter(1);// pl2  question asked counter

                        if (CourseProperties.checkForAlgebra()) {
                            StatisticCollector1.setAlgRightP2(1);
                            StatisticCollector1.setPl2AlgQuestionsCounter(1);// pl2 alg question counter
                        } else if (CourseProperties.checkForOop()) {
                            StatisticCollector1.setOopRightP2(1);
                            StatisticCollector1.setPl2OopQuestionsCounter(1);// pl2 oop question counter
                        } else if (CourseProperties.checkForPbl()) {
                            StatisticCollector1.setPblRightP2(1);
                            StatisticCollector1.setPl2PblQuestionsCounter(1); // pl2 pbl question counter
                        }

                        System.out.printf("number of questions player2 %d\n", StatisticCollector1.getPl2QuestionCounter());
                        System.out.printf("pl1 correct stat %d \n", StatisticCollector1.getAnswerRightP2());
                        System.out.printf("pl1 alg CorrStats stat %d \n", StatisticCollector1.getAlgRightP2());
                        System.out.printf("pl1 oop corrStat %d \n", StatisticCollector1.getOopRightP2());
                        System.out.printf("pl1 pbl stat %d \n", StatisticCollector1.getPblRightP2());
                        System.out.printf("nr alg %d ; nr oop %d ; nr pbl %d ;\n", StatisticCollector1.getPl2AlgQuestionsCounter(),
                                StatisticCollector1.getPl2OopQuestionsCounter(), StatisticCollector1.getPl2PblQuestionsCounter());

                        ScoreWindow.updateScoreTable2();
                    }


                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
                    // Here the hiding of the window and its transparency can
                    // be delayed by adding a runnable action through a sequence or after
                    // action in the above button
                    QuestionPopup.hideQuestionWindow();
                } else {
                    wrong.play();

                    if (PlayScreen.activePlayer.equals("player1")) {

                        StatisticCollector1.setPl1QuestionCounter(1);// questions asked counter

                        if (CourseProperties.checkForAlgebra()) {
                            StatisticCollector1.setPl1AlgQuestionsCounter(1);// pl1 alg question counter

                        } else if (CourseProperties.checkForOop()) {
                            StatisticCollector1.setPl1OopQuestionsCounter(1);// pl1 oop question counter

                        } else if (CourseProperties.checkForPbl()) {
                            StatisticCollector1.setPl1PblQuestionsCounter(1);// pl1 pbl question counter
                        }

                        System.out.printf("number of questions player1 %d\n", StatisticCollector1.getPl1QuestionCounter());
                        System.out.printf("nr alg %d ; nr oop %d ; nr pbl %d ;\n", StatisticCollector1.getPl1AlgQuestionsCounter(),
                                StatisticCollector1.getPl1OopQuestionsCounter(), StatisticCollector1.getPl1PblQuestionsCounter());

                        PlayScreen.activePlayer="player2";
                    } else {
                        PlayScreen.activePlayer="player1";
                        StatisticCollector1.setPl2QuestionCounter(1);

                        if (CourseProperties.checkForAlgebra()) {
                            StatisticCollector1.setPl2AlgQuestionsCounter(1);// pl2 alg question counter
                        } else if (CourseProperties.checkForOop()) {

                            StatisticCollector1.setPl2OopQuestionsCounter(1);// pl2 oop question counter
                        } else if (CourseProperties.checkForPbl()) {
                            StatisticCollector1.setPl2PblQuestionsCounter(1);// pl2 pbl question counter
                        }
                    }
                    System.out.printf("number of questions player2 %d\n", StatisticCollector1.getPl2QuestionCounter());
                    System.out.printf("nr alg %d ; nr oop %d ; nr pbl %d ;\n", StatisticCollector1.getPl2AlgQuestionsCounter(),
                            StatisticCollector1.getPl2OopQuestionsCounter(), StatisticCollector1.getPl2PblQuestionsCounter());


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
                        PlayScreen.inputActivationState=PlayScreen.activeInputState;
                    }
                }, .3f);
            }
        });
    }
}