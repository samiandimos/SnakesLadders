package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.*;

import java.util.concurrent.TimeUnit;


public class PlayScreen implements Screen
{
    public static TileBoard3 parent;
    public static Stage playStage;

    private OrthographicCamera camera = new OrthographicCamera();
    private FillViewport viewport = new FillViewport(mapW, mapH, camera);

    public static TiledMap tiledMap = new TmxMapLoader().load("board64B.tmx");
    private OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(tiledMap);

    // Creating an instance of the Class Pawn so to be able to use it's non static methods inside a static context
    private Pawn player1;
    private Pawn player2;
    public static int noOfPlayers;

    // Dimensions of TiledMap
    public static int mapW = 1408;
    public static int mapH = 1152;



    public PlayScreen(TileBoard3 tileBoard3, int noOfPlayers){
        parent = tileBoard3;
        if(noOfPlayers == 1)
        {
            player1 = new Pawn();
            player1.setName("Player1");
//            System.out.println(player1.getName());
            this.noOfPlayers = noOfPlayers;
        }
        if(noOfPlayers == 2)
        {
            player1 = new Pawn();
            player1.setName("Player1");
            player2 = new Pawn();
            player2.setName("Player2");
//            System.out.println(player1.getName() + " \n" + player2.getName());
            this.noOfPlayers = noOfPlayers;
        }
    }

    @Override
    public void show()
    {
        playStage = new Stage(viewport);
        camera.setToOrtho(false, mapW, mapH);
        camera.update();

        // Setting the players pawns in stage
        if (noOfPlayers == 1) {
            player1.setInStage(1000);
        }
        if (noOfPlayers == 2)
        {
            player1.setInStage(1000);
            player2.setInStage(2000);
        }

        // Setting in the playStage our question popup window
    }

    public static String activePlayer = "player1";
    private void checkAndPlay()
    {
        if (noOfPlayers == 2) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                if (activePlayer.equals("player1")) {
                    System.out.println("Player1 Plays");
                    System.out.println("Player1 Score:" + Score.getPlScore1());
                    Dice2.rollAndMove(player1, player1.getTileNum());
//                    QuestionPopup.showQuestionWindow();
//                    activePlayer = "player2";
                } else {
                    System.out.println("Player2 Plays");
                    System.out.println("Player 2 Score: " + Score.getPlScore2());
                    Dice2.rollAndMove(player2, player2.getTileNum());
                }
            }
        }else{
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            {
                activePlayer = "player1";
                System.out.println("Player1 Plays");
                System.out.println("Player1 Score :" + Score.getPlScore1());
                Dice2.rollAndMove(player1, player1.getTileNum());
//                QuestionPopup.showQuestionWindow();
            }
        }
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();

        // Instead of batch and sprites
        playStage.act();
        playStage.draw();

        checkAndPlay();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose()
    {

        playStage.dispose();
        parent.dispose();
        tiledMap.dispose();
        renderer.dispose();
        DiceDisplay.tex.dispose();

    }
}
