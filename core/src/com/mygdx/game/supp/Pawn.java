package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.views.PlayScreen;


public class Pawn
{
    private static MapLayers layerList;
    private static MapLayer layer;
    private static MapObjects tileList; // List of objects
    public static MapObject tile; // An object from the list
    public static MapProperties tileProperties; // List with object properties

    public Image pawn;
    private int tileNum = 95;
    private String name = "";


    // Current tile number setter
    public void setTileNum(int tileNum)
    {
        this.tileNum = tileNum;
    }

    // Current tile number getter
    public int getTileNum()
    {
        return this.tileNum;
    }

    // Manipulating the name of each player
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    private Texture texture;

    public void setInStage (int playerStartingPosition)
    {
        // Getting the starting position of the pawn Depending on the Player Number
        MapProperties startingTileProperties = getTileProperties(playerStartingPosition);

        if (name.equals("Player1"))
        {
            texture = new Texture(Gdx.files.internal("icon.png"));
        }else{
            texture = new Texture(Gdx.files.internal("icon4.png"));
        }

        // Creating a pawn in the starting position
        pawn = new Image(texture);
        pawn.setSize(texture.getWidth() * .8f, texture.getHeight() * .8f);
        pawn.setPosition((Float) startingTileProperties.get("x"), (Float) startingTileProperties.get("y"));
        PlayScreen.playStage.addActor(pawn);
//        texture.dispose();
    }



    // Getting the properties of the current tile using the dice
    // Used in checkTileForSpecial and movePawn
    public static MapProperties getTileProperties(int tileNum)
    {
        layerList = PlayScreen.tiledMap.getLayers();
        layer = layerList.get("Tiles");
        tileList = layer.getObjects();
        tile = tileList.get(Integer.toString(tileNum));
        tileProperties = tile.getProperties();

        return tileProperties;
    }


    public int getTargetTileNum(MapProperties tileProperties)
    {
        // Returns the value of the "goto" property
        return (Integer) tileProperties.get("goto");
    }

    // Checking if the tile contains the special property and if yes getting it
    public boolean checkTileForSpecial(int tileNum)
    {
        MapProperties tileProperties = getTileProperties(tileNum);
        boolean containSpecial = tileProperties.containsKey("special");

        if (containSpecial)
        {
            return true;
        }

        return false;
    }

    // This method can get divided
    public void movePawn(int tileNum, int targetTileNum, int dice)
    {
        dice -= 1;
        SequenceAction sequenceAction = new SequenceAction();

        // Creating our Runable Action and adding it at the end of a sequential set of actions of the Pawn,
        // so our popup window shows up after all other actions have been completed
        RunnableAction runPopup = new RunnableAction() {
            @Override
            public void run() {
                QuestionPopup.showQuestionWindow();
                // System.out.println("sadfasdfsdaf");
            }
        };

        while(dice >= 0)
        {
            tileNum -= dice;
            MapProperties tileProperties = getTileProperties(tileNum);
            sequenceAction.addAction(Actions.moveTo((Float) tileProperties.get("x"), (Float) tileProperties.get("y"), .4f, Interpolation.smooth));
            tileNum += dice;
            dice -= 1;
        }

        if (targetTileNum != 0)
        {
            MapProperties targetTileProperties = getTileProperties(targetTileNum);
            sequenceAction.addAction(Actions.moveTo((Float) targetTileProperties.get("x"), (Float) targetTileProperties.get("y"), 1, Interpolation.smooth));
        }


        // Debug code
        /*if (sequenceAction.getActions().size == 0)
        {
            System.out.println("\nList is EMPTY\n");
        }else{
            System.out.printf("\nList NOT Empty: list size %d\n", sequenceAction.getActions().size);
        }*/

        // QuestionPopup.showQuestionWindow() method, has been inserted as runnable action with a small delay
        // This delay fixes the occasion where its nested method updateQuestionWindow(randNr) don't have the
        // time to get and set the question and its answers inside the window
        sequenceAction.addAction(Actions.delay(.3f, runPopup));
        pawn.addAction(sequenceAction);
    }
}
