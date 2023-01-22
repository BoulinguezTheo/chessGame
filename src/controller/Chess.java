package controller;

import model.ChessData;
import model.Piece;
import java.util.ArrayList;
import view.DisplayEn;



public class Chess {
    DisplayEn interactions;
    ChessData board;
    private TurnState stateMachine;
    private final static int xIndex = 0;
    private final static int yIndex = 1;
private final static int asciiA = 97;
    private final static int ascii1 = 49;

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
        stateMachine = TurnState.STARTTURN;
        Piece pieceToMove = null;
        int[] coordinatesDestination = null;

        while(stateMachine != stateMachine.END){

            switch(stateMachine){
                case STARTTURN:
                    this.interactions.displayBoard(this.board.getPlayer1(), this.board.getPlayer2());
                    interactions.displayPlayerTurn();
                    stateMachine = TurnState.GETMOVE;
                    break;
                case GETMOVE:
                    pieceToMove = getPieceToMove();
                    interactions.displayAskMoveTo();
                    interactions.displayEnterCoordinates();
                    coordinatesDestination = getCoordinates();
                    stateMachine = correctMove(coordinatesDestination, pieceToMove) ? TurnState.MOVE : TurnState.GETMOVE;
                    break;
                case MOVE:
                    stateMachine = moveType(coordinatesDestination);
                    break;
                case SETNEWCOORDINATES:
                    this.board.getCells()[pieceToMove.getXCor()][pieceToMove.getYCor()].setCellContent(" ", " ");
                    movePiece(pieceToMove, coordinatesDestination);
                    this.board.getCells()[coordinatesDestination[0]][coordinatesDestination[1]].setCellContent(pieceToMove.getRepresentation(), pieceToMove.getColor());
                    this.board.setActivePlayer();
                    stateMachine = isCheck(pieceToMove) ? TurnState.CHECK : TurnState.STARTTURN;
                    break;
                case REMOVEPIECE:
                    board.getPieceList().remove(board.getPiece(coordinatesDestination));
                    stateMachine = TurnState.SETNEWCOORDINATES;
                    break;
                case CHECK:
                    this.interactions.displayBoard(this.board.getPlayer1(), this.board.getPlayer2());
                    interactions.displayPlayerTurn();
                    interactions.displayCheckState();
                    pieceToMove = getPieceToMove();
                    interactions.displayAskMoveTo();
                    interactions.displayEnterCoordinates();
                    coordinatesDestination = getCoordinates();
                    if (correctMove(coordinatesDestination, pieceToMove) && !isCheck(pieceToMove)){
                        stateMachine = TurnState.MOVE;
                    }

                    break;
            }
        }
    }
    private boolean isCheck(Piece pPieceToMove){
        Piece adversaryKing = board.getPieceByRepresentation("K");
        int xKing = adversaryKing.getXCor();
        int yKing = adversaryKing.getYCor();

        ArrayList<int[]> pieceToMoveNextMove = pPieceToMove.getMovesPossible(board);
        for (int[] nextMove : pieceToMoveNextMove){
            int nextX = nextMove[xIndex];
            int nextY = nextMove[yIndex];
            if (nextX == xKing && nextY == yKing){
                return true;
            }
        }
        return false;
    }

    private TurnState moveType(int[] pCoordinates){
        if(!board.getCells()[pCoordinates[xIndex]][pCoordinates[yIndex]].getCellContent().equals(" ")){
            return TurnState.REMOVEPIECE;
        } else {
            return TurnState.SETNEWCOORDINATES;
        }
    }


    private Piece getPieceToMove(){
        boolean validPiece;
        Piece piece;
        interactions.displayAskPieceToMove();
        interactions.displayEnterCoordinates();
        int[] coordinates = null;
        do {
            coordinates = getCoordinates();
            piece = board.getPiece(coordinates);
            if (piece == null) {
                interactions.displayWrongInput();
                interactions.displayEnterCoordinates();
                validPiece = false;
            } else if (!this.board.getActivePlayer().getColor().equalsIgnoreCase(piece.getColor())){
                interactions.displayWrongInput();
                interactions.displayEnterCoordinates();
                coordinates = getCoordinates();
                validPiece = false;
            }else {
                validPiece = true;
            }
        } while(!validPiece);
        return piece;
    }
    private int[] getCoordinates(){
        int columnInput;
        int lineInput;
        boolean validInput;
            String pieceToMove = this.interactions.getInputCoordinates().toLowerCase();
        do {
            while(pieceToMove.length() != 2){
                interactions.displayWrongInput();
                interactions.displayEnterCoordinates();
                pieceToMove = this.interactions.getInputCoordinates().toLowerCase();
            }
            columnInput = (pieceToMove.charAt(0)) - asciiA;
            lineInput = (pieceToMove.charAt(1)) - ascii1;
            if (columnInput >= 0 && columnInput <= 7 && lineInput >= 0 && lineInput <= 7){
                validInput = true;
            } else {
                validInput = false;
                interactions.displayWrongInput();
                interactions.displayEnterCoordinates();
                pieceToMove = this.interactions.getInputCoordinates().toLowerCase();
            }
        } while(!validInput);
        return new int[] {lineInput, columnInput};
    }
    private boolean isMoveAvailable(int[] pCoordinates, Piece pPieceToMove){
        ArrayList<int[]> movesPossible = pPieceToMove.getMovesPossible(board);
        for(int[] move : movesPossible){
            if(move[xIndex] == pCoordinates[xIndex] && move[yIndex] == pCoordinates[yIndex]){
                return true;
            }
        }
        return false;
    }
    private boolean correctMove(int[] pCoordinatesDestination, Piece pPieceToMove){
        if(isMoveAvailable(pCoordinatesDestination, pPieceToMove)){
            return true;
        }else {
            interactions.displayMoveNotAllowed();
            return false;
        }

    }
    private TurnState movePiece(Piece pPiece, int[] pCoordinates){
        pPiece.setXCor(pCoordinates[xIndex]);
        pPiece.setYCor(pCoordinates[yIndex]);
        return TurnState.MOVE;
    }


}
