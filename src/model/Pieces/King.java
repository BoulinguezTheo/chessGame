package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class King extends Piece {
    
    public King(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "K";
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
    private void bishopTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation) {
        int newXCor = super.xCor + pXIncrementation;
        int newYCor = super.yCor + pYIncrementation;

        if (newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7){
            if(pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")){
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor, newYCor});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                }
           }
        }
    }
    private void towerTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation){
        int newXCor = super.xCor + pXIncrementation;
        int newYCor = super.yCor + pYIncrementation;

        if (newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7) {
            if (pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")) {
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[]{newXCor, newYCor});
                if (encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())) {
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                }
            }
        }

    }

}
