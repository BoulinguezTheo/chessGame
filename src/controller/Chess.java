package controller;

import model.ChessData;
import view.DisplayEn;


public class Chess {
    DisplayEn interactions;
    ChessData board;


    public Chess(){
        // Setup Objects needed
        this.board = new ChessData();
        this.interactions = new DisplayEn(this.board);
        //Setup Player
        this.board.setPlayer1(interactions.askPlayerName("1"));
        this.board.setPlayer2(interactions.askPlayerName("1"));
        //Setup Board
        this.interactions.displayBoard(this.board.getBoardSize(), this.board.getCells(), this.board.getPlayer1(), this.board.getPlayer2());
    }

    public void play(){
        getMove();
    }

    private void getMove(){
        String pieceToMove = this.interactions.askPieceToMove();
        do {

            if (pieceToMove.charAt(0).equals
        }
    }


}
