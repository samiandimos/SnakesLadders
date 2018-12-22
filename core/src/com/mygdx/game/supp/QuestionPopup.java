package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;


import static com.badlogic.gdx.math.MathUtils.random;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class QuestionPopup {


    private static Window window;
    private static Image transparentImg;
    private static Texture texture;

    public static Window getWindow() {
        return window;
    }



    private static Label questionDisplay(String name) {
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        Label label = new Label(name, skin, "title");
        label.setWrap(true);
        return label;
    }

    // Setting once inside the stage the transparent background
    private static void transparentBackground() {
        texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(transparentImg);
    }

    // Used in the show() method of the PlayScreen class to create
    // and setup our question window and transparency inside the stage
    private static String windowTitle = "";
    public static void createQuestionWindow()
    {
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        // Set a darker transparent background
        transparentBackground();
        window = new Window(windowTitle, skin);
        // Start by hiding the window (setting the alpha value zero)
        window.setColor(1, 1, 1, 0);


        window.setResizable(false);
        window.setMovable(false);
        PlayScreen.playStage.addActor(window);
    }

    // Updating the elements of the window
    private static void updateQuestionWindow(final int randNr) {

        if (CourseProperties.checkForPbl()) {

            QAStorage pbl = new QAStorage(PBLQuestions.pblQues[randNr], PBLQuestions.pblAns[randNr], PBLQuestions.pblAns[randNr][PBLQuestions.pblRightAns[randNr]]);

            window.add(questionDisplay(pbl.getQuestion())).prefWidth(800).pad(20);
            window.row();

            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][0],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][1],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][2],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][3],pbl.getRightAnswer());

        }


        if (CourseProperties.checkForOop()) {
            QAStorage oop = new QAStorage(OOPQuestions.oopQues[randNr], OOPQuestions.oopAns[randNr], OOPQuestions.oopAns[randNr][OOPQuestions.oopRightAns[randNr]]);

            window.add(questionDisplay(oop.getQuestion())).prefWidth(800).pad(20);
            window.row();

            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][0],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][1],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][2],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][3],oop.getRightAnswer());

        }


        if (CourseProperties.checkForAlgebra()) {
            QAStorage alg = new QAStorage(ALGQuestions.algQues[randNr], ALGQuestions.algAns[randNr], ALGQuestions.algAns[randNr][ALGQuestions.algRightAns[randNr]]);

            window.add(questionDisplay(alg.getQuestion())).prefWidth(800).pad(20);
            window.row();

            AnswerButtons.createButton(ALGQuestions.algAns[randNr][0],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][1],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][2],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][3],alg.getRightAnswer());

        }

//        if (CourseProperties.checkForNone())
//        {
//            window.setVisible(false);
//        }


        window.pack();
        window.setPosition((PlayScreen.mapW - window.getWidth()) / 2f, ((PlayScreen.mapH - window.getHeight()) / 2f) + 4);
        Gdx.input.setInputProcessor(PlayScreen.playStage);
        window.toFront();
        windowTitle = "Player " + PlayScreen.activePlayer;
    }

    // Used in runnable action of movePawn() method
    public static void showQuestionWindow()
    {
        int randNr = random.nextInt(50);
        updateQuestionWindow(randNr);

        if (Dice2.tileNum == 100)
        {
            transparentImg.setVisible(false);
            window.setVisible(false);
        }else {
            transparentImg.setZIndex(3000);
            window.setZIndex(3000);
            transparentImg.addAction(Actions.after(Actions.delay(.1f, Actions.fadeIn(.6f, Interpolation.smooth))));
            window.addAction(Actions.after(Actions.fadeIn(.6f, Interpolation.smooth)));
        }
    }

    // Used in AnswerButtons button listener
    public static void hideQuestionWindow()
    {
        transparentImg.addAction(Actions.after(Actions.fadeOut(.6f, Interpolation.smooth)));
        window.addAction(Actions.after(sequence(Actions.fadeOut(.6f, Interpolation.smooth), new RunnableAction(){
            @Override
            public void run() {
                window.clear();
            }
        })));
    }
}
