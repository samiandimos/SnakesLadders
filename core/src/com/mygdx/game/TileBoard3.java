package com.mygdx.game;

/**
switching between the stages according to the active one
 * as well as the Input Processor
 * */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.views.*;

public class TileBoard3 extends Game {



    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    public PlayScreen playScreen;
    private FinishScreen finishScreen;
    private EndScreen endScreen;

    public static final int LOADINGSCREEN = 0 ;
    public static final int MENU = 1 ;
    public static final int PLAYGAME = 2 ;
    public static final int FINISHGAME = 3 ;
    public static final int ENDGAME = 4 ;

    @Override
    public void create() {

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);

    }

    // noOfPlayers variable updated inside menuScreen

    public static int noOfPlayers;
    public void changeScreen(int screen){
        switch(screen){

            case LOADINGSCREEN:

                if(loadingScreen == null) loadingScreen = new LoadingScreen(this);
                this.setScreen(loadingScreen);
                Gdx.input.setInputProcessor(LoadingScreen.loadingStage);
                LoadingScreen.loadingStage.act();
                break;

            case MENU:

                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                Gdx.input.setInputProcessor(MenuScreen.menuStage);
                MenuScreen.menuStage.act();
                break;

            case PLAYGAME:

                if(playScreen == null) playScreen = new PlayScreen(this);
                this.setScreen(playScreen);
                Gdx.input.setInputProcessor(PlayScreen.playStage);
                PlayScreen.playStage.act();
                break;

            case FINISHGAME:

                if(finishScreen == null) finishScreen = new FinishScreen(this);
                this.setScreen(finishScreen);
                Gdx.input.setInputProcessor(FinishScreen.finishStage);
                FinishScreen.finishStage.act();
                break;

            case ENDGAME:

                if(endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                Gdx.input.setInputProcessor(EndScreen.endStage);
                EndScreen.endStage.act();
                break;
        }
    }


    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {

            Gdx.app.exit();
        }
    }

    @Override
    public void dispose(){

        super.dispose();
        this.getScreen().dispose();

    }
}
