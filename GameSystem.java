package com.company;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * our first project , simulation of othelo game
 * @author Ali
 * @version 0.0
 */
public class GameSystem {
    public static void main(String[] args) throws InterruptedException {
        // set the turn of the player
        int turn = 1;
        int[] Cell = new int[64];
        int a ;
        Board board = new Board();
        GameSystem othello = new GameSystem();
        board.firstValue(Cell);
        User user1 = new User(true ,true);
        User user2 = new User(true , true);
        PcPlayer PC = new PcPlayer(true, Cell , false);
        CloudyPlayer userSup = new CloudyPlayer(false, Cell , false);
        int aim;
        // maybe now we show the menu
        Scanner Input = new Scanner(System.in);
        System.out.println("1- one Player");
        System.out.println("2- play to getter");
         a = Input.nextInt() ;
        while (true) {
            if(a==2)
            {
                if (userSup.checking(turn, Cell) == 0) {
                    System.out.println(" Pass ... ");
                    othello.timeSleep();
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
                    othello.timeSleep();
                    turn++;

                    if (userSup.checking(turn, Cell) == 0) {
                        break;
                    }
                }
                board.printing(Cell, turn);
                aim = user2.scanning();
                System.out.println(aim);
                user2.check(aim, Cell, turn);
                turn++;

            }
            if(a==1) {
                if (userSup.checking(turn, Cell) == 0) {
                    System.out.println(" Pass ... ");
                    othello.timeSleep();
                    turn++;

                    if (userSup.checking(turn, Cell) == 0) {
                        break;
                    }
                }
                board.printing(Cell, turn);
                aim = user1.scanning();
                othello.timeSleep();
                user1.check(aim, Cell, turn);
                turn++;
                if (userSup.checking(turn, Cell) == 0) {
                    System.out.println(" Pass ... ");
                    othello.timeSleep();
                    turn++;

                    if (userSup.checking(turn, Cell) == 0) {
                        break;
                    }
                }
                board.printing(Cell, turn);
                othello.timeSleep();
                PC.put(Cell, turn);
                othello.timeSleep();
                turn++;
            }
            }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        Board.e();
        Board.n();
        Board.d();
    }

    /**
     * for wait just a little
     * @throws InterruptedException
     */
    public  void timeSleep() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1);
    }
    }

