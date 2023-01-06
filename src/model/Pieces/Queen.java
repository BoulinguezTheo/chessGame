package model.Pieces;

import model.Piece;

public class Queen extends Piece {
    public Queen(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "Q";
    }
}
