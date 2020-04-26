package com.company;

import java.lang.reflect.Array;
import java.util.List;

public class Board {
    static char E;

    /**
     * set all of them
     *
     * @param Cell Cell of the board we called it in persian mohre LOL
     */
    public void firstValue(int[] Cell) {
        for (int i = 0; i < 64; ++i) {
            Cell[i] = 0;
        }
        // the first four Cells
        Cell[27] = 1;
        Cell[28] = -1;
        Cell[35] = -1;
        Cell[36] = 1;
    }

    /**
     * printing the board game and show score boarde and also write turn of the players in terminal
     *
     * @param Cell List of all of the Cells
     * @param turn turn of player
     */
    public void printing(int[] Cell, int turn) {
        int y = 8;
        int x = 0;
        int counter = 0;
        System.out.println("\n\u001B[0m \u001B[33m____***_______***_______***_______***_______***" +
                "_______***_______***_______***_______***_______***_______***_______***___________***" +
                "___________***___________***___________***___________***____");
        System.out.println("\n\u001B[34m   " + "\t\t\t   Player 1 : " + getTheScore(1, Cell) +
                "\u001B[0m" + "\u001B[31m" + "\t\t\t\tPlayer 2 : " + getTheScore(-1, Cell));
        System.out.print("\n      \u001B[0m \u001B[33m A       B       C       D      E       F       G       H ");
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

    /**
     * nothing important just copy of one site
     * it just creat a pattern of E in terminal
     */
    static void e() {
        System.out.printf("\n");
        for (int i = 0; i < 8; i++) {
            System.out.printf(" ");
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    System.out.printf("%c", E);
                } else if (i > 0 && i < 3
                        && j < 2) {
                    System.out.printf("%c", E);
                } else if (i == 3 && j < 6) {
                    System.out.printf("%c", E);
                } else if (i > 3 && i < 6
                        && j < 2) {
                    System.out.printf("%c", E);
                } else if (i == 6) {
                    System.out.printf("%c", E);
                } else
                    System.out.printf(" ");
            }
            System.out.println();
        }
    }

    /**
     * nothing important just copy of one site
     * it just creat a pattern of N in terminal
     */
    static void n() {
        for (int i = 0; i < 8; i++) {
            System.out.print(" ");
            for (int n = 0; n < 8; n++) {
                if (n < 2 || n > 5) {
                    System.out.print(E);
                } else if (i == n - 1
                        || i == n + 1 || i == n) {
                    System.out.print(E);
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * nothing important just copy of one site
     * it just creat a pattern of D in terminal
     */
    static void d() {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            {
                System.out.print(E);
            }

            for (int o = 0; o < 8; o++) {
                if (i == 0 && (o >= 6 - i))
                    System.out.print("");
                else if (i == 1
                        && (o == 0 || o == 8 - i
                        || (o < 6)))
                    System.out.print(" ");
                else if (i == 2 && (o == 1 || o == 8 - i || (o < 6)))
                    System.out.print(" ");

                else if ((i == 3 || i == 4 || i == 5) && (o < 7))
                    System.out.print(" ");
                else if (i == 6 && (o == 0 || o == 8 + 5 - i || (o < 6)))
                    System.out.print(" ");
                else if (i == 7 && (o >= 6 - i + 7))
                    System.out.print(" ");
                else {
                    System.out.print(E);
                }
            }
            System.out.println();
        }
    }
}
