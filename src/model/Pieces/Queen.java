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
        int incrementation1 = 1;
        int decrementation1 = -1;
        int noIncrementation = 0;

        bishopTypeMoves(pBoard, movesAvailable, incrementation1, incrementation1);
        bishopTypeMoves(pBoard, movesAvailable, incrementation1, decrementation1);
        bishopTypeMoves(pBoard, movesAvailable, decrementation1, incrementation1);
        bishopTypeMoves(pBoard, movesAvailable, decrementation1, decrementation1);

        towerTypeMoves(pBoard, movesAvailable, incrementation1, noIncrementation);
        towerTypeMoves(pBoard, movesAvailable, decrementation1, noIncrementation);
        towerTypeMoves(pBoard, movesAvailable, noIncrementation, incrementation1);
        towerTypeMoves(pBoard, movesAvailable, noIncrementation, decrementation1);

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
                }
                break;
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
                }
                break;
            }
            newXCor += pXIncrementation;
            newYCor += pYIncrementation;
        }
    }
}
