package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

public class EndScreen implements Screen {
    private  Stage endStage;
    private TileBoard3 parent;

    public EndScreen(TileBoard3 tileBoard3){

        parent = tileBoard3;
        endStage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(endStage);


    }

    @Override
    public void show() {

        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Table table  = new Table();
        table.setFillParent(true);

        TextButton mainMenu = new TextButton("Main Menu",skin);
        TextButton exit = new TextButton("Exit",skin);
        table.add(mainMenu).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(exit).fillX().uniformX();

        mainMenu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

              parent.changeScreen(TileBoard3.MENU);

            }
        });
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.exit();
            }
        });

        endStage.addActor(table);

        endStage.addAction(Actions.after(Actions.delay(4f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU);
            }
        })));
//        table.setBackground(new TextureRegionDrawable (new TextureRegion(new Texture("passed.jpg"))));



    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        endStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        endStage.draw();

        update(delta);
    }

    private void update(float delta) {

        endStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

     endStage.getViewport().update(width,height,true);
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
     endStage.dispose();
     parent.dispose();
    }
}
