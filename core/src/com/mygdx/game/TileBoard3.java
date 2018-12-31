package com.mygdx.game;

/**
switching between the stages according to the active one
 * as well as the Input Processor
 * */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Interpolation;
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

        loadingScreen = new LoadingScreen(this, Interpolation.smooth);
        setScreen(loadingScreen);

    }

    // noOfPlayers variable updated inside menuScreen

    public static int noOfPlayers;
    public void changeScreen(int screen, Interpolation smooth){
        switch(screen){

            case LOADINGSCREEN:

                if(loadingScreen == null) loadingScreen = new LoadingScreen(this,Interpolation.fade);
                this.setScreen(loadingScreen);
                LoadingScreen.loadingStage.act();
                Gdx.input.setInputProcessor(LoadingScreen.loadingStage);
                super.dispose();
                System.gc();
                break;

            case MENU:

                if(menuScreen == null) menuScreen = new MenuScreen(this, Interpolation.fade);
                this.setScreen(menuScreen);
                MenuScreen.menuStage.act();
                Gdx.input.setInputProcessor(MenuScreen.menuStage);
                super.dispose();
                System.gc();
                break;

            case PLAYGAME:

                if(playScreen == null) playScreen = new PlayScreen(this, Interpolation.fade);
                this.setScreen(playScreen);
                PlayScreen.playStage.act();
                Gdx.input.setInputProcessor(PlayScreen.playStage);
                super.dispose();
                System.gc();
                break;

            case FINISHGAME:

                if(finishScreen == null) finishScreen = new FinishScreen(this,Interpolation.SwingOut.smooth);
                this.setScreen(finishScreen);
                FinishScreen.finishStage.act();
                Gdx.input.setInputProcessor(FinishScreen.finishStage);
                super.dispose();
                System.gc();
                break;

            case ENDGAME:

                if(endScreen == null) endScreen = new EndScreen(this,Interpolation.fade);
                this.setScreen(endScreen);
                EndScreen.endStage.act();
                Gdx.input.setInputProcessor(EndScreen.endStage);
                super.dispose();
                System.gc();
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
            System.gc();
//            this.getScreen().dispose();


    }
}
