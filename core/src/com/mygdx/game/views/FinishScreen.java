package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.Grades;
import com.mygdx.game.supp.Pawn;
import com.mygdx.game.supp.Score;
import com.mygdx.game.supp.ScoreWindow;


import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.mygdx.game.supp.Dice2.tileNum;


public class FinishScreen implements Screen {

    private TileBoard3 parent;
    public static Stage finishStage;
    private TextureRegionDrawable backGroundTex;
    private Image backGround ;


    public FinishScreen(TileBoard3 tileBoard3, Interpolation smooth) {

        parent = tileBoard3;
        finishStage = new Stage();
        backGroundTex =  new TextureRegionDrawable(new TextureRegion(new Texture("sky.png")));
        backGround = new Image(backGroundTex);
        backGround.toBack();
        backGround.setFillParent(true); // to fill the screen with the backGround

    }


    @Override
    public void show() {


        finishStage.addActor(backGround);

            // display a grade sheet according to the score
//        switch (PlayScreen.noOfPlayers) {
//            case 1:
            if (Score.plScore1 >= 80) {
                finishStage.addActor(Grades.pl1GradeA());
            }

            if (Score.plScore1 < 80 && Score.plScore1 > 50) {
                finishStage.addActor(Grades.plGradeB());
            }

            if (Score.plScore1 <= 50) {
                finishStage.addActor(Grades.plGradeC());
            }
//            break;
//
//            case 2:
//                if (Score.plScore1 >= 80) {
//                    finishStage.addActor(Grades.pl1GradeA());
//                }
//
//                if (Score.plScore1 < 80 && Score.plScore1 > 50) {
//                    finishStage.addActor(Grades.plGradeB());
//                }
//
//                if (Score.plScore1 <= 50) {
//                    finishStage.addActor(Grades.plGradeC());
//                }
//
//
//                if (Score.plScore2 >= 80) {
//                    finishStage.addActor(Grades.pl1GradeA());
//                }
//
//                if (Score.plScore2 < 80 && Score.plScore2 > 50) {
//                    finishStage.addActor(Grades.plGradeB());
//                }
//
//                if (Score.plScore2 <= 50) {
//                    finishStage.addActor(Grades.plGradeC());
//                }

        }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        finishStage.addAction(Actions.after(Actions.delay(10f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU,Interpolation.SwingOut.smooth);

            }
        })));


        update(delta);
        finishStage.draw();
    }



    private void update(float delta) {
        finishStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

        finishStage.getViewport().update(width,height,true);

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
        finishStage.dispose();
    }
}
