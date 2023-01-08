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
        return new ArrayList<int[]>();
    }
}
