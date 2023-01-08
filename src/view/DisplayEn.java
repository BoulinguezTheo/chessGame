package view;

import model.ChessData;
import model.Player;

import java.util.Scanner;

public class DisplayEn{
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_WHITE = "\u001B[37m";
    protected static final String ANSI_RED = "\u001B[31m";
    Scanner inputUser;
    ChessData board;
    public DisplayEn(ChessData pBoard){
        inputUser = new Scanner(System.in);
        this.board = pBoard;
    }
    public String enterPlayerName(){
        return this.inputUser.nextLine();
    }

    public void displayBoard(Player player1, Player player2){
        System.out.println();
        System.out.println("                  " + player1.getName());
        System.out.println("-----------------------------------------");
        for(int i = 0; i < board.getBoardSize(); i++){
            for (int j = 0; j < board.getBoardSize(); j++){

                System.out.print(this.board.getCells()[i][j].getCellLeft());
                System.out.print((this.board.getCells()[i][j].getCellColor().equals("n") ? ANSI_RED : ANSI_WHITE) + this.board.getCells()[i][j].getCellContent() + ANSI_RESET);
                System.out.print(this.board.getCells()[i][j].getCellRight());
            }
            System.out.println("|");
            System.out.println("-----------------------------------------");
        }
        System.out.println("                  " + player2.getName());
        System.out.println();
    }

    public String askPlayerName(String pNumber){
        displayAskPlayerName(pNumber);
        return this.inputUser.nextLine();
    }
    public void displayAskPlayerName(String number){
        System.out.print("Enter player " + number +"'s name: ");
    }
    public String getInputCoordinates(){
        return inputUser.nextLine();
    }
    public void displayWrongInput(){
        System.out.println("Wrong input, please try again.");
    }
    public void displayPlayerTurn(){
        System.out.println(board.getActivePlayer().getName() + " it's your move.");
    }
    public void displayAskPieceToMove(){
        System.out.println("Choose a piece to move.");
    }
    public void displayAskMoveTo(){
        System.out.println("Where do you want to move the piece?");
    }
    public void displayEnterCoordinates(){
        System.out.print("Enter coordinates: ");
    }

}
