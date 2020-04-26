package com.company;

import java.util.List;
import java.util.Scanner;

/**
 * an abstract of player wich contain all of thing one player can do but cuz we can't but cuz we can't imagine it
 * i prefer to creat it as a abstract ...
 */
abstract class Player {
    private Boolean changingColorPermission;
    // to reconize this user is computer or not
    private Boolean imHumn;
    private int numberOfChoices;
    private int allRotatedCell;

    /**
     * get method for permission
     *
     * @return changing color permission
     */
    public Boolean getChangingColorPermission() {
        return changingColorPermission;
    }

    /**
     * @param changingColorPermission changing Color Permission
     */
    public void setChangingColorPermission(Boolean changingColorPermission) {
        this.changingColorPermission = changingColorPermission;
    }

    /**
     * @return IMHuman field
     */
    public Boolean getImHumn() {
        return imHumn;
    }

    /**
     * @param imHumn onr field to know this user is computer or not
     */
    public void setImHumn(Boolean imHumn) {
        this.imHumn = imHumn;
    }

    /**
     * get the number of rotated Cell
     *
     * @return number of rotated Cells
     */
    public int getAllRotatedCell() {
        return allRotatedCell;
    }

    /**
     * get number of choices that we allow to put our Cell
     *
     * @return number of choices we have
     */
    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    /**
     * @param numberOfChoices set number of choices
     */
    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    /**
     * @param changingColorPermission permission to rotate the cells
     * @param imHumn                  permission to do somthing that just human are able to do it
     */
    public Player(Boolean changingColorPermission, Boolean imHumn) {
        this.changingColorPermission = changingColorPermission;
        this.imHumn = imHumn;
    }

    /**
     * method to check can we put our Cell at that location or not
     * by checking it  the side by side Cells
     *
     * @param aim  the location that we want to put our Cell
     * @param Cell Cell of the game that we call it in persian mohre
     * @param turn turn of player :)
     */
    public void check(int aim, int[] Cell, int turn) {
        allRotatedCell = 0;
        int copyOfTurn = turn;
        // make color of the Cells by "turn"
        if (turn % 2 == 1)
            turn = -1;
        else
            turn = 1;
        while (true) {
            if (aim - 9 >= 0)
                if (Cell[aim - 9] * turn < 0 && Math.abs((aim - 9) / 8 - aim / 8) == 1) {
                    allRotatedCell += tracing(-9, aim, Cell, turn);

                }
            if (aim - 8 >= 0)
                if (Cell[aim - 8] * turn < 0) {
                    allRotatedCell += tracing(-8, aim, Cell, turn);

                }
            if (aim - 7 >= 0)
                if (Cell[aim - 7] * turn < 0 && (aim / 8 - (aim - 7) / 8) != 0) {
                    allRotatedCell += tracing(-7, aim, Cell, turn);

                }

            if (aim - 1 >= 0)
                if (Cell[aim - 1] * turn < 0 && (aim / 8 - (aim - 1) / 8) == 0) {
                    allRotatedCell += tracing(-1, aim, Cell, turn);

                }

            if (aim + 9 < 64)
                if (Cell[aim + 9] * turn < 0 && Math.abs(aim / 8 - (aim + 9) / 8) == 1) {
                    allRotatedCell += tracing(9, aim, Cell, turn);

                }

            if (aim + 8 < 64)
                if (Cell[aim + 8] * turn < 0) {
                    allRotatedCell += tracing(8, aim, Cell, turn);
                }

            if (aim + 7 < 64)
                if (Cell[aim + 7] * turn < 0 && (aim / 8 - (aim + 7) / 8) != 0) {
                    allRotatedCell += tracing(7, aim, Cell, turn);
                }

            if (aim + 1 < 64)
                if (Cell[aim + 1] * turn < 0 && (aim / 8 - (aim + 1) / 8) == 0) {
                    allRotatedCell += tracing(1, aim, Cell, turn);
                }
            // now we check the location
            if (changingColorPermission && allRotatedCell == 0 && imHumn) {
                int duplicateAim = scanningAgain();
                check(duplicateAim, Cell, copyOfTurn);
            }
            // now we are going to get number of choces
            if (!changingColorPermission && allRotatedCell != 0) {
                numberOfChoices++;
            }
            break;
        }

    }

    /**
     * trace every legal direction
     *
     * @param move          how we track or destination of two Cells in our line
     * @param startingPoint where we started tracing or location of our Cell that we put it in this turn
     * @param Cell          list of our Cells or in this case all the location
     * @param turn          turn of player
     * @return number of rotated Cells / Cell
     */
    public int tracing(int move, int startingPoint, int[] Cell, int turn) {
        int finishingPoint = startingPoint + move;
        int numberOfRootatedCells = 0;
        while (true) {
            // just check it
            if (finishingPoint >= 0 && finishingPoint < 64) {
                if (turn * Cell[finishingPoint] > 0 && access(startingPoint, finishingPoint, move)) {
                    numberOfRootatedCells += Math.abs((startingPoint - finishingPoint) / move) - 1;
                    if (changingColorPermission)
                        coloring(startingPoint, finishingPoint, Cell, move, turn);
                    break;
                }
                if (Cell[finishingPoint] == 0) {
                    break;
                }
            } else
                break;
            finishingPoint += move;
        }
        return numberOfRootatedCells;
    }

    /**
     * color the Cells
     *
     * @param startingPoint  where we put our Cell on it
     * @param finishingPoint end of our line
     * @param Cell           list of locations
     * @param move           destination of two Cells in our line
     * @param color          color that we splash the Cells between starting point and finishing point
     */
    public void coloring(int startingPoint, int finishingPoint, int[] Cell, int move, int color) {

        int i = startingPoint;
        do {
            Cell[i] = color;
            i += move;
        }
        while (i != finishingPoint);
    }

    /**
     * if we type wrong code or we type wrong location with this meyhod we can type and
     * scan again
     *
     * @return where we want to put our CEll on it
     */
    private int scanningAgain() {
        System.out.print("\u001b[47m you put invalid location try again :  \u001b[0m    ");
        System.out.println("");
        Scanner Input = new Scanner(System.in);
        int counter = 0;
        while (true) {
            if (counter > 0)
                System.out.println("\u001b[47m can't scan your code  :  \u001b[0m    ");
            String str = Input.next();
            char x = str.charAt(0);
            char y = str.charAt(1);
            int x1 = Character.getNumericValue(x);
            int y1 = Character.getNumericValue(y);
            y1 -= 9;
            int result = 8 * (x1 - 1) + y1 - 1;
            if (x1 <= 8 && y1 <= 8)
                return result;
            counter++;
        }
    }

    /**
     * method to check we can we colored it or not
     *
     * @param startingPoint  where we put our Cell on it
     * @param finishingPoint end of our line
     * @param move           destination of two Cells in our line
     * @return access to coloring or not
     */
    public Boolean access(int startingPoint, int finishingPoint, int move) {
        int abs = Math.abs(startingPoint / 8 - finishingPoint / 8);
        if (Math.abs(move) == 1) {
            if (abs == 0)
                return true;
            else
                return false;
        } else if (move == 8 || move == -8)
            return true;
        else {
            if (abs == Math.abs(finishingPoint % 8 - startingPoint % 8))
                return true;
            else
                return false;
        }
    }
}
