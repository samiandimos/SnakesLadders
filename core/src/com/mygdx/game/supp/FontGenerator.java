package com.mygdx.game.supp;
/**
 * class to generate a better bitmap font for fixing  pixelated score/questions and answers when scaled up
 *
 * **/
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class FontGenerator {

//method to create and customize the font and return it
    public static Label.LabelStyle scoreLabel(){

            // giving the font wanted to the generator
        FreeTypeFontGenerator myGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Unibody_8_Bold.ttf"));
        // creating new parameters to customise the font according to our need
        FreeTypeFontGenerator.FreeTypeFontParameter settings = new FreeTypeFontGenerator.FreeTypeFontParameter();

        settings.size = 20;                            // P
        settings.borderWidth = 1;                      // A
        settings.borderColor.add(Color.BLACK);         // R
        settings.shadowOffsetY = 2;                    // TE
        settings.shadowOffsetX = 1;                    // AME
        settings.shadowColor = new Color(Color.BROWN); //  R

        BitmapFont myFont = myGenerator.generateFont(settings);
        myGenerator.dispose();

        Label.LabelStyle scoreLabelStyle = new Label.LabelStyle();
        scoreLabelStyle.font = myFont;

        return scoreLabelStyle ;
    }
//     for a better question display

    public static Label.LabelStyle textLabelStyle(){


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-Heavy.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 18;
//      parameter.borderWidth = 1;
        parameter.color = Color.GOLDENROD ;
        parameter.shadowColor = Color.BLACK;

//        if (CourseProperties.checkForOop()){
//        parameter.color = Color.GOLDENROD ;
//        parameter.shadowColor = Color.BLACK;
//        }
//        if (CourseProperties.checkForPbl()){
//            parameter.color = Color.FOREST;
//            parameter.shadowColor = Color.BLACK;
//        }                                            // activate this to change color of question
//        if (CourseProperties.checkForAlgebra()){      // according to the course if wanted
//            parameter.color = Color.RED;
//            parameter.shadowColor = Color.BLACK;
//        }
//        parameter.shadowOffsetX = 1;
//        parameter.shadowOffsetY = 1;
//        parameter.shadowColor = new Color(Color.BLACK);
        BitmapFont myFont = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle questionLabelStyle = new Label.LabelStyle();
        questionLabelStyle.font = myFont;

        return questionLabelStyle ;
    }


// method for font to use for displaying statistics and answers

    public static BitmapFont fontForText(){

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-Black.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 20;
//        parameter.borderWidth = 1;
        parameter.color = Color.GOLDENROD;

        BitmapFont myFont1 = generator.generateFont(parameter);
        generator.dispose();
        Label.LabelStyle questionLabelStyle = new Label.LabelStyle();
        questionLabelStyle.font = myFont1;

        return myFont1 ;
    }

    public static Label.LabelStyle statsLabel(){

        FreeTypeFontGenerator myGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lato-Black.ttf"));
        // creating new parameters to customise the font according to our need
        FreeTypeFontGenerator.FreeTypeFontParameter settings = new FreeTypeFontGenerator.FreeTypeFontParameter();

        settings.size = 20;
        settings.borderWidth = 1;
        settings.shadowColor = Color.BLACK;
//        settings.color.add()


        BitmapFont myFont = myGenerator.generateFont(settings);
        myGenerator.dispose();

        Label.LabelStyle statsLabelStyle = new Label.LabelStyle();
        statsLabelStyle.font = myFont;

        return statsLabelStyle ;
    }

}
