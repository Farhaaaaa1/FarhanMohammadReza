package com.company;

import java.util.List;
import java.util.Scanner;

abstract class Player {
    private Boolean changingColorPermission;
    private Boolean imHuman ;
    private int numberOfChoices ;
    private int allRotatedCell ;

    public int getAllRotatedCell() {
        return allRotatedCell;
    }

    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    public Player(Boolean changingColorPermission, Boolean imHuman) {
        this.changingColorPermission = changingColorPermission;
        this.imHuman = imHuman;
    }

    public void check(int aim, int[] Cell, int turn) {
        int allRotatedCell = 0;
        int copyOfTurn = turn;
        if (turn % 2 == 1)
            turn = -1;
        else
            turn = 1;
        while (true) {
            if (aim - 9 >= 0)
                if (Cell[aim - 9] * turn < 0 && Math.abs((aim - 9) / 8 - aim / 8) == 1) {
                    allRotatedCell += tracing(-9, aim, Cell, turn);
                    // System.out.println("1...");ku
                }
            if (aim - 8 >= 0)
                if (Cell[aim - 8] * turn < 0) {
                    allRotatedCell += tracing(-8, aim, Cell, turn);
                    //System.out.println("2...");
                }
            if (aim - 7 >= 0)
                if (Cell[aim - 7] * turn < 0 && (aim / 8 - (aim - 7) / 8) != 0) {
                    allRotatedCell += tracing(-7, aim, Cell, turn);
                    //  System.out.println("3...");
                }

            if (aim - 1 >= 0)
                if (Cell[aim - 1] * turn < 0 && (aim / 8 - (aim - 1) / 8) == 0) {
                    allRotatedCell += tracing(-1, aim, Cell, turn);
                    //System.out.println("4...");
                }

            if (aim + 9 < 64)
                if (Cell[aim + 9] * turn < 0 && Math.abs(aim / 8 - (aim + 9) / 8) == 1) {
                    allRotatedCell += tracing(9, aim, Cell, turn);
                    // System.out.println("5...");
                }

            if (aim + 8 < 64)
                if (Cell[aim + 8] * turn < 0) {
                    allRotatedCell += tracing(8, aim, Cell, turn);
                    // System.out.println("6...");
                }

            if (aim + 7 < 64)
                if (Cell[aim + 7] * turn < 0 && (aim / 8 - (aim + 7) / 8) != 0) {
                    allRotatedCell += tracing(7, aim, Cell, turn);
                    //      System.out.println("7...");
                }

            if (aim + 1 < 64)
                if (Cell[aim + 1] * turn < 0 && (aim / 8 - (aim + 1) / 8) == 0) {
                    allRotatedCell += tracing(1, aim, Cell, turn);
                    //    System.out.println("8...");
                }
            if (changingColorPermission && allRotatedCell == 0 && imHuman) {
                int duplicateAim = scanningAgain();
                check(duplicateAim, Cell , copyOfTurn);
            }
             if(!changingColorPermission && allRotatedCell != 0 ) {
                 System.out.println("aim = "+aim);
                 numberOfChoices++;
             }
            break;
        }
    }

    public int tracing(int move, int startingPoint, int[] Cell, int turn) {
        int finishingPoint = startingPoint + move;
        int numberOfRootatedCells = 0;
        while (true) {
            if (finishingPoint >= 0 && finishingPoint < 64) {
                if (turn * Cell[finishingPoint] > 0 && access(startingPoint , finishingPoint ,move)  ) {
                   // System.out.println("start = " + startingPoint);
                  //  System.out.println("finish = " + finishingPoint);
                  //  System.out.println(move);
                    numberOfRootatedCells += Math.abs((startingPoint - finishingPoint) / move) - 1;
                    if (changingColorPermission)
                        coloring(startingPoint, finishingPoint, Cell, move , turn);
                    break;
                }
                if (Cell[finishingPoint] == 0) {
                    break;
                }
            }
            else
                break;
            finishingPoint += move;
        }
        return numberOfRootatedCells;
    }

    public void coloring(int startingPoint, int finishingPoint, int[] Cell, int move , int color ) {
        System.out.println("i is   =" + startingPoint);
        System.out.println("j is   =" + finishingPoint);
        int i = startingPoint;
        do {
            Cell[i] = color ;
            i += move;
        }
        while (i != finishingPoint);
    }

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
    public Boolean access(int startingPoint , int finishingPoint , int move)
    {
       int abs = Math.abs(startingPoint / 8 - finishingPoint / 8);
        if(Math.abs(move) == 1) {
            if (abs == 0)
                return  true;
            else
                return false;
        }
        else
        {
            if(abs != 0 )
                return  true;
            else
            return  false;
        }
    }
}