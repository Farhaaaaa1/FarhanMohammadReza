package com.company;

public class GameSystem {
    public static void main(String[] args) {
        int tamaaaam = 0;
        int turn = 1;
        int[] Cell = new int[64];
        Board board = new Board();
        GameSystem othello = new GameSystem();
        board.firstValue(Cell);
        User user1 = new User(true ,true);
        User user2 = new User(true , true);
        PCplayer PC = new PCplayer(true, Cell , false);
        CloudyPlayer userSup = new CloudyPlayer(false, Cell , false);
        int aim;
        while (true) {

            if (userSup.checking(turn, Cell) == 0) {
                System.out.println(" Pass ... ");
                turn++;

                if (userSup.checking(turn, Cell) == 0) {
                    break;
                }
            }


            board.printing(Cell, turn);
            aim = user1.scanning();
            user1.check(aim, Cell, turn);
            turn++;

            if (userSup.checking(turn, Cell) == 0) {
                System.out.println(" Pass ... ");
                turn++;

                if (userSup.checking(turn, Cell) == 0) {
                    break;
                }
            }
            board.printing(Cell, turn);
            System.out.println("inja hastim");
            PC.put(Cell , turn);
            System.out.println("tamooom shod");
            turn++;

//                aim = user2.scanning();
//                user2.check(aim, Cell, turn);
//                turn++;

        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("bazi tamoom shod");
    }
    }

