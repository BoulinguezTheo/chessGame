package model.Pieces;

import model.Piece;

public class Knight extends Piece {
    public Knight(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "N";
    }
}
