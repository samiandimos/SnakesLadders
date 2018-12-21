package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.views.PlayScreen;


/**

 * score window to display the score in a window on the playStage

 *

 * **/


public class ScoreWindow
{
    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

    private static Table scoreTable1;
    private static Table scoreTable2;
    private static Label scoreLabel1;
    private static Label scoreLabel2;


// creating a scoreWindow for player 1 (set up inside the show() method of the PlayScreen class)
    public static void createScoreWindow1() {

        // Label
        //*********************************************************
        scoreLabel1 = new Label("" + Score.getPlScore1(), skin );
        Label player1Name = new Label("Player 1", skin);
        Image player1Icon = new Image(new Texture(Gdx.files.internal("icon.png")));

        player1Name.setFontScale(1.8f);

//        scoreLabel1.getGlyphLayout();
        scoreLabel1.setColor(Color.WHITE);
        scoreLabel1.setFontScale(2.5f);
        scoreLabel1.setVisible(true);
        //*********************************************************

        // Table (Actual Window)
        //*********************************************************
        scoreTable1 = new Table();
        scoreTable1.pack();
        scoreTable1.setSize(240, 130);
        scoreTable1.setPosition((PlayScreen.mapW - scoreTable1.getWidth()) / 35f, (PlayScreen.mapH - scoreTable1.getHeight()) / 1.25f);
//        scoreTable1.setZIndex(2000);
//        scoreTable1.toFront();

        // Set Table's background
        Texture texture = new Texture(Gdx.files.internal("banner04.png"));
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(texture));
        scoreTable1.setBackground(drawable);

        scoreTable1.add(player1Name).pad(0,0,30,0);
        scoreTable1.add(player1Icon).pad(0, 10, 30, 0).height(19).width(19);
        scoreTable1.row();
        scoreTable1.add(scoreLabel1).pad(0, 0, 20, 0).colspan(2);

//        scoreTable1.debug();
//        scoreTable1.align(-5);
        scoreTable1.setColor(1,1,1,0);

        PlayScreen.playStage.addActor(scoreTable1);
        //*********************************************************

//        Gdx.input.setInputProcessor(PlayScreen.playStage);
    }

// creating a scoreWindow for player 2 (set up inside the show() method of the PlayScreen class)
    public static void createScoreWindow2() {

// Label
        //*********************************************************
        scoreLabel2 = new Label("" + Score.getPlScore2(), skin );
        Label player2Name = new Label("Player 2", skin);
        Image player2Icon = new Image(new Texture(Gdx.files.internal("icon4.png")));

        player2Name.setFontScale(1.8f);

//        scoreLabel1.getGlyphLayout();
        scoreLabel2.setColor(Color.WHITE);
        scoreLabel2.setFontScale(2.5f);
        scoreLabel2.setVisible(true);
        //*********************************************************

        // Table (Actual Window)
        //*********************************************************
        scoreTable2 = new Table();
        scoreTable2.pack();
        scoreTable2.setSize(240, 130);
        scoreTable2.setPosition((PlayScreen.mapW - scoreTable2.getWidth()) / 1.03f, (PlayScreen.mapH - scoreTable2.getHeight()) / 1.25f);
//        scoreTable1.setZIndex(2000);
//        scoreTable1.toFront();

        // Set Table's background
        Texture texture = new Texture(Gdx.files.internal("banner04.png"));
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(texture));
        scoreTable2.setBackground(drawable);

        scoreTable2.add(player2Name).pad(0,0,30,0);
        scoreTable2.add(player2Icon).pad(0, 10, 30, 0).size(19);
        scoreTable2.row();
        scoreTable2.add(scoreLabel2).pad(0, 0, 20, 0).colspan(2);
//        scoreTable2.debug();
//        scoreTable2.align(-5);
        scoreTable2.setColor(1,1,1,0);

        PlayScreen.playStage.addActor(scoreTable2);
        //*********************************************************

//        Gdx.input.setInputProcessor(PlayScreen.playStage);
    }

    private static void updateScoreTable1()
    {
        scoreTable1.addAction(Actions.alpha(1,.8f));
        scoreLabel1.setText("" + Score.getPlScore1());
    }

    private static void updateScoreWindow2()
    {
        scoreTable2.addAction(Actions.alpha(1, .8f));
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
                updateScoreWindow2();
                break;
        }
    }
}