package com.mygdx.game.supp;

import static com.mygdx.game.supp.Dice2.tileNum;

public class StatisticCollector1 {


//---------------------------------------- player1  questions counter--------------------------------------
    static int pl1QuestionCounter ;

    public static void setPl1QuestionCounter(int pl1QuestionCounter) {
    StatisticCollector1.pl1QuestionCounter += pl1QuestionCounter;
    }

    public static int getPl1QuestionCounter() {
        return pl1QuestionCounter;
    }
//---------------------------------------- player1  general right answers counter--------------------------------------

    static int answerRightP1 ;

    public static void setAnswerRightP1(int answerRightP1) {
            StatisticCollector1.answerRightP1 += answerRightP1;
    }

    public static int getAnswerRightP1() {
        return answerRightP1;
    }

//------------------ counter for how many questions for each course ------------------------------------
//---------------------------------------- player1  --------------------------------------------------------
//---------------------------------------- ALG  --------------------------------------------------------

    static int pl1AlgQuestionsCounter ;
    public static void setPl1AlgQuestionsCounter(int pl1AlgQuestionsCounter) {
            StatisticCollector1.pl1AlgQuestionsCounter += pl1AlgQuestionsCounter;
    }

    public static int getPl1AlgQuestionsCounter() {
        return pl1AlgQuestionsCounter ;
    }
//---------------------------------------- OOP  --------------------------------------------------------

    static int pl1OopQuestionsCounter ;
    public static void setPl1OopQuestionsCounter(int pl1OopQuestionsCounter) {
            StatisticCollector1.pl1OopQuestionsCounter += pl1OopQuestionsCounter;
    }

    public static int getPl1OopQuestionsCounter() {
        return pl1OopQuestionsCounter ;
    }
//---------------------------------------- PBL  --------------------------------------------------------

    static int pl1PblQuestionsCounter ;

    public static void setPl1PblQuestionsCounter(int pl1PblQuestionsCounter) {
            StatisticCollector1.pl1PblQuestionsCounter += pl1PblQuestionsCounter;
    }

    public static int getPl1PblQuestionsCounter() {
        return pl1PblQuestionsCounter ;
    }
//---------------------------- counters for each rightAnswer for each course -------------------------------------
//---------------------------------------- ALG  --------------------------------------------------------


    static int AlgRightP1;
    public static void setAlgRightP1(int algRightP1) {
            AlgRightP1 += algRightP1;
    }

    public static int getAlgRightP1() {
        return AlgRightP1;
    }

//---------------------------------------- OOP  --------------------------------------------------------

    static int oopRightP1;
    public static void setOopRightP1(int oopRightP1) {
          StatisticCollector1.oopRightP1 = +oopRightP1;
    }


    public static int getOopRightP1() {
        return oopRightP1;
    }

//---------------------------------------- PBL  --------------------------------------------------------
   static int pblRightP1;
    public static void setPblRightP1(int pblRightP1) {
           StatisticCollector1.pblRightP1 += pblRightP1;
    }

    public static int getPblRightP1() {
        return pblRightP1;
    }
//|----------------------------------------------------------------------------------------------------------------|
//|---------------------------------------- PLAYER2  --------------------------------------------------------------|


    //---------------------------------------- counters for each rightAnswer for player2

    static int answerRightP2 ;

    public static void setAnswerRightP2(int answerRightP2) {

        StatisticCollector1.answerRightP2 += answerRightP2;
    }
    public static int getAnswerRightP2() {
        return answerRightP2;
    }


//---------------------------------------- counter of Answers for each  course ----------------------------------------



    //---------------------------------------------------=====================--------------------------------------
    //---------------------------------------- player2  --------------------------------------
   private static int pl2AlgQuestionsCounter ;
   private static int pl2OopQuestionsCounter ;
   private static int pl2PblQuestionsCounter ;


    public static void setPl2AlgQuestionsCounter(int pl2AlgQuestionsCounter) {
        StatisticCollector1.pl2AlgQuestionsCounter += pl2AlgQuestionsCounter;
    }
    public static int getPl2AlgQuestionsCounter() {
        return pl2AlgQuestionsCounter;
    }

    public static void setPl2OopQuestionsCounter(int pl2OopQuestionsCounter) {
        StatisticCollector1.pl2OopQuestionsCounter += pl2OopQuestionsCounter;
    }

    public static int getPl2OopQuestionsCounter() {
        return pl2OopQuestionsCounter;
    }


    public static void setPl2PblQuestionsCounter(int pl2PblQuestionsCounter) {
        StatisticCollector1.pl2PblQuestionsCounter += pl2PblQuestionsCounter;
    }

    public static int getPl2PblQuestionsCounter() {
        return pl2PblQuestionsCounter;
    }
    static int AlgRightP2;

    static int oopRightP2;

    static int pblRightP2;



    public static void setAlgRightP2(int algRightP2) {
        AlgRightP2 += algRightP2;
    }

    public static int getAlgRightP2() {
        return AlgRightP2;
    }

    public static void setOopRightP2(int oopRightP2) {
        StatisticCollector1.oopRightP2 += oopRightP2;
    }

    public static int getOopRightP2() {
        return oopRightP2;
    }

    public static void setPblRightP2(int pblRightP2) {
        StatisticCollector1.pblRightP2 += pblRightP2;
    }


    public static int getPblRightP2() {
        return pblRightP2;
    }




    static int pl2QuestionCounter ;
    public static void setPl2QuestionCounter(int pl2QuestionCounter) {
        do {
            StatisticCollector1.pl2QuestionCounter += pl2QuestionCounter;
        }while (tileNum<100);
    }
    public static int getPl2QuestionCounter() {
        return pl2QuestionCounter;
    }


//   ----------------------------------------

//    static int  pl1QuestionSum ;
//    public static void pl1QuestionSum() {
//        do {
//            pl1QuestionSum += getPl1QuestionCounter();
//
//        } while (tileNum < 100);
//    }
//    public static int getPl1QuestionSum(){
//        return pl1QuestionSum ;
//    }
//
//
//    static int  pl1AnswerSum ;
//    public static void pl1AnswerSum(){
//        do {
//            pl1AnswerSum += getAnswerRightP1();
//
//        }while (tileNum<100);}
//
//    public static int getPl1AnswerSum(){
//        return pl1AnswerSum ;
//    }
//
//    static int pl1AlgQuesSum ;
//    public static void pl1AlgQuesSum(){
//        do {
//            pl1AlgQuesSum += getPl1AlgQuestionsCounter() ;
//        }while (tileNum<100);}
//
//    public static int getPl1AlgQuesSum(){
//        return pl1AlgQuesSum ;
//    }
//
//
//    static int pl1AlgAnswerSum ;
//    public static void pl1AlgAnswerSum(){
//        do {
//            pl1AlgAnswerSum += getAlgRightP1() ;
//        }while (tileNum<100);}
//
//    public static int getPl1AlgAnswerSum(){
//        return pl1AlgAnswerSum ;
//    }
//
//
//    static int pl1OopQuesSum ;
//    public static void pl1OopQuesSum(){
//        do {
//            pl1OopQuesSum += getPl1OopQuestionsCounter() ;
//        }while (tileNum<100);}
//
//    public static int getPl1OopQuesSum(){
//        return pl1OopQuesSum ;
//    }
//
//    static int pl1OopAnswerSum ;
//    public static void pl1OopAnswerSum(){
//        do {
//            pl1OopAnswerSum += getOopRightP1() ;
//        }while (tileNum<100);}
//
//    public static int getPl1OopAnswerSum(){
//        return pl1OopAnswerSum ;
//    }
//
//    static int pl1PblQuesSum ;
//    public static void pl1PblQuesSum(){
//        do {
//            pl1PblQuesSum += getPl1PblQuestionsCounter() ;
//        }while (tileNum<100);}
//
//    public static int getPl1PblQuesSum(){
//        return pl1PblQuesSum ;
//    }
//
//    static int pl1PblAnswerSum ;
//    public static void pl1PblAnswerSum(){
//        do {
//            pl1PblAnswerSum += getPblRightP1() ;
//        }while (tileNum<100);}
//
//    public static int getPl1PblAnswerSum(){
//        return pl1PblAnswerSum ;
//    }



    //---------------------------------------- player2  --------------------------------------
//    static int pl2QuestionSum ;
//    public static int pl2QuestionSum(){
//        do {
//            pl2QuestionSum += getPl2QuestionCounter() ;
//
//        }while (tileNum<100);
//        return pl2QuestionSum ;
//    }




    //---------------------------------------------------=====================--------------------------------------


}
