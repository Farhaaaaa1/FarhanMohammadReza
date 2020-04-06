package com.company;

import com.sun.prism.impl.ps.CachingEllipseRep;
import javafx.scene.control.Cell;

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 */
public class Othelo {
    private int amount = 0;
    private int allAmount = 0;
    private Boolean key = true;


    public int getAmount() {
        return amount;
    }

    public void firstValue(List<Content> Cell) {
        int y = 8;
        int x = 0;
        for (int i = 1; i <= 8; ++i) {
            for (int j = 1; j <= 8; j++) {
                Content A = new Content(x, y, 0);
                Cell.add(A);
                ++x;
            }
            --y;

        }
        Content A = Cell.get(27);
        A.setColor(1);

        A = Cell.get(28);
        A.setColor(-1);

        A = Cell.get(35);
        A.setColor(-1);

        A = Cell.get(36);
        A.setColor(1);
    }

    public void printing(List<Content> Cell, int turn) {
        int y = 8;
        int x = 0;
        int counter = 0;
        System.out.println("\u001B[34m   " + "              Player 1 : " + score(1, Cell) +
                "\u001B[0m" + "\u001B[31m" + "         Player 2 : " + score(-1, Cell));
        System.out.println("");
        System.out.print("      \u001B[0m \u001B[33m A       B       C       D      E       F       G       H ");
        System.out.println("\u001B[0m");
        System.out.println("");
        System.out.print(" \u001B[0m \u001B[33m 1 \u001B[0m");
        int I = 1;
        for (Content S :
                Cell) {
            char color = (char) S.getColor();
            int color1 = S.getColor();
            if (color1 == 1)
                System.out.print("   " + "\uD83D\uDD35" + "   ");
            if (color1 == 0)
                System.out.print("   " + "\u26AA" + "   ");
            if (color1 == -1)
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

    public void check(int i, List<Content> Cell, int turn) {
        int copyOfTurn = turn ;
        if (turn % 2 == 1)
            turn = -1;
        else
            turn = 1;
        amount = 0 ;
        while (true) {
            if (i - 9 >= 0)
                if (Cell.get(i - 9).getColor() * turn < 0) {
                    tracing(-9, i, Cell, turn);
                    // System.out.println("1...");
                }
            if (i - 8 >= 0)
                if (Cell.get(i - 8).getColor() * turn < 0) {
                    tracing(-8, i, Cell, turn);
                     //System.out.println("2...");
                }
            if (i - 7 >= 0)
                if (Cell.get(i - 7).getColor() * turn < 0 && (i / 8 - (i - 9) / 8) != 0) {
                    tracing(-7, i, Cell, turn);
                    //  System.out.println("3...");
                }

            if (i - 1 >= 0)
                if (Cell.get(i - 1).getColor() * turn < 0 && (i / 8 - (i - 1) / 8) == 0) {
                    tracing(-1, i, Cell, turn);
                     //System.out.println("4...");
                }

            if (i + 9 < 64)
                if (Cell.get(i + 9).getColor() * turn < 0) {
                    tracing(9, i, Cell, turn);
                     // System.out.println("5...");
                }

            if (i + 8 < 64)
                if (Cell.get(i + 8).getColor() * turn < 0) {
                    tracing(8, i, Cell, turn);
                     // System.out.println("6...");
                }

            if (i + 7 < 64)
                if (Cell.get(i + 7).getColor() * turn < 0 && (i / 8 - (i + 7) / 8) != 0) {
                    tracing(7, i, Cell, turn);
                //      System.out.println("7...");
                }

            if (i + 1 < 64)
                if (Cell.get(i + 1).getColor() * turn < 0 && (i / 8 - (i + 1) / 8) == 0) {
                    tracing(1, i, Cell, turn);
                  //    System.out.println("8...");
                }

            if (amount == 0 && key) {
                System.out.print("\u001b[47m you put invalid location try again :  \u001b[0m    ");
                int R = scanning();
                check(R, Cell, copyOfTurn);
            }
            if(amount > 0 && !key )
                System.out.println("check the "+i+"th cell");
            allAmount = allAmount + amount;
            // amount = 0;
            break;
        }
    }

    public void tracing(int n, int i, List<Content> Cell, int turn) {
        int j = i + n;
        while (true) {
            if (j >= 0 && j < 64) {
                if (turn * Cell.get(j).getColor() > 0 && control(n, i, j)) {
                         System.out.println("j = " + j);
                         System.out.println("i = " + i);
                    System.out.println(n);
//                    System.out.println("injaaaaa");
                    amount += Math.abs((i - j) / n) - 1;
                    if (key)
                        coloring(i, j, Cell, turn, n);
                    break;
                }
                if (Cell.get(j).getColor() == 0) {
                    break;
                }
            } else
                break;
            j += n;
        }

    }

    public void coloring(int i, int j, List<Content> Cell, int turn, int n) {
        System.out.println("i is   =" + i);
        System.out.println("j is   =" + j);
        while (true) {
            Cell.get(i).setColor(turn);
            i += n;
            if (i == j)
                break;
        }
    }

    public int score(int color, List<Content> Cell) {
        int counter = 0;
        for (Content A :
                Cell) {
            if (A.getColor() == color)
                counter++;
        }
        return counter;
    }

    public int scanning() {
        Scanner Input = new Scanner(System.in);
        int counter = 0;
        while (true) {
            if (counter > 0)
                System.out.println("\u001b[47m can't scan your code4e :  \u001b[0m    ");
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

    public Boolean control(int n, int i, int j) {
        if (n == 1 || n == -1) {
            if (i / 8 - j / 8 == 0)
                return true;
            else
                return false;
        } else if (i / 8 - j / 8 != 0)
            return true;
        else
            return false;
    }

    public Boolean moveAcceptability(List<Content> Cell, int turn) {
        String check ;
        if(turn%2==1)
            check = "Red" ;
        else
            check = "Blue" ;
        System.out.println(check+" move check mishe  ");
        allAmount = 0;
        for (int i = 0; i < Cell.size(); ++i) {
            key = false;
            if (Cell.get(i).getColor() == 0) {
                check(i, Cell, turn);
            }
        }
        key = true;
        System.out.println("all amount = "+allAmount);
        if (allAmount > 0)
            return true;
        else
            return false;
    }
    public int result(List <Content> Cell  ) {
        int sum = 0 ;
        for (int j = 0; j < Cell.size(); ++j) {
            sum = sum + Cell.get(j).getColor();
        }
        return sum ;
    }

}


