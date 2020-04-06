package com.company;

import java.lang.reflect.Array;
import java.util.List;

public class Board {

    public void firstValue(int[] Cell) {
        for (int i = 0; i < 64; ++i) {
            Cell[i] = 0;
        }
        Cell[27] = 1;
        Cell[28] = -1;
        Cell[35] = -1;
        Cell[36] = 1;
    }

    public void printing(int[] Cell, int turn) {
        int y = 8;
        int x = 0;
        int counter = 0;
        System.out.println("\u001B[34m   " + "              Player 1 : " + getTheScore(1, Cell) +
                "\u001B[0m" + "\u001B[31m" + "         Player 2 : " + getTheScore(-1, Cell));
        System.out.println("");
        System.out.print("      \u001B[0m \u001B[33m A       B       C       D      E       F       G       H ");
        System.out.println("\u001B[0m");
        System.out.println("");
        System.out.print(" \u001B[0m \u001B[33m 1 \u001B[0m");
        int I = 1;
        for (int color : Cell) {
            if (color == 1)
                System.out.print("   " + "\uD83D\uDD35" + "   ");
            if (color == 0)
                System.out.print("   " + "\u26AA" + "   ");
            if (color == -1)
                System.out.print("   " + "\uD83D\uDD34" + "   ");
            counter++;
            if (counter == 8) {
                I++;
                System.out.println("");
                System.out.println("");
                if (I != 9)
                    System.out.print(" \u001B[0m \u001B[33m " + I + " \u001B[0m");
                counter = 0;
            }
        }
        if (turn % 2 == 1)
            System.out.println(" \u001B[31m         turn of \u001B[0m \uD83D\uDD34");
        if (turn % 2 == 0)
            System.out.println(" \u001B[34m         turn of \u001B[0m \uD83D\uDD35");
        I = 1;
    }

    public int getTheScore(int color, int[] Cell) {
        int counter = 0;
        for (int value : Cell) {
            if (value == color)
                counter++;
        }
        return counter;
    }

}
