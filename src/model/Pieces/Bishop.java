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
        int newXCor1 = super.xCor + 1;
        int newYCor1 = super.yCor + 1;
        //
        while(newXCor1 >= 0 && newXCor1 <= 7 && newYCor1 >= 0 && newYCor1 <= 7){
            if(pBoard.getCells()[newXCor1][newYCor1].getCellContent().equals(" ")){
                movesAvailable.add(new int[]{newXCor1, newYCor1});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor1, newYCor1});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    movesAvailable.add(new int[]{newXCor1, newYCor1});
                    break;
                } else {
                    break;
                }
            }
            newXCor1++;
            newYCor1++;
        }
        //
        int newXCor2 = super.xCor + 1;
        int newYCor2 = super.yCor -1;
        while(newXCor2 >= 0 && newXCor2 <= 7 && newYCor2 >= 0 && newYCor2 <= 7){
            if(pBoard.getCells()[newXCor2][newYCor2].getCellContent().equals(" ")){
                movesAvailable.add(new int[]{newXCor2, newYCor2});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor2, newYCor2});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    movesAvailable.add(new int[]{newXCor2, newYCor2});
                    break;
                } else {
                    break;
                }
            }
            newXCor2++;
            newYCor2--;
        }
        //
        int newXCor3 = super.xCor - 1;
        int newYCor3 = super.yCor + 1;
        while(newXCor3 >= 0 && newXCor3 <= 7 && newYCor3 >= 0 && newYCor3 <= 7){

            if(pBoard.getCells()[newXCor3][newYCor3].getCellContent().equals(" ")){
                movesAvailable.add(new int[]{newXCor3, newYCor3});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor3, newYCor3});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    movesAvailable.add(new int[]{newXCor3, newYCor3});
                    break;
                } else {
                    break;
                }
            }
            newXCor3--;
            newYCor3++;
        }
        //
        int newXCor4 = super.xCor - 1;
        int newYCor4 = super.yCor -1;
        while(newXCor4 >= 0 && newXCor4 <= 7 && newYCor4 >= 0 && newYCor4 <= 7){

            if(pBoard.getCells()[newXCor4][newYCor4].getCellContent().equals(" ")){
                movesAvailable.add(new int[]{newXCor4, newYCor4});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor4, newYCor4});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    movesAvailable.add(new int[]{newXCor4, newYCor4});
                    break;
                } else {
                    break;
                }
            }
            newXCor4--;
            newYCor4--;
        }

        return movesAvailable;
    }
}
