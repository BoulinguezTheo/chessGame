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
        return new ArrayList<int[]>();
    }
}
