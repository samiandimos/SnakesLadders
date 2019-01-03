package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.*;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;


public class FinishScreen implements Screen {

    private TileBoard3 parent;
    public static Stage finishStage;
    private TextureRegionDrawable backGroundTex;
    private Image backGround ;


    public FinishScreen(TileBoard3 tileBoard3, Interpolation smooth) {

        parent = tileBoard3;
        finishStage = new Stage();

        backGroundTex =  new TextureRegionDrawable(new TextureRegion(new Texture("background.jpg")));
        backGround = new Image(backGroundTex);
        backGround.toBack();
        backGround.setFillParent(true); // to fill the screen with the backGround




    }


    @Override
    public void show() {
        backGround.setFillParent(true); // to fill the screen with the backGround
        finishStage.addActor(backGround);

        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Table table = new Table();
        table.setBackground(backGroundTex);
        table.setPosition(0,0 );

        final TextButton BACK_TO_MENU = new TextButton("BACK TO MENU",skin);
        table.add(BACK_TO_MENU);



          // 2 actions in sequence
        BACK_TO_MENU.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(TileBoard3.MENU,Interpolation.smooth);
            }
        });


        finishStage.addAction(sequence(new RunnableAction() {
            @Override
            public void run() {
                StatisticsDisplay.showStatsWindow();

    }
        }, Actions.delay(8f), (new RunnableAction() {
            @Override
            // action to remove the stats from the screen and add a button(BACK TO MENU)

            public void run() {
                BACK_TO_MENU.addAction(fadeIn(.8f));
                finishStage.addActor(BACK_TO_MENU);
                BACK_TO_MENU.setPosition(380,0 );
            }
        }
        )));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        finishStage.addAction(Actions.after(Actions.delay(20f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU,Interpolation.smooth);

            }
        })));

        finishStage.act();
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
