package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "Q";
    }
    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> movesAvailable = new ArrayList<>();
        int xIncrementation1 = 1;
        int xIncrementation2 = -1;
        int xIncrementation3 = 0;

        int yIncrementation1 = 1;
        int yIncrementation2 = -1;
        int yIncrementation3 = 0;

        bishopTypeMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation1);
        bishopTypeMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation2);
        bishopTypeMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation1);
        bishopTypeMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation2);

        towerTypeMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation3);
        towerTypeMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation3);
        towerTypeMoves(pBoard, movesAvailable, xIncrementation3, yIncrementation1);
        towerTypeMoves(pBoard, movesAvailable, xIncrementation3, yIncrementation2);

        return movesAvailable;
    }

    @Override
    public ArrayList<int[]> generateMoves(ChessData pBoard) {
        return null;
    }

    private void bishopTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation) {
        int newXCor = super.xCor + pXIncrementation;
        int newYCor = super.yCor + pYIncrementation;
        while(newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7){
            if(pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")){
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor, newYCor});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                    break;
                } else {
                    break;
                }
            }
            newXCor += pXIncrementation;
            newYCor += pYIncrementation;
        }
    }
    private void towerTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation){
        int newXCor = super.xCor + pXIncrementation;
        int newYCor = super.yCor + pYIncrementation;
        while(newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7){
            if(pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")){
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor, newYCor});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                    break;
                } else {
                    break;
                }
            }
            newXCor += pXIncrementation;
            newYCor += pYIncrementation;
        }
    }
}
