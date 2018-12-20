package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.TileBoard3;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class LoadingScreen implements Screen {

    private  TileBoard3 parent;
    private Stage loadingStage;
    private Image logo;
    private Sound bip;
    private BitmapFont font;
    private Batch logoBatch ;
    private Batch text ;

    public LoadingScreen(final TileBoard3 tileBoard3) {

        parent=tileBoard3;
        this.loadingStage=new Stage();
        Gdx.input.setInputProcessor(loadingStage);

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
                parallel(   fadeIn(1.5f, Interpolation.pow2)),
                scaleTo(1f,1f,1.5f,Interpolation.pow5 ),
                moveTo(450, 200, 1.5f, Interpolation.swing)));

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

        loadingStage.addAction(Actions.after(Actions.delay(4f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU);
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
        font.dispose();
        text.dispose();
        parent.dispose();
        logoBatch.dispose();
        loadingStage.dispose();
        bip.dispose();

    }
}
