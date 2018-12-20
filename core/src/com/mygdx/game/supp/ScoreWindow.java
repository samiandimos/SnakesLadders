package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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
    private static Window scoreWindow2;
    private static Label scoreLabel1;
    private static Label scoreLabel2;


// creating a scoreWindow for player 1 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow1() {
//        float scoreWindow1PosX = 128 ;
//        float scoreWindow1PosY = 768 ;

        //*********************************************************
        Image sign = new Image(new Texture(Gdx.files.internal("woodSign192x1006.png")));
        PlayScreen.playStage.addActor(sign);
        sign.setPosition((PlayScreen.mapW - 192) / 200f, (PlayScreen.mapH - 100) / 1.23f);
        sign.scaleBy(-.96f);
        //*********************************************************

        scoreLabel1 = new Label("" + Score.getPlScore1(), skin );
        Label player1Name = new Label("Player1", skin);
        Image playerIcon = new Image(new Texture(Gdx.files.internal("icon_mini.png")));

        player1Name.setFontScale(1.8f);

//        scoreLabel1.getGlyphLayout();
        scoreLabel1.setColor(Color.WHITE);
        scoreLabel1.setFontScale(2.5f);
        scoreLabel1.setVisible(true);


        scoreTable1 = new Table();
        scoreTable1.pack();
        scoreTable1.setSize(192, 192);
        scoreTable1.setPosition((PlayScreen.mapW - scoreTable1.getWidth()) / 35f, (PlayScreen.mapH - scoreTable1.getHeight()) / 1.19f);
        scoreTable1.toFront();

        scoreTable1.add(player1Name).pad(0,0,10,0);
        scoreTable1.add(playerIcon).pad(0, 10, 10, 0);
        scoreTable1.row();
        scoreTable1.add(scoreLabel1);
//        scoreTable1.debug();

//        scoreTable1.align(Align.bottomLeft);

        scoreTable1.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreTable1);

//        Gdx.input.setInputProcessor(PlayScreen.playStage);



    }

// creating a scoreWindow for player 2 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow2() {

//        float scoreWindow2PosX = 1088 ;
//        float scoreWindow2PosY = 768 ;

        scoreLabel2 = new Label(""+ Score.getPlScore2(), skin );
        scoreLabel2.setSize(192, 64);
        scoreLabel2.setPosition(1152, 832);
        scoreLabel2.setColor(Color.BLUE);
        scoreLabel2.setFontScale(3f);
        scoreLabel2.setVisible(true);

        scoreWindow2 = new Window("Player2",skin) ;
        scoreWindow2.pack();
        scoreWindow2.setSize(192, 192);
        scoreWindow2.setPosition((PlayScreen.mapW - scoreWindow2.getWidth()), (PlayScreen.mapH - scoreWindow2.getHeight()) / 1.27f);
        scoreWindow2.toFront();
//        scoreWindow2.setKeepWithinStage(true);
        scoreWindow2.setResizable(false);
        scoreWindow2.setMovable(false);

        scoreWindow2.add(scoreLabel2);

        scoreWindow2.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreWindow2);

//        Gdx.input.setInputProcessor(PlayScreen.playStage);
    }

    private static void updateScoreTable1()
    {
        scoreTable1.addAction(Actions.alpha(1,.8f));
        scoreLabel1.setText("" + Score.getPlScore1());
    }

    private static void updateScoreWindow2()
    {
        scoreWindow2.addAction(Actions.alpha(1, .8f));
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