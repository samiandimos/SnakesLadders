package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.views.PlayScreen;

import java.util.Random;

public class Dice2
{
   public static int tileNum;
    private static int targetTileNum;

    private static Random random = new Random();
    public static int dice;

    private TileBoard3 parent;
    private static Sound diceSound;

    // Creating an instance of the Class Pawn so to be able to use it's methods in a static context
//    Pawn playingPawn = new Pawn();
    public static Pawn playingPawn;



    public static void rollAndMove(Pawn pawn, int newTileNum)
    {
        diceSound = Gdx.audio.newSound(Gdx.files.internal("dice.mp3"));
            diceSound.play();

            tileNum = newTileNum;
            playingPawn = pawn;

            dice = random.nextInt(6) + 1;
            DiceDisplay.diceImage(dice);
            tileNum += dice;
            if (tileNum <= 100)
            {
                if (playingPawn.checkTileForSpecial(tileNum)) // If contains special
                {
                    targetTileNum = playingPawn.getTargetTileNum(playingPawn.getTileProperties(tileNum));
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    // Setting the new tile number and save it for the current player
                    tileNum = targetTileNum;
                    playingPawn.setTileNum(tileNum);
                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;
                } else {
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    playingPawn.setTileNum(tileNum);
                }

                if(playingPawn.getTileNum() == 100) {
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    PlayScreen.parent.changeScreen(TileBoard3.ENDGAME);
                }
            } else {
                tileNum -= dice;
            }

            System.out.println(dice + "  " + tileNum);

    }
}
