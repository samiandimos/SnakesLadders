package com.mygdx.game.views;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MenuScreen implements Screen {
    private final Stage stage;
    private TileBoard3 parent;

//    Texture background;

    public MenuScreen(TileBoard3 tileBoard3){
        parent = tileBoard3;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

        Table table = new Table();
        table.setFillParent(true);
//        table.setDebug(true);


        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        final TextButton onePlayer = new TextButton("One Player",skin);
        final TextButton twoPlayers = new TextButton("Two players", skin);

        TextButton exit = new TextButton("Exit",skin);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("background.jpg"))));

        table.add(onePlayer).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(twoPlayers).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(exit).fillX().uniformX();


        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        onePlayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                TileBoard3.noOfPlayers = 1;
                parent.changeScreen(TileBoard3.PLAYGAME);

            }
        });

        twoPlayers.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                TileBoard3.noOfPlayers = 2;
                parent.changeScreen(TileBoard3.PLAYGAME);

            }
        });
        stage.addActor(table);

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        parent.dispose();
    }
}