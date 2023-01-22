package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class Bishop extends Piece {
    

    public Bishop(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "B";
    }
    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> movesAvailable = new ArrayList<>();
        int xIncrementation1 = 1;
        int xIncrementation2 = -1;
        int yIncrementation1 = 1;
        int yIncrementation2 = -1;
        bishopMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation1);
        bishopMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation2);
        bishopMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation1);
        bishopMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation2);

        return movesAvailable;
    }

    private void bishopMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation){
        int newXCor = xCor + pXIncrementation;
        int newYCor = yCor + pYIncrementation;

        while(newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7){
            if(pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")){
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor, newYCor});
                if (encounteredPiece != null && !color.equals(encounteredPiece.getColor())){
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                }
                break;
            }
            newXCor += pXIncrementation;
            newYCor += pYIncrementation;
        }
    }
}
