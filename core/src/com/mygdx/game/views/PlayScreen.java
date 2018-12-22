package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.*;
import static com.mygdx.game.supp.Dice2.tileNum;


public class PlayScreen implements Screen {

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
            PlayScreen.noOfPlayers = noOfPlayers;
        }
        if(noOfPlayers == 2)
        {
            player1 = new Pawn();
            player1.setName("Player1");
            player2 = new Pawn();
            player2.setName("Player2");
            PlayScreen.noOfPlayers = noOfPlayers;
        }
    }

    @Override
    public void show() {


        playStage = new Stage(viewport);
        camera.setToOrtho(false, mapW, mapH);


        camera.update();


        // Setting inside the playStage the players pawns and their score windows
        if (noOfPlayers == 1) {
            player1.setInStage(1000);
            ScoreWindow.createScoreWindow1();
        }
        if (noOfPlayers == 2)
        {
            player1.setInStage(1000);
            ScoreWindow.createScoreWindow1();
            player2.setInStage(2000);
            ScoreWindow.createScoreWindow2();
        }

        // Setting inside the playStage our question popup window
        QuestionPopup.createQuestionWindow();
    }


    // Setting variables (activeInputState and inactiveInputState) for getting the com.badlogic.gdx.Input.Keys
    // manipulating this way when the players are able to play
    // (Used in AnswerButtons listener)

    private int inactiveInputState = Input.Keys.UNKNOWN;
    public static int activeInputState = Input.Keys.SPACE;
    public static int inputActivationState = activeInputState;
    public static String activePlayer = "player1";


    private void checkAndPlay() {

        if (Gdx.input.isKeyJustPressed(inputActivationState))
        {
            ScoreWindow.showScoreWindow(noOfPlayers);

            inputActivationState = inactiveInputState;
            if (noOfPlayers == 2) {
                ScoreWindow.setActiveScoreWindow(activePlayer);
                if (activePlayer.equals("player1")) {
                    System.out.println("Player1 Plays");
                    System.out.println("Player1 Score:" + Score.getPlScore1());
                    Dice2.rollAndMove(player1, player1.getTileNum());

                } else {
                    System.out.println("Player2 Plays");
                    System.out.println("Player 2 Score: " + Score.getPlScore2());
                    Dice2.rollAndMove(player2, player2.getTileNum());
                }

            } else {
                activePlayer = "player1";
                System.out.println("Player1 Plays");
                System.out.println("Player1 Score :" + Score.getPlScore1());
                Dice2.rollAndMove(player1, player1.getTileNum());
            }
        }

        // Runnable action added so the pawn moves first to the
        // 100th tile and after that the EndScreens shows up

        if ( tileNum == 100 ) {
            playStage.addAction(Actions.after(Actions.delay(1f, new RunnableAction(){
                @Override
                public void run() {
//                    tileNum *= 0 ;
                    parent.changeScreen(TileBoard3.FINISHGAME);

                }
            })));
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


        // Debug Actors Z-Index
        if (Gdx.input.isKeyJustPressed(Input.Keys.D))
        {
            for (Actor i : playStage.getActors())
            {
                System.out.println(i.getName() + " HAS INDEX " + i.getZIndex());
            }
        }
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
    public void dispose() {

        parent.dispose();
        playStage.dispose();
        tiledMap.dispose();
        renderer.dispose();
        DiceDisplay.tex.dispose();


    }
}
