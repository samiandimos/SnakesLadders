//package com.mygdx.game.supp;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.scenes.scene2d.actions.Actions;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import static com.mygdx.game.views.FinishScreen.finishStage;
//
//
//public class Grades {
//
////    static Texture gradeTexA=new Texture(Gdx.files.internal("gradeA.png"));
////    static Texture gradeTexB=new Texture(Gdx.files.internal("gradeB.png"));
////    static Texture gradeTexC=new Texture(Gdx.files.internal("gradeC.png"));
//
//    // these methods will check and return the gradeSheet image  according to the player score
//
//    public static Image pl1GradeA() {
//        Texture gradeTexA=new Texture(Gdx.files.internal("gradeA.png"));
//        Image pl1GradeA = new Image(gradeTexA);
//        Grades.pl1GradeA().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
////        pl1GradeA.toFront();
//        return pl1GradeA;
//    }
//
//    public static Image pl1GradeB() {
//        Texture gradeTexB=new Texture(Gdx.files.internal("gradeB.png"));
//        Image pl1GradeB = new Image(gradeTexB);
//        Grades.pl1GradeB().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
////        pl1GradeB.toFront();
//        return pl1GradeB;
//    }
//
//    public static Image pl1GradeC() {
//        Texture gradeTexC=new Texture(Gdx.files.internal("gradeC.png"));
//        Image pl1GradeC = new Image(gradeTexC);
//        Grades.pl1GradeC().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
////        pl1GradeC.toFront();
//        return pl1GradeC;
//    }
//    //---------------------------------------------player2-------------------------------------------------------
//
//    public static Image pl2GradeA() {
//        Texture gradeTexA = new Texture(Gdx.files.internal("gradeA.png"));
//        Image pl2GradeA = new Image(gradeTexA);
//
//        Grades.pl2GradeA().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
//        pl2GradeA.toFront();
//        return pl2GradeA;
//    }
//
//    public static Image pl2GradeB() {
//        Texture gradeTexB = new Texture(Gdx.files.internal("gradeB.png"));
//        Image pl2GradeB = new Image(gradeTexB);
//
//        Grades.pl2GradeB().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
//        pl2GradeB.toFront();
//        return pl2GradeB;
//    }
//
//    public static Image pl2GradeC() {
//        Texture gradeTexC = new Texture(Gdx.files.internal("gradeC.png"));
//        Image pl2GradeC = new Image(gradeTexC);
//
//        Grades.pl2GradeC().addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.fadeOut(3)));
//
//        pl2GradeC.toFront();
//        return pl2GradeC;
//    }
//}
//
