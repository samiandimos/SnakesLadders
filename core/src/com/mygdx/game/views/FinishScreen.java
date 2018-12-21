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
import com.mygdx.game.supp.Pawn;
import com.mygdx.game.supp.Score;


import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.mygdx.game.supp.Dice2.tileNum;


public class FinishScreen implements Screen {

    private TileBoard3 parent;
    public static Stage finishStage;
    private Texture bravoTex;
    private Image bravo;
    private Sound cheering;
    private TextureRegionDrawable backGroundTex;
    private Image backGround ;
    private Texture gradeTex1,gradeTex2,gradeTex3  ;
    private Image gradeSheet ;



    public FinishScreen(TileBoard3 tileBoard3) {






        parent=tileBoard3;
        this.finishStage = new Stage();

        cheering=Gdx.audio.newSound(Gdx.files.internal("audio/cheering.mp3"));
        backGroundTex =  new TextureRegionDrawable(new TextureRegion(new Texture("sky.png")));
        backGround = new Image(backGroundTex);
        backGround.toBack();
        backGround.setFillParent(true);// to fill the screen with the backGround

        bravoTex=new Texture(Gdx.files.internal("great1.png"));
        bravo=new Image(bravoTex);
//        bravo.setOrigin(300,200 );
        bravo.setPosition(380, 100);
        bravo.toFront();


////        gradeTex1 =  new Texture(Gdx.files.internal("grade" + Score.plScore1 + ".png"));
////        gradeTex2 =  new Texture(Gdx.files.internal("grade90.png"));
////        gradeTex3 =  new Texture(Gdx.files.internal("grade90.png"));


    }


    @Override
    public void show() {

        finishStage.addActor(backGround);
        finishStage.addActor(bravo);

        cheering.play();
        bravo.addAction(sequence(alpha(0), scaleTo(0f, 0f),
                parallel(fadeIn(2f, Interpolation.pow2)),
                scaleTo(1f, 1f, 2f, Interpolation.pow5),
                moveTo(380, 160, 1.5f, Interpolation.swingOut),
                fadeOut(.5f)));
        bravo.addAction(Actions.after(fadeOut(1f)));



    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        finishStage.addAction(Actions.after(Actions.delay(10f, new RunnableAction() {
            @Override
            public void run() {
//                Pawn.tileNum *= 0;                    // to reset the tileNum for next play
                parent.changeScreen(TileBoard3.MENU);


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
        cheering.dispose();
        bravoTex.dispose();

    }
}
