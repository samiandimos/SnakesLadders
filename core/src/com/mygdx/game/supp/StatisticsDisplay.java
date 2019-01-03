package com.mygdx.game.supp;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.game.views.FinishScreen;
import com.mygdx.game.views.PlayScreen;
import static com.mygdx.game.supp.StatisticCollector1.*;


public class StatisticsDisplay {


    public static Window statsWindow1;
    public static Window statsWindow2;


//---------------------------------------player2--------------------------------------------------------------






    public static void CreatePlayer1StatsWindow() {
         float Player1Stats = (float) getAnswerRightP1() / getPl1QuestionCounter();
         float Player1StatsAlgebra = (float) getAlgRightP1() / getPl1AlgQuestionsCounter();
         float Player1StatsOOP     = (float) getOopRightP1() / getPl1OopQuestionsCounter() ;
         float Player1StatsPBL     = (float) getPblRightP1() / getPl1PblQuestionsCounter();
        statsWindow1 = new Window("", WindowStyle.frameWindowStyle());


        statsWindow1.setMovable(true);
        statsWindow1.setResizable(false);
//        statsWindow1.setName("player1 Stats");
        statsWindow1.setKeepWithinStage(true);
        statsWindow1.setVisible(true);
        statsWindow1.toFront();

        Label player1Name = new Label("PLAYER1", FontGenerator.scoreLabel());

        Label player1Score = new Label("Your Score is : " +  Score.getPlScore1()
                + " \n", FontGenerator.statsLabel());

        Label pl1RightStats = new Label("You answered : " + .2f% Player1Stats * 100
                + " % Correct\n", FontGenerator.statsLabel());

        Label pl1AlgStats = new Label("You answered ALG : " + .2f% Player1StatsAlgebra * 100
                + " % Correct \n", FontGenerator.statsLabel());

        Label pl1OopStats = new Label("You answered OOP : " + .2f% Player1StatsOOP * 100
                + " % Correct \n", FontGenerator.statsLabel());

        Label pl1PblStats = new Label("You answered PBL : " + .2f% Player1StatsPBL * 100
                + " % Correct \n", FontGenerator.statsLabel());


        statsWindow1.add(player1Name).pad(5);
        player1Name.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(player1Score).pad(5);
        player1Score.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1RightStats).pad(5);
        pl1RightStats.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1AlgStats).pad(5);
        pl1AlgStats.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1OopStats).pad(5);
        pl1OopStats.setColor(Color.WHITE);
        statsWindow1.row();


        statsWindow1.add(pl1PblStats).pad(5);
        pl1PblStats.setColor(Color.WHITE);
        statsWindow1.row();
        statsWindow1.pack();

        FinishScreen.finishStage.addActor(statsWindow1);

    }
    public static void CreatePlayer2StatsWindow() {

         float Player2Stats = (float) getAnswerRightP2() / getPl2QuestionCounter();
         float Player2StatsAlgebra = (float) getAlgRightP2() / getPl2AlgQuestionsCounter();
         float Player2StatsOOP     = (float) getOopRightP2() / getPl2OopQuestionsCounter() ;
         float Player2StatsPBL     = (float) getPblRightP2() / getPl2PblQuestionsCounter();
        statsWindow2 = new Window("", WindowStyle.frameWindowStyle());

        statsWindow2.setResizable(false);
        statsWindow2.setMovable(true);
//        statsWindow2.setName("player1 Stats");
        statsWindow2.setKeepWithinStage(true);
        statsWindow2.setVisible(true);
        statsWindow2.toFront();

        Label player2Name = new Label("PLAYER2", FontGenerator.scoreLabel());

        Label player2Score = new Label("Your Score is : " +  Score.getPlScore2()
                + " \n", FontGenerator.statsLabel());

        Label pl2RightStats = new Label("You answered in general : " + .2f% Player2Stats * 100
                + " % Correct\n", FontGenerator.statsLabel());


        Label pl2AlgStats = new Label("You answered ALG : " + .2f% Player2StatsAlgebra * 100
                + " % Correct \n", FontGenerator.statsLabel());

        Label pl2OopStats = new Label("You answered OOP : " + .2f% Player2StatsOOP * 100
                + " % Correct \n", FontGenerator.statsLabel());

        Label pl2PblStats = new Label("You answered PBL : " + .2f% Player2StatsPBL * 100
                + " % Correct \n", FontGenerator.statsLabel());


        statsWindow2.add(player2Name).pad(5);
        player2Name.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(player2Score).pad(5);
        player2Score.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2RightStats).pad(5);
        pl2RightStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2AlgStats).pad(5);
        pl2AlgStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2OopStats).pad(5);
        pl2OopStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2PblStats).pad(5);
        pl2PblStats.setColor(Color.BLUE);
        statsWindow2.row();
        statsWindow2.pack();

        FinishScreen.finishStage.addActor(statsWindow2);

    }
    public static void showStatsWindow() {

        switch (PlayScreen.noOfPlayers){
            case 1:
            CreatePlayer1StatsWindow();
            StatisticsDisplay.statsWindow1.setPosition(380, 150);
            break;
        case 2 :
            CreatePlayer1StatsWindow();
            StatisticsDisplay.statsWindow1.setPosition(0, 150);
            CreatePlayer2StatsWindow();
            StatisticsDisplay.statsWindow2.setPosition(800, 150);
            break;
        }

    }



}