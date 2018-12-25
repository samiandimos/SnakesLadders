package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.views.FinishScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.mygdx.game.views.FinishScreen.finishStage;

public class Grades {


    public static Image pl1GradeA(){
        final Sound wellDone = Gdx.audio.newSound(Gdx.files.internal("audio/wellDone.mp3"));
       Texture  gradeTexA =  new Texture(Gdx.files.internal("gradeA.png"));
          Image gradeA = new Image(gradeTexA);

           gradeA.setPosition(380, 100);
        gradeA.addAction(sequence(alpha(0), scaleTo(0f, 0f),
                parallel(fadeIn(1.5f, Interpolation.pow2)),
                scaleTo(1f, 1f, 1.5f, Interpolation.pow5),
                moveTo(380, 160, 1f, Interpolation.swingOut),
                fadeOut(.5f)));
        gradeA.addAction(Actions.after(sequence(fadeOut(2f))));
        finishStage.addAction(Actions.after(Actions.delay(1f, new RunnableAction(){
            @Override
            public void run() {
                wellDone.play();

            }
        })));


           return gradeA ;
    }

    public static Image plGradeB(){

         final Sound notBad = Gdx.audio.newSound(Gdx.files.internal("audio/notBad.mp3"));

        Texture  gradeTexB =  new Texture(Gdx.files.internal("gradeB.png"));
        Image gradeB = new Image(gradeTexB);

            gradeB.setPosition(380, 100);
        gradeB.addAction(sequence(alpha(0), scaleTo(0f, 0f),
                parallel(fadeIn(1.5f, Interpolation.pow2)),
                scaleTo(1f, 1f, 1.5f, Interpolation.pow5),
                moveTo(380, 160, 1f, Interpolation.swingOut),
                fadeOut(.5f)));
        gradeB.addAction(Actions.after(sequence(fadeOut(2f))));
        finishStage.addAction(Actions.after(Actions.delay(1f, new RunnableAction(){
            @Override
            public void run() {
                notBad.play();

            }
        })));


        return gradeB ;
    }


    public static Image plGradeC(){
        final Sound fail = Gdx.audio.newSound(Gdx.files.internal("audio/fail.mp3"));

        Texture  gradeTexC =  new Texture(Gdx.files.internal("gradeC.png"));
        Image gradeC = new Image(gradeTexC);

        gradeC.setOrigin(0, 0);
            gradeC.setPosition(380, 100);
        gradeC.addAction(sequence(alpha(0), scaleTo(0f, 0f),
                parallel(fadeIn(1.5f, Interpolation.pow2)),
                scaleTo(1f, 1f, 1.5f, Interpolation.pow3),
                moveTo(380, 160, 1f, Interpolation.swingOut),
                fadeOut(.5f)));
        gradeC.addAction(Actions.after(sequence(fadeOut(2f))));
        finishStage.addAction(Actions.after(Actions.delay(1f, new RunnableAction(){
            @Override
            public void run() {
                fail.play();

            }
        })));

        return gradeC ;
    }

}



