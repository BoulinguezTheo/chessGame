package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Pawn extends Piece {
    private int initXCor;
    private int initYCor;
    private static final int blackSign = 1;
    private static final int whiteSign = -1;
    private int sign;

    public Pawn(){
        super.xCor = 0;
        super.yCor = 0;
        super.color = "none";
        super.representation = "X";
    }
    public Pawn(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        this.initXCor = super.xCor;
        super.yCor = pYCor;
        this.initYCor = super.yCor;
        super.color = pColor;
        this.sign = this.color.equals("b") ? whiteSign : blackSign;
        super.representation = "p";
    }

    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> availableMoves = new ArrayList<>();
        int incrementation1 = 1;
        int incrementation2 = 2;
        //normal move
        if (pBoard.getCells()[xCor + sign][yCor].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + sign, yCor});
        }
        //move to eat to the left
        int[] eatPiece1 = {xCor + sign, yCor + incrementation1};
        eatMove(eatPiece1, pBoard, availableMoves);

        //move to eat to the right
        int[] eatPiece2 = {xCor + sign, yCor - incrementation1};
        eatMove(eatPiece2, pBoard, availableMoves);

        if (xCor == initXCor && yCor == initYCor && pBoard.getCells()[xCor + (2 * sign)][yCor].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + incrementation2 * sign, yCor});
        }

        return availableMoves;
    }



    public void eatMove(int[] eatPiece, ChessData pBoard, ArrayList<int[]> pAvailableMoves) {
        if (eatPiece[xIndex] >= 0 && eatPiece[xIndex] <= 7 && eatPiece[yIndex] >= 0 && eatPiece[yIndex] <= 7 && !pBoard.getCells()[eatPiece[xIndex]][eatPiece[yIndex]].getCellContent().equals(" ")) {
            Piece pieceToEat = pBoard.getPiece(eatPiece);

            if (pieceToEat != null && !super.color.equals(pieceToEat.getColor())) {
                pAvailableMoves.add(new int[]{eatPiece[xIndex], eatPiece[yIndex]});
            }
        }
    }
}
    

    
    
