package com.company;

import javafx.scene.control.Cell;

public class CloudyPlayer extends Player {
    private int[] Cell;
    private int turn;
    /**
     * set two item to getting
     *
     * @param turn turn of the player
     * @param Cell list of the locations
     */
    public void setAll(int turn, int[] Cell) {
        this.Cell = Cell;
        this.turn = turn;
    }

    /***
     *
     * @param changingColorPermission permission to change color of the Cells
     * @param Cell list of the loctions
     * @param imHuman permissin to do somthjing that just human can do (human user )
     */
    public CloudyPlayer(Boolean changingColorPermission, int[] Cell, Boolean imHuman) {
        super(changingColorPermission, imHuman);
        this.Cell = Cell;
        setNumberOfChoices(0);
    }

    /**
     * method to know how many choices we have to put our Cell
     *
     * @param turn turn of the player
     * @param Cell list of the Cells
     * @return number of the Choices
     */
    public int checking(int turn, int[] Cell) {
        setNumberOfChoices(0);
        setAll(turn, Cell);
        for (int i = 0; i < Cell.length; i++) {
            if (Cell[i] == 0) {
                check(i, Cell, turn);
            }
        }
        return getNumberOfChoices();
    }

}
