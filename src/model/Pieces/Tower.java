package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class Tower extends Piece {
    

    public Tower(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "T";
    }
    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> movesAvailable = new ArrayList<>();
        //1
        int xIncrementation1 = 1;
        int yIncrementation1 = 0;
        towerMoves(pBoard, movesAvailable, xIncrementation1, yIncrementation1);
        //2
        int xIncrementation2 = -1;
        towerMoves(pBoard, movesAvailable, xIncrementation2, yIncrementation1);
        //3
        int xIncrementation3 = 0;
        int yIncrementation2 = 1;
        towerMoves(pBoard, movesAvailable, xIncrementation3, yIncrementation2);
        //4
        int yIncrementation3 = -1;
        towerMoves(pBoard, movesAvailable, xIncrementation3, yIncrementation3);
        
        return movesAvailable;
    }

    private void towerMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation){
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
