package com.mygdx.game.supp;


public class Score {

    public static int plScore1;
    public static int plScore2;


    public static void setPlScore1(int plScore1) {
        Score.plScore1 += plScore1;
    }

    public static int getPlScore1(){
        return plScore1;
    }


    public static int getPlScore2() {
        return plScore2;
    }

    public static void setPlScore2(int plScore2) {
        Score.plScore2 += plScore2;
    }
}
