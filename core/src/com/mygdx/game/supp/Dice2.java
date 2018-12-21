package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
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
        diceSound = Gdx.audio.newSound(Gdx.files.internal("audio/dice.mp3"));
            diceSound.play();

            tileNum = newTileNum;
            playingPawn = pawn;

            dice = random.nextInt(2) + 1;
            DiceDisplay.diceImage(dice);
            tileNum += dice;
            if (tileNum <= 100) {
                if (playingPawn.checkTileForSpecial(tileNum)) // If contains special
                // Movement to special tile
                {
                    targetTileNum = playingPawn.getTargetTileNum(Pawn.getTileProperties(tileNum));
//                    targetTileNum = tileNum; // Debug code to remove special tiles (comment out the above and uncomment this)
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    // Setting the new tile number and save it for the current player
                    tileNum = targetTileNum;
                    playingPawn.setTileNum(tileNum);
                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;

                } else { // Normal movement from tile to tile
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    playingPawn.setTileNum(tileNum);
                }

//                if (playingPawn.getTileNum() == 100 || tileNum == 100 ) {
//
//                    // Runnable action added so the pawn moves first to the
//                    // 100th tile and after that the EndScreens shows up
//
//                    playingPawn.pawn.addAction(Actions.after(Actions.delay(4f, new RunnableAction(){
//                        @Override
//                        public void run() {
////                            QuestionPopup.getWindow().clear();
//                            PlayScreen.parent.changeScreen(TileBoard3.ENDGAME);
//
////                            switch (tileNum) {
////                                case  100:
////                            }
//                        }
//                    })));
//                }

            } else {
                tileNum -= dice;
                playingPawn.pawn.clearActions();
                // QuestionPopup.showQuestionWindow() method, has been inserted as runnable action with a small delay
                // This delay fixes the occasion where its nested method updateQuestionWindow(randNr) don't have the
                // time to get and set the question and its answers inside the window
                playingPawn.pawn.addAction(Actions.delay(.3f, new RunnableAction(){
                    @Override
                    public void run() {
                        QuestionPopup.showQuestionWindow();
                    }
                }));
            }

            System.out.println(dice + "  " + tileNum);
    }
}
