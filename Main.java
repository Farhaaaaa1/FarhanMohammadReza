package com.company;

import jdk.internal.util.xml.impl.Input;

import java.util.*;

public class Main {
    public int sum = 0  ;

    public static void main(String[] args) {
        int turn = 1;
        int i = 0;
        Othelo othelo = new Othelo();
        List<Content> Cell = new ArrayList<>();
        othelo.firstValue(Cell);
        while (true) {
            othelo.printing(Cell, turn);
            System.out.println("step 1 ");
            if (!othelo.moveAcceptability(Cell, turn)) {
                System.out.println("Pass !!! ");
                i++;
                turn++;
                othelo.printing(Cell, turn);
                if (!othelo.moveAcceptability(Cell, turn)) {
                    System.out.println("Pass !!! ");
                    i++;
                    turn++;
                    othelo.printing(Cell, turn);
                }
            }

            if (i == 2)
                break;
            else
                i = 0;
            int R = othelo.scanning();
            System.out.println(R);
            System.out.println("step 2 ");
            othelo.check(R, Cell, turn);
            System.out.println("step 3 ");
            turn++;
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("                    End the game                ");
        if(othelo.result(Cell) > 0)
            System.out.println("                    Player 1 won this game ");
        if(othelo.result(Cell) < 0)
            System.out.println("                    Player 2 won this game ");
        if(othelo.result(Cell) == 0)
            System.out.println("                               draw    ");


    }


}
