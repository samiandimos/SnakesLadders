package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.mygdx.game.views.*;

public class TileBoard3 extends Game
{

    /** Refactor the Stage as playStage and use **/
//    public static Stage playStage;


    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private PlayScreen playScreen;
    private EndScreen endScreen;

    public static final int MENU = 1;
    public static final int PLAYGAME = 2;
    public static final int ENDGAME = 3;

    @Override
    public void create()
    {
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }

    // noOfPlayers variable updated inside menuScreen
    public static int noOfPlayers;
    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case PLAYGAME:
                if(playScreen == null) playScreen = new PlayScreen(this, noOfPlayers);
//                menuScreen.dispose();
                this.setScreen(playScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                break;
        }
    }


    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }
    }
    @Override
    public void dispose(){
        super.dispose();
    }
}
