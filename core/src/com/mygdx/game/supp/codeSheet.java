
//package com.mygdx.game.supp;
//
//
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Window;
//import com.mygdx.game.views.FinishScreen;
//import com.mygdx.game.views.PlayScreen;
//import static com.mygdx.game.supp.StatisticCollector1.*;
//
//
//
//public class StatisticsDisplay {
//
//
//    public static Window statsWindow1;
//    public static Window statsWindow2;
//
//
//
//
//
//    public static void CreatePlayer1StatsWindow() {
//         float Player1Stats        =  (float) (getAnswerRightP1() / getPl1QuestionCounter());
//         float Player1StatsAlgebra =  (float) (getAlgRightP1() / getPl1AlgQuestionsCounter());
//         float Player1StatsOOP     =  (float) (getOopRightP1() / getPl1OopQuestionsCounter());
//         float Player1StatsPBL     =  (float) (getPblRightP1() / getPl1PblQuestionsCounter());
//
//         String NaNCase         = " General answer 0% ";
//         String NaNCaseAlgebra = " Algebra 0% ";
//         String NaNCaseOOP     = " OOP 0% ";
//         String NaNCasePBL     = " PBL 0% ";
//
//         String text1 =  "You answered :" + .2f % Player1Stats * 100 + "% Correct";
//         String text2 =  "Algebra :" + .2f % Player1StatsAlgebra * 100 + "% Correct";
//         String text3 =  "OOP :" + .2f % Player1StatsOOP * 100 + "% Correct";
//         String text4 =  "PBL :" + .2f % Player1StatsPBL * 100 + "% Correct";
//
//
//        statsWindow1 = new Window("", WindowStyle.frameWindowStyle());
//        statsWindow1.setResizable(false);
//        statsWindow1.setKeepWithinStage(true);
//        statsWindow1.setVisible(true);
//        statsWindow1.validate();
//        statsWindow1.toFront();
//
//        Label player1Name = new Label("PLAYER1", FontGenerator.scoreLabel());
//
//        Label player1Score = new Label("Your Score is : "+  Score.getPlScore1() +"", FontGenerator.statsLabel());
////------------------------------------------------------------------------------------------------------------------//
//        Label pl1RightStats = new Label(text1, FontGenerator.statsLabel());
//
//        if (text1.contains("NaN"))     // this to avoid displaying NaN result when  zero/counter
//            pl1RightStats.setText(NaNCase);
//        else pl1RightStats.setText(text1);
//
////------------------------------------------------------------------------------------------------------------------//
//        Label pl1AlgStats = new Label(text2, FontGenerator.statsLabel());
//
//        if (text2.contains("NaN"))
//            pl1AlgStats.setText(NaNCaseAlgebra);
//        else pl1AlgStats.setText(text2);
//
////------------------------------------------------------------------------------------------------------------------//
//        Label pl1OopStats = new Label(text3, FontGenerator.statsLabel());
//
//        if (text3.contains("NaN"))
//            pl1OopStats.setText(NaNCaseOOP);
//        else pl1OopStats.setText(text3);
//
////------------------------------------------------------------------------------------------------------------------//
//        Label pl1PblStats = new Label(text4, FontGenerator.statsLabel());
//
//        if ( text4.contains("NaN") )
//            pl1PblStats.setText(NaNCasePBL);
//        else pl1PblStats.setText(text4);
//
////------------------------------------------------------------------------------------------------------------------//
//
//
//        statsWindow1.add(player1Name).pad(5);
//        player1Name.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(player1Score).pad(5);
//        player1Score.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1RightStats).pad(5);
//        pl1RightStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1AlgStats).pad(5);
//        pl1AlgStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1OopStats).pad(5);
//        pl1OopStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//
//        statsWindow1.add(pl1PblStats).pad(5);
//        pl1PblStats.setColor(Color.WHITE);
//        statsWindow1.row();
//        statsWindow1.pack();
//
//        FinishScreen.finishStage.addActor(statsWindow1);
//
//    }
//    public static void CreatePlayer2StatsWindow() {
//
//         float Player2Stats        = (float) (getAnswerRightP2() / getPl2QuestionCounter());
//         float Player2StatsAlgebra = (float) (getAlgRightP2() / getPl2AlgQuestionsCounter());
//         float Player2StatsOOP     = (float) (getOopRightP2() / getPl2OopQuestionsCounter()) ;
//         float Player2StatsPBL     = (float) (getPblRightP2() / getPl2PblQuestionsCounter());
//
//        String NaNCase         = " General answer 0% ";
//        String NaNCaseAlgebra = " Algebra 0% ";
//        String NaNCaseOOP     = " OOP 0% ";
//        String NaNCasePBL     = " PBL 0% ";
//
//        String text1 =  "You answered :" + (.2f % Player2Stats) * 100 + "% Correct";
//        String text2 =  "Algebra :" + (.2f % Player2StatsAlgebra) * 100 + "% Correct";
//        String text3 =  "OOP :" + (.2f % Player2StatsOOP) * 100 + "% Correct";
//        String text4 =  "PBL :" + (.2f % Player2StatsPBL) * 100 + "% Correct";
//
//        statsWindow2 = new Window("", WindowStyle.frameWindowStyle());
//        statsWindow2.setResizable(false);
//        statsWindow2.setMovable(true);
//        statsWindow2.setKeepWithinStage(true);
//        statsWindow2.setVisible(true);
//        statsWindow2.toFront();
//
//        Label player2Name = new Label("PLAYER2", FontGenerator.scoreLabel());
//
//        Label player2Score = new Label("Your Score is : "+  Score.getPlScore2() +"", FontGenerator.statsLabel());
////------------------------------------------------------------------------------------------------------------------//
//        Label pl2RightStats = new Label("", FontGenerator.statsLabel());
//
//        if (text1.contains("NaN"))     // this to avoid displaying NaN result when  zero/counter
//            pl2RightStats.setText(NaNCase);
//        else pl2RightStats.setText(text1);
//
////------------------------------------------------------------------------------------------------------------------//
//        Label pl2AlgStats = new Label("", FontGenerator.statsLabel());
//
//        if (text2.contains("NaN"))
//            pl2AlgStats.setText(NaNCaseAlgebra);
//        else pl2AlgStats.setText(text2);
//
////------------------------------------------------------------------------------------------------------------------//
//        Label pl2OopStats = new Label("", FontGenerator.statsLabel());
//
//        if (text3.contains("NaN"))
//            pl2OopStats.setText(NaNCaseOOP);
//        else pl2OopStats.setText(text3);
//
////------------------------------------------------------------------------------------------------------------------//
//
//        Label pl2PblStats = new Label("", FontGenerator.statsLabel());
//
//        if ( text4.contains("NaN") )
//            pl2PblStats.setText(NaNCasePBL);
//        else pl2PblStats.setText(text4);
//
////------------------------------------------------------------------------------------------------------------------//
//
//
//
//        statsWindow2.add(player2Name).pad(5);
//        player2Name.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(player2Score).pad(5);
//        player2Score.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2RightStats).pad(5);
//        pl2RightStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2AlgStats).pad(5);
//        pl2AlgStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2OopStats).pad(5);
//        pl2OopStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2PblStats).pad(5);
//        pl2PblStats.setColor(Color.BLUE);
//        statsWindow2.row();
//        statsWindow2.pack();
//
//        FinishScreen.finishStage.addActor(statsWindow2);
//
//    }
//    public static void showStatsWindow() {
//
//        switch (PlayScreen.noOfPlayers){
//            case 1:
//            CreatePlayer1StatsWindow();
//            StatisticsDisplay.statsWindow1.setPosition(380, 150);
//            break;
//        case 2 :
//            CreatePlayer1StatsWindow();
//            StatisticsDisplay.statsWindow1.setPosition(0, 150);
//            CreatePlayer2StatsWindow();
//            StatisticsDisplay.statsWindow2.setPosition(800, 150);
//            break;
//        }
//
//    }
//
//
//
//}
//---------------------------------------------------------------------------------------------------------------------
//package com.mygdx.game.supp;
//
//import com.badlogic.ashley.core.Entity;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.audio.Sound;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.scenes.scene2d.*;
//
//import com.badlogic.gdx.scenes.scene2d.ui.*;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.Timer;
//import com.mygdx.game.views.PlayScreen;
//import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
//import static com.mygdx.game.views.PlayScreen.*;
//
//
//
//public class AnswerButtons {
//
//
//    public static void createButton(final String text, final String rightAnswer) {
//
//        final Sound correct=Gdx.audio.newSound(Gdx.files.internal("audio/correct.mp3"));
//        final Sound wrong=Gdx.audio.newSound(Gdx.files.internal("audio/wrong.mp3"));
//        int space =  Input.Keys.SPACE;
//        final Button button = new TextButton(text,
//                (TextButton.TextButtonStyle) TextButtonStyle.myButtonStyle());// better question/ans text display
//        button.setTransform(false);
//        button.scaleBy(.2f, .2f);
//        button.row();
//        button.pack();
//        QuestionPopup.getWindow().add(button);
//        QuestionPopup.getWindow().row();
//
//
//// click listener to limit the tap count to only 1 click to avoid incrementing the score more then once per click
//        button.addListener(new ClickListener(){
//            @Override
//            public void setTapCountInterval(float tapCountInterval) {
//                if (text.equals(rightAnswer) || !text.equals(rightAnswer))
//                    tapCountInterval = 1 ;
//                setTapCount(1);
//                super.setTapCountInterval(tapCountInterval);
//            }
//        });
//// click listener to control right or wrong answers
//
//        button.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//
//                if (text.equals(rightAnswer) ) {
//                    setTapCountInterval(1);// setting tap count interval to only one click
//
//                    if (PlayScreen.activePlayer.equals( "player1") && getTapCount() == 1 ){
//                        correct.play();
//                        Score.increasePlScore1(5);
//
//                        StatisticCollector1.setAnswerRightP1(1);
//                        StatisticCollector1.setPl1QuestionCounter(1);
//
//                        StatisticCollector1.setAlgRightP1(1, true);// setters with boolean check
//                        StatisticCollector1.setOopRightP1(1, true);// for each course
//                        StatisticCollector1.setPblRightP1(1, true);
//                        StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
//                        StatisticCollector1.setPl1OopQuestionsCounter(1,true);
//                        StatisticCollector1.setPl1PblQuestionsCounter(1,true);
//
//                        ScoreWindow.updateScoreTable1();
//
//                    }
//
//                    if (PlayScreen.activePlayer.equals( "player2") && getTapCount() == 1 ){
//                        correct.play();
//
//                        Score.increasePlScore2(5);
//                        StatisticCollector1.setAnswerRightP2(1);
//                        StatisticCollector1.setPl2QuestionCounter(1);
//
//                        StatisticCollector1.setAlgRightP2(1, true);
//                        StatisticCollector1.setOopRightP2(1, true);
//                        StatisticCollector1.setPblRightP2(1, true);
//
//                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
//                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
//                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);
//
//                        ScoreWindow.updateScoreTable2();
//
//                    }
//                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
//                    QuestionPopup.hideQuestionWindow();
//
//
//                } else {
//
//
//
//                    if (PlayScreen.activePlayer.equals("player1") && getTapCount() == 1 ) {
//                        wrong.play();
//                        StatisticCollector1.setPl1QuestionCounter(1);
//                        StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
//                        StatisticCollector1.setPl1OopQuestionsCounter(1,true);
//                        StatisticCollector1.setPl1PblQuestionsCounter(1,true);
//
//
//                        PlayScreen.activePlayer="player2";
//
//
//                    } else {
//                        wrong.play();
//                        PlayScreen.activePlayer="player1";
//                        StatisticCollector1.setPl2QuestionCounter(1);
//                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
//                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
//                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);
//
//                    }
//
//
//                    button.addAction(parallel(fadeIn(.2f), color(Color.RED)));
//                    QuestionPopup.hideQuestionWindow();
//
//                }
//
//                Timer.schedule(new Timer.Task() {
//                    @Override
//                    public void run() {
//                        inputActivationState = activeInputState;
//                        System.out.println("\nSPACE IS ENABLED AGAIN");
//                    }
//                }, .3f);
//            }
//        });
//    }
//
//
//}
//-------------------------------------------------------------------------------------------------------------------------
//package com.mygdx.game.supp;
//
//
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.scenes.scene2d.actions.Actions;
//import com.badlogic.gdx.scenes.scene2d.ui.Label;
//import com.badlogic.gdx.scenes.scene2d.ui.Window;
//import com.mygdx.game.views.FinishScreen;
//import com.mygdx.game.views.PlayScreen;
//import static com.mygdx.game.supp.StatisticCollector1.*;
//
//
//public class StatisticsDisplay {
//
//
//    public static Window statsWindow1;
//    public static Window statsWindow2;
//
//
////---------------------------------------player2--------------------------------------------------------------
//
//
//
//
//
//
//    public static void CreatePlayer1StatsWindow() {
//        float Player1Stats = (float) getAnswerRightP1() / getPl1QuestionCounter();
//        float Player1StatsAlgebra = (float) getAlgRightP1() / getPl1AlgQuestionsCounter();
//        float Player1StatsOOP     = (float) getOopRightP1() / getPl1OopQuestionsCounter() ;
//        float Player1StatsPBL     = (float) getPblRightP1() / getPl1PblQuestionsCounter();
//        statsWindow1 = new Window("", WindowStyle.frameWindowStyle());
//
//
//        statsWindow1.setMovable(true);
//        statsWindow1.setResizable(false);
//        statsWindow1.setKeepWithinStage(true);
//        statsWindow1.setVisible(true);
//        statsWindow1.toFront();
//
//        Label player1Name = new Label("PLAYER1", FontGenerator.scoreLabel());
//
//        Label player1Score = new Label("Your Score is : " +  Score.getPlScore1()
//                + " \n", FontGenerator.statsLabel());
//
//        Label pl1RightStats = new Label("You answered : " + .2f% Player1Stats * 100
//                + " % Correct\n", FontGenerator.statsLabel());
//
//        Label pl1AlgStats = new Label("You answered ALG : " + .2f% Player1StatsAlgebra * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//        Label pl1OopStats = new Label("You answered OOP : " + .2f% Player1StatsOOP * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//        Label pl1PblStats = new Label("You answered PBL : " + .2f% Player1StatsPBL * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//
//        statsWindow1.add(player1Name).pad(5);
//        player1Name.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(player1Score).pad(5);
//        player1Score.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1RightStats).pad(5);
//        pl1RightStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1AlgStats).pad(5);
//        pl1AlgStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//        statsWindow1.add(pl1OopStats).pad(5);
//        pl1OopStats.setColor(Color.WHITE);
//        statsWindow1.row();
//
//
//        statsWindow1.add(pl1PblStats).pad(5);
//        pl1PblStats.setColor(Color.WHITE);
//        statsWindow1.row();
//        statsWindow1.pack();
//
//        FinishScreen.finishStage.addActor(statsWindow1);
//
//    }
//    public static void CreatePlayer2StatsWindow() {
//
//        float Player2Stats = (float) getAnswerRightP2() / getPl2QuestionCounter();
//        float Player2StatsAlgebra = (float) getAlgRightP2() / getPl2AlgQuestionsCounter();
//        float Player2StatsOOP     = (float) getOopRightP2() / getPl2OopQuestionsCounter() ;
//        float Player2StatsPBL     = (float) getPblRightP2() / getPl2PblQuestionsCounter();
//        statsWindow2 = new Window("", WindowStyle.frameWindowStyle());
//
//        statsWindow2.setResizable(false);
//        statsWindow2.setMovable(true);
////        statsWindow2.setName("player1 Stats");
//        statsWindow2.setKeepWithinStage(true);
//        statsWindow2.setVisible(true);
//        statsWindow2.toFront();
//
//        Label player2Name = new Label("PLAYER2", FontGenerator.scoreLabel());
//
//        Label player2Score = new Label("Your Score is : " +  Score.getPlScore2()
//                + " \n", FontGenerator.statsLabel());
//
//        Label pl2RightStats = new Label("You answered in general : " + .2f% Player2Stats * 100
//                + " % Correct\n", FontGenerator.statsLabel());
//
//
//        Label pl2AlgStats = new Label("You answered ALG : " + .2f% Player2StatsAlgebra * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//        Label pl2OopStats = new Label("You answered OOP : " + .2f% Player2StatsOOP * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//        Label pl2PblStats = new Label("You answered PBL : " + .2f% Player2StatsPBL * 100
//                + " % Correct \n", FontGenerator.statsLabel());
//
//
//        statsWindow2.add(player2Name).pad(5);
//        player2Name.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(player2Score).pad(5);
//        player2Score.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2RightStats).pad(5);
//        pl2RightStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2AlgStats).pad(5);
//        pl2AlgStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2OopStats).pad(5);
//        pl2OopStats.setColor(Color.BLUE);
//        statsWindow2.row();
//
//        statsWindow2.add(pl2PblStats).pad(5);
//        pl2PblStats.setColor(Color.BLUE);
//        statsWindow2.row();
//        statsWindow2.pack();
//
//        FinishScreen.finishStage.addActor(statsWindow2);
//
//    }
//    public static void showStatsWindow() {
//
//        switch (PlayScreen.noOfPlayers){
//            case 1:
//                CreatePlayer1StatsWindow();
//                StatisticsDisplay.statsWindow1.setPosition(380, 150);
//                break;
//            case 2 :
//                CreatePlayer1StatsWindow();
//                StatisticsDisplay.statsWindow1.setPosition(0, 150);
//                CreatePlayer2StatsWindow();
//                StatisticsDisplay.statsWindow2.setPosition(800, 150);
//                break;
//        }
//
//    }
//}
//
//
