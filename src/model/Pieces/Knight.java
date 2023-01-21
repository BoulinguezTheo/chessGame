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
        int[] firstMove = {(xCor + 2), (yCor - 1)};
        addMove(firstMove, pBoard, availablesMoves);

        int[] secondMove = {(xCor + 2), (yCor + 1)};
        addMove(secondMove, pBoard, availablesMoves);

        int[] thirdMove = {(xCor - 2), (yCor - 1)};
        addMove(thirdMove, pBoard, availablesMoves);

        int[] fourthMove = {(xCor - 2), (yCor + 1)};
        addMove(fourthMove, pBoard, availablesMoves);

        int[] fifthMove = {(xCor + 1), (yCor - 2)};
        addMove(fifthMove, pBoard, availablesMoves);

        int[] sixthMove = {(xCor - 1), (yCor - 2)};
        addMove(sixthMove, pBoard, availablesMoves);

        int[] seventhMove = {(xCor + 1), (yCor + 2)};
        addMove(seventhMove, pBoard, availablesMoves);

        int[] eightMove = {(xCor - 1), (yCor + 2)};
        addMove(eightMove, pBoard, availablesMoves);

        return availablesMoves;
    }

    @Override
    public ArrayList<int[]> generateMoves(ChessData pBoard) {
        return null;
    }

    private void addMove(int[] pMove, ChessData pBoard, ArrayList<int[]> pAvailableMoves){

        if(pMove[0] >= 0 && pMove[0] <= 7 && pMove[1] >= 0 && pMove[1] <= 7){
            Piece pieceToEat = pBoard.getPiece(pMove);
            if(pBoard.getCells()[pMove[0]][pMove[1]].getCellContent().equals(" ")){
                pAvailableMoves.add(pMove);
            } else if(!pBoard.getCells()[pMove[0]][pMove[1]].getCellContent().equals(" ") && !super.color.equals(pieceToEat.getColor())){
                pAvailableMoves.add(pMove);
            }
        }
    }
}
