package model;
import model.Pieces.Pawn;


import factory.Factory;

import java.util.ArrayList;

public class ChessData {
    final int boardSize = 8;
    Player player1;
    Player player2;
    Player activePlayer;
    ArrayList<Piece> pieceList;
    Cell cells[][];
    public ChessData(){
        this.cells = setupBoard();
        this.pieceList = setupPiece();
        this.activePlayer = Factory.createActivePlayer();
    }
    private Cell[][] setupBoard(){
        this.cells = new Cell[this.boardSize][this.boardSize];
        for(int i = 0; i < this.boardSize; i++){
            for (int j = 0; j < this.boardSize; j++){
                cells[i][j] = new Cell();
            }
        }
        return this.cells;
    }
    private ArrayList<Piece> setupPiece(){
        ArrayList<Piece> completeStart = new ArrayList<>();
        int countSetup = 0;
        int setupDesired = 2;
        int pieceNum0 = 0;
        int pieceNum1 = 1;
        int pieceNum2 = 2;

        while(countSetup != setupDesired){
            countSetup++;
            String setColor = (countSetup == 1 ? "n" : "b");
            initPawnSetInCell(completeStart, setColor, countSetup);
            initPieceSetInCell(completeStart, pieceToCreate("tower", setColor, pieceNum1));
            initPieceSetInCell(completeStart, pieceToCreate("tower", setColor, pieceNum2));
            initPieceSetInCell(completeStart, pieceToCreate("knight", setColor, pieceNum1));
            initPieceSetInCell(completeStart, pieceToCreate("knight", setColor, pieceNum2));
            initPieceSetInCell(completeStart, pieceToCreate("bishop", setColor, pieceNum1));
            initPieceSetInCell(completeStart, pieceToCreate("bishop", setColor, pieceNum2));
            initPieceSetInCell(completeStart, pieceToCreate("queen", setColor, pieceNum0));
            initPieceSetInCell(completeStart, pieceToCreate("king", setColor, pieceNum0));
        }
        return  completeStart;
    }
    private Piece pieceToCreate(String pPieceToCreate, String setColor, int pieceNum){
        return switch(pPieceToCreate){
            case "tower" -> Factory.createTower(setColor, pieceNum);
            case "knight" -> Factory.createKnight(setColor, pieceNum);
            case "bishop" -> Factory.createBishop(setColor, pieceNum);
            case "queen" -> Factory.createQueen(setColor);
            case "king" -> Factory.createKing(setColor);
            default -> new Pawn();
        };
    }
    private void initPawnSetInCell(ArrayList<Piece> pCompleteList, String pColor, int playerPiece){
        for (int i = 0; i < this.boardSize; i++){
            Piece pawn = Factory.createPawn((playerPiece == 1 ? 1 : 6) , i, pColor);
            pCompleteList.add(pawn);
            this.cells[pawn.getXCor()][pawn.getYCor()].setCellContent(pawn.getRepresentation(), pawn.getColor());
        }
    }
    private void initPieceSetInCell(ArrayList<Piece> pCompleteList, Piece pPiece){
        pCompleteList.add(pPiece);
        this.cells[pPiece.getXCor()][pPiece.getYCor()].setCellContent(pPiece.getRepresentation(), pPiece.getColor());
    }



    /*
     * GETTER AND SETTER SECTION
     **/
    public void setPlayer1(String pName, String pColor){
        this.player1 = Factory.createPlayer(pName, pColor);
    }
    public void setPlayer2(String pName, String pColor){
        this.player2 = Factory.createPlayer(pName, pColor);
    }
    public void setActivePlayer(){
        this.activePlayer = (this.activePlayer == this.player1) ? this.player2 : this.player1;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Player getActivePlayer(){
        return this.activePlayer;
    }
    public int getBoardSize() {
        return boardSize;
    }
    public Cell[][] getCells() {
        return cells;
    }
    public Piece getPiece(int[] pCoordinates){
        int xCor = pCoordinates[0];
        int yCor = pCoordinates[1];
        for(Piece piece : pieceList){
            if(piece.getXCor() == xCor && piece.getYCor() == yCor){
                return piece;
            }
        }
        return null;
    }
    public ArrayList<Piece> getPieceList() {
        return pieceList;
    }

}
