package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.mygdx.game.views.PlayScreen;


/**

 * score window to display the score in a window on the playStage

 *

 * **/


public class ScoreWindow {

    private static Table scoreTable1;
    private static Table scoreTable2;
    private static Label scoreLabel1;
    private static Label scoreLabel2;


// creating a scoreWindow for player 1 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow1() {

        Image frame1 = new Image(new Texture(Gdx.files.internal("frame.png")));
        PlayScreen.playStage.addActor(frame1);
        frame1.setPosition(40 ,870);
        frame1.setSize(290, 128);
//        sign.scaleBy(-.96f);


        scoreLabel1 = new Label("" + Score.getPlScore1(), FontGenerator.font() );
        Label player1Name = new Label("Player 1", FontGenerator.font());
//        Image playerIcon1 = new Image(new Texture(Gdx.files.internal("icon_mini.png")));


        player1Name.setFontScale(1.5f);
        player1Name.setPosition(70, 900);
        player1Name.setSize(250, 64);

        scoreLabel1.setColor(Color.WHITE);
        scoreLabel1.setFontScale(1.5f);
        scoreLabel1.setVisible(true);


        scoreTable1 = new Table();
        scoreTable1.pack();
        scoreTable1.setSize(128, 128);
        scoreTable1.setPosition(125,870);

        scoreTable1.toFront();
        scoreTable1.add(player1Name).pad(0,0,10,0);
//        scoreTable1.add(playerIcon1).pad(0, 10, 10, 0);
        scoreTable1.row();
        scoreTable1.add(scoreLabel1);
        scoreTable1.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreTable1);

        Gdx.input.setInputProcessor(PlayScreen.playStage);



    }

// creating a scoreWindow for player 2 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow2() {

        if (PlayScreen.noOfPlayers==2){

            Image frame2 = new Image(new Texture(Gdx.files.internal("frame.png")));
        PlayScreen.playStage.addActor(frame2);
        frame2.setPosition(1080 ,870);
        frame2.setSize(290, 128);}


        scoreLabel2 = new Label("" + Score.getPlScore2(), FontGenerator.font() );
        Label player2Name = new Label("Player 2", FontGenerator.font());
        player2Name.setColor(Color.BLUE.add(0f,.2f , 1f,1f ));
//        Image playerIcon2 = new Image(new Texture(Gdx.files.internal("icon4_mini.png")));


        player2Name.setFontScale(1.5f);
        player2Name.setPosition(1060, 920);
        player2Name.setSize(256, 64);

//        scoreLabel1.getGlyphLayout();
        scoreLabel2.setColor(Color.BLUE.add(0f,.2f , 1f,1f ));
        scoreLabel2.setFontScale(1.5f);
        scoreLabel2.setVisible(true);


        scoreTable2 = new Table();
        scoreTable2.pack();
        scoreTable2.setSize(128 , 576);
        scoreTable2.setPosition(1152,640);
        scoreTable2.toFront();

        scoreTable2.add(player2Name).pad(0,0,10,0);
//        scoreTable2.add(playerIcon2).pad(0, 10, 10, 0);
        scoreTable2.row();
        scoreTable2.add(scoreLabel2);


        scoreTable2.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreTable2);

        Gdx.input.setInputProcessor(PlayScreen.playStage);



    }

    private static void updateScoreTable1() {

        scoreTable1.addAction(Actions.alpha(1,.2f));
        scoreLabel1.setText("" + Score.getPlScore1());
    }
//
    private static void updateScoreTable2() {

        scoreTable2.addAction(Actions.alpha(1,.2f));
        scoreLabel2.setText("" + Score.getPlScore2());
    }

//    private static void updateScoreWindow2()
//    {
//        scoreWindow2.addAction(Actions.alpha(1, .8f));
//        scoreLabel2.setText("" + Score.getPlScore2());
//    }
//    private static void updateScoreWindow1()
//    {
//        scoreWindow1.addAction(Actions.alpha(1, .8f));
//        scoreLabel1.setText("" + Score.getPlScore2());
//    }


// shows the score windows according to nr of players
// Used in the checkAndPlay() method of PlayScreen class

    public static void showScoreWindow(int noOfPlayers)
    {
        switch(noOfPlayers )
        {
            case 1:
                updateScoreTable1();

                break;

            case 2 :
                updateScoreTable1();
                updateScoreTable2();

                break;
        }
    }
}