package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.views.PlayScreen;


/**

 * score window to display the score in a window on the playStage

 *

 * **/


public class ScoreWindow
{
    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

    private static Window scoreWindow1;
    private static Window scoreWindow2;
    private static Label scoreLabel1;
    private static Label scoreLabel2;


// creating a scoreWindow for player 1 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow1() {

        scoreLabel1 = new Label("" + Score.getPlScore1(), skin );
        scoreLabel1.setSize(192, 64);
        scoreLabel1.setPosition(1152 , 832);
        scoreLabel1.setColor(Color.WHITE);
        scoreLabel1.setFontScale(2.5f);
        scoreLabel1.setVisible(true);


        scoreWindow1 = new Window("Player 1",skin);
        scoreWindow1.pack();
        scoreWindow1.setSize(192, 192);
        scoreWindow1.setPosition((PlayScreen.mapW - scoreWindow1.getWidth()) / 100f, (PlayScreen.mapH - scoreWindow1.getHeight()) / 1.30f);
        scoreWindow1.toFront();

        scoreWindow1.row();
        scoreWindow1.add(scoreLabel1);

        scoreWindow1.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreWindow1);

    }

// creating a scoreWindow for player 2 (set up inside the show() method of the PlayScreen class)

    public static void createScoreWindow2() {


        scoreLabel2 = new Label("" + Score.getPlScore2(), skin );
        scoreLabel2.setSize(192, 64);
        scoreLabel2.setPosition(1152, 832);
        scoreLabel2.setColor(Color.BLUE);
        scoreLabel2.setFontScale(3f);
        scoreLabel2.setVisible(true);

        scoreWindow2 = new Window("Player2",skin) ;
        scoreWindow2.pack();
        scoreWindow2.setSize(192, 192);
        scoreWindow2.setPosition((PlayScreen.mapW - scoreWindow2.getWidth()) , (PlayScreen.mapH - scoreWindow2.getHeight()) / 1.30f);
        scoreWindow2.toFront();

        scoreWindow2.row();
        scoreWindow2.add(scoreLabel2);

        scoreWindow2.setColor(1,1,1,0);
        PlayScreen.playStage.addActor(scoreWindow2);

    }

    private static void updateScoreTable1()
    {
        scoreWindow1.addAction(Actions.alpha(1,.8f));
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