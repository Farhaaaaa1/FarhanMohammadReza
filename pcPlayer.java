package com.company;


import javafx.scene.control.Cell;

public class PcPlayer extends CloudyPlayer {
    private int minChoices;
    private int[] Cell;
    private int turn;
    private int[] copy = new int[64] ;

    /**
     * @param changingColorPermission permission to changing color
     * @param Cell list of the locations
     * @param imHuman
     */
    public PcPlayer(Boolean changingColorPermission, int[] Cell, Boolean imHuman) {
        super(changingColorPermission, Cell, imHuman);
    }

    /**
     *
     * @return turn
     */
    public int getTurn() {

        return turn;
    }

    /**
     *
     * @param turn turn of the player
     */
    public void setTurn(int turn) {

        this.turn = turn;
    }
    int[] recommendedChoice = new int[]{0, 7, 63, 56};
    int[] unrecommendedChoice = new int[]{8 ,16,54 ,49};

    /**
     * method for computer to put the cell on the board
     * @param Cell list of the locations
     * @param turn turn of the player
     */
    public void put(int [] Cell , int turn) {
        if (turn%7 <= 3 ) {
            int temp = 0;
            int aim = 0;
            minChoices = 63;
            int counter = 0;
            for (int i = 0; i < recommendedChoice.length; ++i) {
                if (Cell[recommendedChoice[i]] == 0) {
                    check(recommendedChoice[i], Cell, turn);
                    if (getAllRotatedCell() != 0) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == 0) {
                for (int i = 0; i < 64; ++i) {
                    temp = 0;
                    makeCopy(copy, Cell);
                    if (copy[i] == 0 && !(i == 8 || i == 15 || i == 49 || i == 54)) {
                        counter++;
                        check(i, copy, turn);
                        if (getAllRotatedCell() > 0)
                            setChangingColorPermission(false);
                        temp = checking(turn + 1, copy);
                        setChangingColorPermission(true);
                        if (temp < minChoices && temp > 0) {
                            minChoices = temp;
                            aim = i;
                        }


                    }
                }
                check(aim, Cell, turn);
            }
            if (counter == 0) {
                for (int i = 0; i < unrecommendedChoice.length; ++i) {
                    if (Cell[unrecommendedChoice[i]] == 0) {
                        check(unrecommendedChoice[i], Cell, turn);
                        if (getAllRotatedCell() != 0)
                            break;
                    }
                }
            }
            counter = 0;
        }
        else
        {
           int temp = 0;
            int aim = 0;
            int maxCells = 1;
            int counter = 0;
            for (int i = 0; i < recommendedChoice.length; ++i) {
                if (Cell[recommendedChoice[i]] == 0) {
                    check(recommendedChoice[i], Cell, turn);
                    if (getAllRotatedCell() != 0) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == 0) {
                for (int i = 0; i < 64; ++i) {
                    temp = 0;
                    makeCopy(copy, Cell);
                    if (copy[i] == 0 && !(i == 8 || i == 15 || i == 49 || i == 54)) {
                        counter++;
                        check(i, copy, turn);
                        temp = getAllRotatedCell() ;
                        if (temp > maxCells ) {
                            minChoices = temp;
                            aim = i;
                        }

                    }
                }
                check(aim, Cell, turn);
            }
            if (counter == 0) {
                for (int i = 0; i < unrecommendedChoice.length; ++i) {
                    if (Cell[unrecommendedChoice[i]] == 0) {
                        check(unrecommendedChoice[i], Cell, turn);
                        if (getAllRotatedCell() != 0)
                            break;
                    }
                }
            }
            counter = 0;
        }

    }

    /**
     * to store the locations
     * @param copy copy of locations
     * @param Cell list of location
     */
    public void makeCopy(int[] copy, int[] Cell) {
       // System.out.println(copy.length);
        for (int i = 0; i < Cell.length; i++) {
            copy[i] = Cell[i];
        }
    }
}
