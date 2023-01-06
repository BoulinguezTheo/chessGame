package model.Pieces;

import model.Piece;

public class Pawn extends Piece {

    public Pawn(){
        super.xCor = 0;
        super.yCor = 0;
        super.color = "none";
        super.representation = "X";
    }
    public Pawn(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "p";
    }

    
    

}
    

    
    
