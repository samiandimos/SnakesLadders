package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class TextButtonStyle {

// method to create and customize textButton style , to be able to use my own font for better quest/ans display

    public static Button.ButtonStyle myButtonStyle(){

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));// need a skin to get regionDrawable

       TextButton.TextButtonStyle myTextButtonStyle = new TextButton.TextButtonStyle();
        myTextButtonStyle.font = FontGenerator.fontForText();         // feed it our font
        myTextButtonStyle.up =  skin.getDrawable("button");    // get drawable region for button, need to read
                                                                   // json file and find it!!!

        return myTextButtonStyle;
    }
}
