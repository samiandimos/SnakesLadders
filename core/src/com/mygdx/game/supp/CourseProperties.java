package com.mygdx.game.supp;

import com.badlogic.gdx.maps.MapProperties;

import static com.mygdx.game.supp.Dice2.tileNum;
import static com.mygdx.game.supp.Pawn.getTileProperties;

public class CourseProperties {


    public static boolean checkForPbl(){
        MapProperties tilesProperties = getTileProperties(tileNum);
        boolean containpbl = tilesProperties.containsKey("pbl");
        if (containpbl){
            return  true;}
            return false;
    }
    public static boolean checkForOop(){
        MapProperties tilesProperties = getTileProperties(tileNum);
        boolean containoop = tilesProperties.containsKey("oop");
        if (containoop){
            return  true;}
        return false;
    }
    public static boolean checkForAlgebra(){
        MapProperties tilesProperties = getTileProperties(tileNum);
        boolean containalgebra = tilesProperties.containsKey("algebra");
        if (containalgebra){
            return  true;}
        return false;
    }

    /*public static boolean checkForNone(){
        MapProperties tileProperties = getTileProperties(tileNum);
        boolean containNone = tileProperties.containsKey("none");
        if (containNone) {
            return true; }
        return false;
    }*/

}
