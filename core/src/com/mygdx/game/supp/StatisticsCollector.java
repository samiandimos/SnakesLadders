package com.mygdx.game.supp;


import com.mygdx.game.supp.AnswerButtons.*;

import static com.mygdx.game.supp.AnswerButtons.checkForRightAnswer;

public class StatisticsCollector {

    static int pblScore ;
    static int algScore ;
    static int oopScore ;

    public static void setPblScore() {

        if ( CourseProperties.checkForPbl() &&  checkForRightAnswer  ) {
            pblScore+=1;
        }
    }
     public static int getPblScore(){
        return pblScore ;
     }


    public static void setOopScore() {

        if ( CourseProperties.checkForPbl()  &&  checkForRightAnswer  ) {
            pblScore+=1;
        }
    }
    public static int getOopScore(){
        return oopScore ;
    }

    public static void setAlgScore() {

        if ( CourseProperties.checkForPbl() &&  checkForRightAnswer  ) {
            algScore+=1;
        }
    }
    public static int getAlgScore(){
        return algScore ;
    }


}

// remember to add statistics for right and wrong , to give a percentage for each course




