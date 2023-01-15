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
        //normal move
        if (pBoard.getCells()[xCor + sign][yCor].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + sign, yCor});
        }
        //move to eat to the left
        int[] eatPiece1 = {xCor + sign, yCor + 1};
        eatMove(eatPiece1, pBoard, availableMoves);

        //move to eat to the right
        int[] eatPiece2 = {xCor + sign, yCor - 1};
        eatMove(eatPiece2, pBoard, availableMoves);

        if (xCor == initXCor && yCor == initYCor && pBoard.getCells()[xCor + (2 * sign)][yCor].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + 2 * sign, yCor});
        }

        return availableMoves;
    }

    public void eatMove(int[] eatPiece, ChessData pBoard, ArrayList<int[]> pAvailableMoves) {
        if (eatPiece[0] >= 0 && eatPiece[0] <= 7 && eatPiece[1] >= 0 && eatPiece[1] <= 7 && !pBoard.getCells()[eatPiece[0]][eatPiece[1]].getCellContent().equals(" ")) {
            //Piece pieceToEat = pBoard.getPiece(eatPiece);
            Piece pieceToEat2 = pBoard.getPiece(eatPiece);

            if (pieceToEat2 != null && !super.color.equals(pieceToEat2.getColor())) {
                pAvailableMoves.add(new int[]{eatPiece[0], eatPiece[1]});
            }
        }
    }
}
    

    
    
