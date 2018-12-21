//package com.mygdx.game.supp;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
//import com.mygdx.game.views.FinishScreen;
//
//import static com.mygdx.game.supp.Score.plScore1;
//
//public class GradeSheetDrawer {
//
//    static Texture gradeTex  =  new Texture(Gdx.files.internal("grade" +plScore1+ ".png"));
//    static Image gradeSheet ;
//
//    public static Image gradeSheet (){
//
//
//       gradeSheet = new Image(gradeTex);
//        gradeSheet.setPosition(450 , 200);
//        gradeSheet.toFront();
//
//
//           if (plScore1>=70) {
//
//               gradeSheet=new Image(gradeTex);
//               FinishScreen.finishStage.addActor(gradeSheet);
//           }
//
//       else if ( plScore1>=50 && plScore1<70 ) {
//
//            gradeSheet=new Image(gradeTex);
//            FinishScreen.finishStage.addActor(gradeSheet);
//        }
//       else if ( plScore1 < 50 )
//
//                    gradeSheet=new Image(gradeTex);
//                    FinishScreen.finishStage.addActor(gradeSheet);
//
//
//
//                return gradeSheet ;
//            }
//}
//
//
//
//
//
//
