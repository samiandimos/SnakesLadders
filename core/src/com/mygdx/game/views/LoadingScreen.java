package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.TileBoard3;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class LoadingScreen implements Screen {

    private  TileBoard3 parent;
    public static Stage loadingStage;
    private Image logo;
    private Sound bip;




    public LoadingScreen(final TileBoard3 tileBoard3, Interpolation smooth) {

        parent = tileBoard3;
        this.loadingStage=new Stage();

        Texture logoTex = new Texture(Gdx.files.internal("logo.png"));
        bip=Gdx.audio.newSound(Gdx.files.internal("audio/intro.mp3"));
        logo = new Image(logoTex);
        logo.setOrigin(450,200 );
        logo.setPosition(450, 200);
        loadingStage.addActor(logo);

    }

    @Override
    public void show() {

        logo.addAction(sequence(alpha(0),scaleTo(0f,0f ),
                parallel(   fadeIn(2f, Interpolation.pow2)),
                scaleTo(1f,1f,2f,Interpolation.pow5 ),
                moveTo(450, 200, 1.5f, Interpolation.swing),
                fadeOut(.5f)));



        loadingStage.addAction(Actions.after(Actions.delay(2f, new RunnableAction() {
            @Override
            public void run() {
                bip.play();

            }
        })));

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.2f, 0.5f, 0.7f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        loadingStage.addAction(Actions.after(Actions.delay(5f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU,Interpolation.circleIn);
            }
        })));

        update(delta);
        loadingStage.draw();




    }


    private void update(float delta) {

        loadingStage.act(delta);

    }


    @Override
    public void resize(int width, int height) {
        loadingStage.getViewport().update(width,height,true);

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
        loadingStage.dispose();
        bip.dispose();

    }
}
