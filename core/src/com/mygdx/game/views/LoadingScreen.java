package com.mygdx.game.views;

import com.badlogic.gdx.Screen;
import com.mygdx.game.TileBoard3;

public class LoadingScreen implements Screen {

    private TileBoard3 parent;

    public LoadingScreen(TileBoard3 tileBoard3){
        parent = tileBoard3;
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        parent.changeScreen(TileBoard3.MENU);
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

    }
}
