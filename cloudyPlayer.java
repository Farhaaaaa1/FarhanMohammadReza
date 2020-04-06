package com.company;
import javafx.scene.control.Cell;

public class cloudyPlayer extends Player {
    private int[] Cell;
    private int turn;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    public void setAll(int turn,int [] Cell)
    {
        this.Cell = Cell ;
        this.turn = turn ;
    }
    public cloudyPlayer(Boolean changingColorPermission, int[] Cell) {
        super(changingColorPermission);
        this.Cell = Cell;
        setNumberOfChoices(0);
    }

    public Boolean checking() {
        setNumberOfChoices(0);
        for (int i = 0 ; i<Cell.length;i++) {
         //   System.out.println(i +"  =   ");
            if(Cell[i] == 0) {
                System.out.println(i+"  =  "+ Cell[i]);
                check(i, Cell, turn);
            }
        }
        System.out.println("number of choices =  "+getNumberOfChoices());
        if (getNumberOfChoices() == 0)
            return true ;
        else
            return false ;
    }

}
