package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "N";
    }

    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> availablesMoves = new ArrayList<>();
        int incrementation1 = 1;
        int incrementation2 = 2;
        int[] firstMove = {(xCor + incrementation2), (yCor + incrementation1)};
        addMove(firstMove, pBoard, availablesMoves);

        int[] secondMove = {(xCor + incrementation2), (yCor - incrementation1)};
        addMove(secondMove, pBoard, availablesMoves);

        int[] thirdMove = {(xCor + incrementation1), (yCor - incrementation2)};
        addMove(thirdMove, pBoard, availablesMoves);

        int[] fourthMove = {(xCor - incrementation1), (yCor - incrementation2)};
        addMove(fourthMove, pBoard, availablesMoves);

        int[] fifthMove = {(xCor - incrementation2), (yCor + incrementation1)};
        addMove(fifthMove, pBoard, availablesMoves);

        int[] sixthMove = {(xCor - incrementation2), (yCor - incrementation1)};
        addMove(sixthMove, pBoard, availablesMoves);

        int[] seventhMove = {(xCor - incrementation1), (yCor + incrementation2)};
        addMove(seventhMove, pBoard, availablesMoves);

        int[] eightMove = {(xCor + incrementation1), (yCor + incrementation2)};
        addMove(eightMove, pBoard, availablesMoves);

        return availablesMoves;
    }

    @Override
    public ArrayList<int[]> generateMoves(ChessData pBoard) {
        return null;
    }

    private void addMove(int[] pMove, ChessData pBoard, ArrayList<int[]> pAvailableMoves){

        if(pMove[xIndex] >= 0 && pMove[xIndex] <= 7 && pMove[yIndex] >= 0 && pMove[yIndex] <= 7){
            Piece pieceToEat = pBoard.getPiece(pMove);
            if(pBoard.getCells()[pMove[xIndex]][pMove[yIndex]].getCellContent().equals(" ")){
                pAvailableMoves.add(pMove);
            } else if(pieceToEat != null && !pBoard.getCells()[pMove[xIndex]][pMove[yIndex]].getCellContent().equals(" ") && !color.equals(pieceToEat.getColor())){
                pAvailableMoves.add(pMove);
            }
        }
    }
}
