package com.mygdx.game.supp;
/**
 * class to generate a better bitmap font for fixing  resolution problems
 *
 * **/
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class FontGenerator {


    public static Label.LabelStyle font(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Unibody_8_Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
        parameter.borderWidth = 1;
//        parameter.color = Color.YELLOW;
        parameter.shadowOffsetX = 1;
        parameter.shadowOffsetY = 2;
        parameter.shadowColor = new Color(Color.BROWN);
        BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
        generator.dispose();

        Label.LabelStyle scoreLabelStyle = new Label.LabelStyle();
        scoreLabelStyle.font = font24;



        return scoreLabelStyle ;
    }

//    public static Label.LabelStyle text(){
//
//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-BoldItalic.ttf"));
//        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
////        parameter.size = 20;
//        parameter.borderWidth = 1;
////        parameter.color = Color.YELLOW;
//        parameter.shadowOffsetX = 1;
//        parameter.shadowOffsetY = 2;
//        parameter.shadowColor = new Color(Color.WHITE);
//        BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
//        generator.dispose();
//
//        Label.LabelStyle questionLabelStyle = new Label.LabelStyle();
//        questionLabelStyle.font = font24;
//
//
//
//        return questionLabelStyle ;
//    }

}
