package com.company;

import java.util.List;

public class GameSystem {
    public static void main(String[] args) {
        int tamaaaam = 0;
        int turn = 1;
        int[] Cell = new int[64];
        Board board = new Board();
        GameSystem othello = new GameSystem();
        board.firstValue(Cell);
        User user1 = new User(true);
        User user2 = new User(true);
        cloudyPlayer userSup = new cloudyPlayer(false, Cell);
        int aim;
        while (true) {
            userSup.setNumberOfChoices(0);
            userSup.setAll(turn, Cell);
            if (userSup.checking()) {
                System.out.println(" Pass ... ");
                turn++;
                tamaaaam++;
                userSup.setNumberOfChoices(0);
                userSup.setAll(turn, Cell);
                if (userSup.checking()) {
                    break;
                }
            }
            board.printing(Cell, turn);
            aim = user1.scanning();
            user1.check(aim, Cell, turn);
            turn++;
            userSup.setNumberOfChoices(0);
            userSup.setAll(turn, Cell);
            if (userSup.checking()) {
                System.out.println(" Pass ... ");
                turn++;
                tamaaaam++;
                userSup.setNumberOfChoices(0);
                userSup.setAll(turn, Cell);
                if (userSup.checking()) {
                    break;
                }
                board.printing(Cell, turn);
                aim = user2.scanning();
                user2.check(aim, Cell, turn);
                turn++;

            }

        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("bazi tamoom shod");
    }
}
