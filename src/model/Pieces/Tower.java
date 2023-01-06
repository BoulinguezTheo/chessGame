package model.Pieces;

import model.Piece;

public class Tower extends Piece {
    

    public Tower(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "T";
    }
}
