package controller;

import model.ChessData;
import model.Piece;
import model.Pieces.Pawn;
import view.DisplayEn;
import java.util.ArrayList;



public class Chess {
    DisplayEn interactions;
    ChessData board;
    private TurnState stateMachine;


    public Chess(){
        // Setup Objects needed
        this.board = new ChessData();
        this.interactions = new DisplayEn(this.board);
        //Setup Player
        this.board.setPlayer1(interactions.askPlayerName("1"), "n");
        this.board.setPlayer2(interactions.askPlayerName("2"), "b");
        this.board.setActivePlayer();
        //Setup Board

    }

    public void play(){
        stateMachine = TurnState.GETMOVE;
        Piece pieceToMove = null;
        int[] coordinatesDestination = null;

        while(stateMachine != stateMachine.END){
            
            this.interactions.displayBoard(this.board.getPlayer1(), this.board.getPlayer2());
            switch(stateMachine){
                case STARTTURN:
                    this.interactions.displayBoard(this.board.getPlayer1(), this.board.getPlayer2());
                    stateMachine = TurnState.GETMOVE;
                    break;
                case GETMOVE:
                    pieceToMove = getPieceToMove();
                    coordinatesDestination = getCoordinates();
                    stateMachine = correctMove(coordinatesDestination, pieceToMove);
                    break;
                case MOVE:
                    stateMachine = moveType(coordinatesDestination);
                    break;
                case SETNEWCOORDINATES:
                    movePiece(pieceToMove, coordinatesDestination);
                    this.board.setActivePlayer();
                    break;
            }
        }

    }

    private TurnState moveType(int[] pCoordinates){
        if(!board.getCells()[pCoordinates[0]][pCoordinates[1]].getCellContent().equals(" ")){
            return TurnState.REMOVEPIECE;
        } else {
            return TurnState.SETNEWCOORDINATES;
        }
    }


    private Piece getPieceToMove(){
        boolean validPiece;
        Piece piece;
        int[] coordinates = getCoordinates();
        do {
            piece = board.getPiece(coordinates);
            if (!this.board.getActivePlayer().getColor().equalsIgnoreCase(piece.getColor())) {
                this.interactions.askAgainPieceToMove();
                coordinates = getCoordinates();
                validPiece = false;
            } else {
                validPiece = true;
            }
        } while(!validPiece);
        return piece;
    }
    private int[] getCoordinates(){
        int columnInput;
        int lineInput;
        boolean validInput;
            String pieceToMove = this.interactions.askPieceToMove().toLowerCase();
        do {
            columnInput = (pieceToMove.charAt(0)) - 97;
            lineInput = Integer.parseInt(String.valueOf(pieceToMove.charAt(1))) - 1;

            if (columnInput >= 0 && columnInput <= 7 && lineInput >= 0 && lineInput <= 7){
                validInput = true;
            } else {
                validInput = false;
                pieceToMove = this.interactions.askAgainPieceToMove().toLowerCase();
            }
        } while(!validInput);
        return new int[] {lineInput, columnInput};
    }
    private boolean isMoveAvailable(int[] pCoordinates, Piece pPieceToMove){
        ArrayList<int[]> movesPossible = pPieceToMove.getMovesPossible(board);
        for(int[] move : movesPossible){
            if(move == pCoordinates){
                return true;
            }
        }
        return false;
    }
    private TurnState correctMove(int[] pCoordinatesDestination, Piece pPieceToMove){
        if(!isMoveAvailable(pCoordinatesDestination, pPieceToMove)){
            return stateMachine.MOVE;
        }
        return stateMachine.GETMOVE;
    }
    private TurnState movePiece(Piece pPiece, int[] pCoordinates){
        pPiece.setXCor(pCoordinates[0]);
        pPiece.setYCor(pCoordinates[1]);
        return TurnState.MOVE;
    }


}
