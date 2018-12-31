//package com.mygdx.game.supp;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.ui.*;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.Timer;
//import com.mygdx.game.views.PlayScreen;
//
//import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
//import static com.mygdx.game.supp.StatisticsCollector.questionHasAlg;
//import static com.mygdx.game.supp.StatisticsCollector.questionHasOop;
//import static com.mygdx.game.supp.StatisticsCollector.questionHasPbl;
//
//
//public class AnswerButtons {
//
////     public static boolean checkForRightAnswer ;
////    public  static boolean questionHasPbl  = CourseProperties.checkForAlgebra() ;
////    public  static boolean questionHasAlg  = CourseProperties.checkForOop() ;
////    public  static boolean questionHasOop  =  CourseProperties.checkForPbl() ;
//
//
//
//    public static void createButton(final String text, final String rightAnswer) {
//
//
//        final Sound correct = Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
//        final Sound wrong = Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));
//
//
//        final Button button = new TextButton(text,
//                (TextButton.TextButtonStyle) TextButtonStyle.myButtonStyle());// better question/ans text display
//        button.setTransform(false);
//        button.scaleBy(.2f, .2f);
//        button.row();
//        button.pack();
//
//
//
//        QuestionPopup.getWindow().add(button);
//        QuestionPopup.getWindow().row();
//        button.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//
//                if (text.equals(rightAnswer)) {
//
//                    correct.play();
//
//                    if (PlayScreen.activePlayer.equals("player1")) {
//
//                        Score.increasePlScore1(5);
//                        StatisticsCollector.IncreasePl1CorrStat(1);
//
//
//                        if (questionHasPbl){
//                            StatisticsCollector.pl1IncreasePblScoreRight(1,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreRight(0,true);
//                            StatisticsCollector.pl1IncreaseOopScoreRight(0,true);
//                        }
//
//                        else if (questionHasOop){
//                            StatisticsCollector.pl1IncreasePblScoreRight(0,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreRight(0,true);
//                            StatisticsCollector.pl1IncreaseOopScoreRight(1,true);
//                        }
//
//                        else  if (questionHasAlg){
//                            StatisticsCollector.pl1IncreasePblScoreRight(0,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreRight(1,true);
//                            StatisticsCollector.pl1IncreaseOopScoreRight(0,true);
//                        }
//
//
//
//                        System.out.printf("pl1 correct stat %d \n",StatisticsCollector.getPl1CorrStats());
//
//                        System.out.printf("pl1 alg CorrStats stat %d \n",StatisticsCollector.getAlgScoreRightPl1());
//                        System.out.printf("pl1 oop corrStat %d \n",StatisticsCollector.getOopScoreRightPl1());
//                        System.out.printf("pl1 pbl stat %d \n",StatisticsCollector.getPblScoreRightPl1());
//
//                        ScoreWindow.updateScoreTable1();
//
//                    }
//
//                    if (PlayScreen.activePlayer.equals("player2")) {
//                        Score.increasePlScore2(5);
//                        StatisticsCollector.IncreasePl2CorrStat(1);
//
//                        if (questionHasPbl){
//                            StatisticsCollector.pl2IncreasePblScoreRight(1,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreRight(0,true);
//                            StatisticsCollector.pl2IncreaseOopScoreRight(0,true);
//                        }
//
//                        else if (questionHasOop){
//                            StatisticsCollector.pl2IncreasePblScoreRight(0,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreRight(0,true);
//                            StatisticsCollector.pl2IncreaseOopScoreRight(1,true);
//                        }
//
//                        else  if (questionHasAlg){
//                            StatisticsCollector.pl2IncreasePblScoreRight(0,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreRight(1,true);
//                            StatisticsCollector.pl2IncreaseOopScoreRight(0,true);
//                        }
//
//                        System.out.printf("pl2 correct stat %d \n",StatisticsCollector.getPl2CorrStats());
//
//
//                        System.out.printf("pl2 alg CorrStats stat %d \n",StatisticsCollector.getAlgScoreRightPl2());
//                        System.out.printf("pl2 oop corrStat %d \n",StatisticsCollector.getOopScoreRightPl2());
//                        System.out.printf("pl2 pbl stat %d \n",StatisticsCollector.getPblScoreRightPl2());
//
//                        ScoreWindow.updateScoreTable2();
//
//                    }
//
//                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
//                    // Here the hiding of the window and its transparency can
//                    // be delayed by adding a runnable action through a sequence or after
//                    // action in the above button
//                    QuestionPopup.hideQuestionWindow();
//
//                } else {
//
//
//                    wrong.play();
//
//
//                    if (PlayScreen.activePlayer.equals("player1")) {
//
//                        StatisticsCollector.IncreasePl1WrongStats(1);
//                        if (questionHasPbl){
//                            StatisticsCollector.pl1IncreasePblScoreWrong(1,true);
//                            StatisticsCollector.pl1IncreaseOopScoreWrong(0,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreWrong(0,true);
//                        }
//
//                        else   if (questionHasOop){
//                            StatisticsCollector.pl1IncreasePblScoreWrong(0,true);
//                            StatisticsCollector.pl1IncreaseOopScoreWrong(1,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreWrong(0,true);
//                        }
//
//                        else    if (questionHasAlg){
//                            StatisticsCollector.pl1IncreasePblScoreWrong(0,true);
//                            StatisticsCollector.pl1IncreaseOopScoreWrong(0,true);
//                            StatisticsCollector.pl1IncreaseAlgScoreWrong(1,true);
//                        }
//
//
//                        System.out.printf("pl1 wrong stat %d\n",StatisticsCollector.getPl1WrongStats());
//
//                        System.out.printf("pl1 alg wrongStats %d \n",StatisticsCollector.getAlgScoreWrongPl1());
//                        System.out.printf("pl1 oop wrongStats %d \n",StatisticsCollector.getOopScoreWrongPl1());
//                        System.out.printf("pl1 pbl wrongStats %d \n",StatisticsCollector.getPblScoreWrongPl1());
//
//                        PlayScreen.activePlayer = "player2" ;
//
//
//
//                    } else {
//                        PlayScreen.activePlayer = "player1" ;
//
//                        StatisticsCollector.IncreasePl2WrongStats(1);
//
//                        if (questionHasPbl){
//                            StatisticsCollector.pl2IncreasePblScoreWrong(1,true);
//                            StatisticsCollector.pl2IncreaseOopScoreWrong(0,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreWrong(0,true);
//                        }
//
//                        else   if (questionHasOop){
//                            StatisticsCollector.pl2IncreasePblScoreWrong(0,true);
//                            StatisticsCollector.pl2IncreaseOopScoreWrong(1,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreWrong(0,true);
//                        }
//
//                        else    if (questionHasAlg){
//                            StatisticsCollector.pl2IncreasePblScoreWrong(0,true);
//                            StatisticsCollector.pl2IncreaseOopScoreWrong(0,true);
//                            StatisticsCollector.pl2IncreaseAlgScoreWrong(1,true);
//                        }
//
//                        System.out.printf("pl2 wrong stat %d\n",StatisticsCollector.getPl2WrongStats());
//
//                        System.out.printf("pl2 alg wrongStats %d \n",StatisticsCollector.getAlgScoreWrongPl2());
//                        System.out.printf("pl2 oop wrongStats %d \n",StatisticsCollector.getOopScoreWrongPl2());
//                        System.out.printf("pl2 pbl wrongStats %d \n",StatisticsCollector.getPblScoreWrongPl2());
//
//                    }
//
//                    button.addAction(parallel(fadeIn(.2f), color(Color.RED)));
//                    QuestionPopup.hideQuestionWindow();
//                    System.out.println("this is not the right answer");
//                }
//
//                // Unfreezing the input of the game by activating back the SPACE
//                // button and letting players play again.
//                // Scheduling the above task after a small delay
//
//                Timer.schedule(new Timer.Task() {
//                    @Override
//                    public void run() {
//                        System.out.println("\nSPACE IS ENABLED AGAIN");
//                        PlayScreen.inputActivationState = PlayScreen.activeInputState;
//                    }
//                }, .3f);
//            }
//        });
//    }
//}
//
//***************************************************************************************************************

