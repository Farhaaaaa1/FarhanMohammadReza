package com.company;


import javafx.scene.control.Cell;

public class pcPlayer  extends Player {
    private int minChoices ;
    private int [] Cell ;
    private int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public pcPlayer(Boolean changingColorPermission, int[] Cell , Boolean imHuman) {
        super(changingColorPermission, imHuman);
        this.Cell = Cell ;
        CloudyPlayer sup = new CloudyPlayer(false , Cell , false) ;
    }
    int[] recommendedChoice = new int[]{0 , 7 , 63 , 56 };
    public void put()
    {   for (int i = 0 ; i <recommendedChoice.length ; ++i  )
        check(recommendedChoice[i] , Cell ,turn);

    }

}
