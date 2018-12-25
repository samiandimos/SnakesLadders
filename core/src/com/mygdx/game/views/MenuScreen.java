package com.mygdx.game.views;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.supp.Pawn;

public class MenuScreen implements Screen {
    public static Stage menuStage;
    private TileBoard3 parent;


    public MenuScreen(TileBoard3 tileBoard3, Interpolation smooth){
        parent = tileBoard3;
        menuStage = new Stage(new ScreenViewport());
//        Gdx.input.setInputProcessor(menuStage);

    }


    @Override
    public void show() {

        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Table table = new Table();
        table.setFillParent(true);
         TextButton onePlayer = new TextButton("One Player",skin);
         TextButton twoPlayers = new TextButton("Two players", skin);

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

                PlayScreen.noOfPlayers = 1;
                parent.changeScreen(TileBoard3.PLAYGAME, Interpolation.smooth);
            }
        });

        twoPlayers.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                PlayScreen.noOfPlayers = 2;
                parent.changeScreen(TileBoard3.PLAYGAME,Interpolation.smooth);
            }
        });
        menuStage.addActor(table);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        menuStage.draw();
    }

    @Override
    public void resize(int width, int height) {

        menuStage.getViewport().update(width, height, true);
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
        menuStage.dispose();
        parent.dispose();
    }
}