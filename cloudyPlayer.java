package com.company;

import javafx.scene.control.Cell;

public class CloudyPlayer extends Player {
    private int[] Cell;
    private int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setAll(int turn, int[] Cell) {
        this.Cell = Cell;
        this.turn = turn;
    }

    public CloudyPlayer(Boolean changingColorPermission, int [] Cell , Boolean imHuman ) {
        super(changingColorPermission ,imHuman );
        this.Cell = Cell;
        setNumberOfChoices(0);
    }

    public int checking(int turn , int [] Cell) {
        setNumberOfChoices(0);
        setAll(turn, Cell);
        for (int i = 0; i < Cell.length; i++) {
            //   System.out.println(i +"  =   ");
            if (Cell[i] == 0) {
               // System.out.println(i + "  =  " + Cell[i]);
                check(i, Cell, turn);
            }
        }
//        if(getNumberOfChoices()> 0)
//        System.out.println("number of choices =  " + getNumberOfChoices());
        return getNumberOfChoices();
    }

}
