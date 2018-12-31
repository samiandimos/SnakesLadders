//package com.mygdx.game.supp;
//
//
//import com.mygdx.game.views.PlayScreen;
//
//import static com.mygdx.game.TileBoard3.noOfPlayers;
//import static com.mygdx.game.views.FinishScreen.finishStage;
//
//public class GradeSheetSwitch {
//
//
//
////        ------------------------------ for 1st player-------------------------------------//
//
//    public static void gradePlayer1() {
//
//            if (Score.getPlScore1() >= 90) {
//
//                finishStage.addActor(GradesSetter.getGradeA());
//                GradesSetter.getGradeA().setPosition(380, 10);
//            }
//
//            if (Score.getPlScore1() < 90 && Score.getPlScore1() >= 60) {
//
//                finishStage.addActor(GradesSetter.getGradeB());
//                GradesSetter.getGradeB().setPosition(380, 10);
//            }
//
//            if (Score.getPlScore1() < 60) {
//
//                finishStage.addActor(GradesSetter.getGradeC());
//                GradesSetter.getGradeC().setPosition(380, 10);
//            }
//    }
//
////        ------------------------------ for 2nd player-------------------------------------//
//
//    public static void gradePlayer2() {
//
//            if (Score.getPlScore2() >= 90) {
//
//                finishStage.addActor(GradesSetter.getGradeA1());
//                GradesSetter.getGradeA1().setPosition(700, 10);
//            }
//
//            if (Score.getPlScore2() < 90 && Score.getPlScore2() >= 60) {
//
//                finishStage.addActor(GradesSetter.getGradeB1());
//                GradesSetter.getGradeB1().setPosition(700, 10);
//            }
//
//            if (Score.getPlScore2() < 60) {
//
//                finishStage.addActor(GradesSetter.getGradeC1());
//                GradesSetter.getGradeC1().setPosition(700, 10);
//            }
//        }
//
////        public static void gardesSwitch(){
////        switch (PlayScreen.noOfPlayers){
////
////            case 1:
////                gradePlayer1();
////                GradesSetter.getGradeA1().setPosition(380,10 );
////                GradesSetter.getGradeA1().setPosition(380,10 );
////                GradesSetter.getGradeA1().setPosition(380,10 );
////                break;
////            case 2:
////                gradePlayer1();
////                gradePlayer2();
////              break;
////        }
////
////        }
//
//
//    }
