package TicTacToe;

import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        TTT game=new TTT();
        System.out.println("    TICTACTOE   \n\n");
        do{
            game.printTable();
            System.out.println(game.player+"'s turn");
            if(game.insert(sc.nextInt())){
                if(game.haveWon()){
                    System.out.println("Player "+game.player+" won the game!!!");
                    break;
                }
            }
            else{
                System.out.println("Invalid entry");  
            } 
        }while(true);
        sc.close();
    }
}
