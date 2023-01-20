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

        return new ArrayList<int[]>();
    }
}
