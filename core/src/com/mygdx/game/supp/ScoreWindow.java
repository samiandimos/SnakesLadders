package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    // Tables-Windows background
    private static Texture backgroundTexture = new Texture(Gdx.files.internal("frame02.png"));
    private static Drawable tableBackground = new TextureRegionDrawable(new TextureRegion(backgroundTexture));


// creating a scoreWindow for player 1 (set up inside the show() method of the PlayScreen class)
    public static void createScoreWindow1() {

        Label player1Name = new Label("Player 1", FontGenerator.font());
        player1Name.setFontScale(1.2f);

        scoreLabel1 = new Label("" + Score.getPlScore1(), FontGenerator.font() );
        scoreLabel1.setColor(Color.WHITE);
        scoreLabel1.setFontScale(1.5f);

        scoreTable1 = new Table();
        scoreTable1.setBackground(tableBackground);
        scoreTable1.pack();
        scoreTable1.setSize(256, 136);
        scoreTable1.setPosition(30,820);

        scoreTable1.add(player1Name).pad(0,0,10,0);
        scoreTable1.row();
        scoreTable1.add(scoreLabel1).padBottom(10);
        scoreTable1.setColor(1,1,1,0);
//        scoreTable1.debug();

        PlayScreen.playStage.addActor(scoreTable1);
//        Gdx.input.setInputProcessor(PlayScreen.playStage);
    }

// creating a scoreWindow for player 2 (set up inside the show() method of the PlayScreen class)
    public static void createScoreWindow2() {

        Label player2Name = new Label("Player 2", FontGenerator.font());
        player2Name.setColor(Color.BLUE.add(0f,.2f , 1f,1f ));
        player2Name.setFontScale(1.2f);

        scoreLabel2 = new Label("" + Score.getPlScore2(), FontGenerator.font() );
        scoreLabel2.setColor(Color.BLUE.add(0f,.2f , 1f,1f ));
        scoreLabel2.setFontScale(1.5f);

        scoreTable2 = new Table();
        scoreTable2.setBackground(tableBackground);
        scoreTable2.pack();
        scoreTable2.setSize(256 , 136);
        scoreTable2.setPosition(1125,820);

        scoreTable2.add(player2Name).pad(0,0,10,0);
        scoreTable2.row();
        scoreTable2.add(scoreLabel2).padBottom(10);
        scoreTable2.setColor(1,1,1,0);
//        scoreTable2.debug();

        PlayScreen.playStage.addActor(scoreTable2);
//        Gdx.input.setInputProcessor(PlayScreen.playStage);
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