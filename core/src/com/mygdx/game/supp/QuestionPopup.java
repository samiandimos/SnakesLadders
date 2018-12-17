package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;


import static com.badlogic.gdx.scenes.scene2d.actions.Actions.after;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import static com.badlogic.gdx.math.MathUtils.random;

public class QuestionPopup {

    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

    private static Window window;
    private static Image transparentImg;

    public static Window getWindow() {
        return window;
    }


    private static Label questionDisplay(String name) {
        Label label = new Label(name, skin, "title");
        label.setWrap(true);
        return label;
    }


    public static void createQuestionWindow(final int randNr) {
        // Set a darker transparent background
        transparentBackground();


        window = new Window("Question", skin);


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
            final QAStorage alg = new QAStorage(ALGQuestions.algQues[randNr], ALGQuestions.algAns[randNr], ALGQuestions.algAns[randNr][ALGQuestions.algRightAns[randNr]]);

            window.add(questionDisplay(alg.getQuestion())).prefWidth(800).pad(20);
            window.row();

            AnswerButtons.createButton(ALGQuestions.algAns[randNr][0],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][1],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][2],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][3],alg.getRightAnswer());

        }


        window.pack();
        window.setResizable(false);
        window.setMovable(false);
        window.setPosition((PlayScreen.mapW - window.getWidth()) / 2f, ((PlayScreen.mapH - window.getHeight()) / 2f) + 4);
        window.toFront();

        // Start by hiding the window (setting the alpha value zero)

        window.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(window);
        Gdx.input.setInputProcessor(PlayScreen.playStage);

    }

    public static void showQuestionWindow() {
        int randNr = random.nextInt(50);
        createQuestionWindow(randNr);

        window.addAction(after(Actions.fadeIn(.6f, Interpolation.smooth)));
        transparentImg.addAction(sequence(Actions.fadeIn(.6f, Interpolation.smooth)));
    }


    public static void transparentBackground() {
        Texture texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(transparentImg);
    }
}


