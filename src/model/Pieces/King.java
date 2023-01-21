package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class King extends Piece {
    
    public King(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        super.yCor = pYCor;
        super.color = pColor;
        super.representation = "K";
    }
    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> movesAvailable = generateMoves(pBoard);

        movesAvailable = removeCheckPosition(pBoard, movesAvailable);

        return movesAvailable;
    }
    public ArrayList<int[]> generateMoves(ChessData pBoard){
        ArrayList<int[]> pMovesAvailable = new ArrayList<>();
        int xIncrementation1 = 1;
        int xIncrementation2 = -1;
        int xIncrementation3 = 0;

        int yIncrementation1 = 1;
        int yIncrementation2 = -1;
        int yIncrementation3 = 0;

        bishopTypeMoves(pBoard, pMovesAvailable, xIncrementation1, yIncrementation1);
        bishopTypeMoves(pBoard, pMovesAvailable, xIncrementation1, yIncrementation2);
        bishopTypeMoves(pBoard, pMovesAvailable, xIncrementation2, yIncrementation1);
        bishopTypeMoves(pBoard, pMovesAvailable, xIncrementation2, yIncrementation2);

        towerTypeMoves(pBoard, pMovesAvailable, xIncrementation1, yIncrementation3);
        towerTypeMoves(pBoard, pMovesAvailable, xIncrementation2, yIncrementation3);
        towerTypeMoves(pBoard, pMovesAvailable, xIncrementation3, yIncrementation1);
        towerTypeMoves(pBoard, pMovesAvailable, xIncrementation3, yIncrementation2);

        return pMovesAvailable;
    }

    private ArrayList<int[]> removeCheckPosition(ChessData pBoard, ArrayList<int[]> pMovesAvailable) {
        ArrayList<Piece> pieceList = pBoard.getPieceList();
        Set<int[]> otherPiecesMoves = new LinkedHashSet<>();
        int i = 0;
        //for (Piece piece : pieceList) {
          //  i++;
          //  if (!piece.getColor().equals(color)) {
            //    otherPiecesMoves.addAll(piece.getMovesPossible(pBoard));
            //}
        //}
        for (int j = 0; j < pieceList.size(); j ++){
                Piece piece = pieceList.get(j);
                if(piece.getRepresentation().equals(representation) && !piece.getColor().equals(color)){
                    otherPiecesMoves.addAll(piece.generateMoves(pBoard));
                } else if (!piece.getColor().equals(color)) {
                    otherPiecesMoves.addAll(piece.getMovesPossible(pBoard));
                }
        }

        //ArrayList<int[]> combinedList = new ArrayList<>(otherPiecesMoves);
        ArrayList<int[]> movesToRemove = new ArrayList<>();
        for (int[] kingMove : pMovesAvailable){
            int xKing = kingMove[0];
            int yKing = kingMove[1];

            for(int[] move : otherPiecesMoves){
                int xPiece = move[0];
                int yPiece = move[1];

                if(xKing == xPiece && yKing == yPiece){
                    movesToRemove.add(move);
                }
            }
        }
        otherPiecesMoves.removeAll(movesToRemove);
        return new ArrayList<int[]>(otherPiecesMoves) ;
    }

    private void bishopTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation) {
        int newXCor = super.xCor + pXIncrementation;
        int newYCor = super.yCor + pYIncrementation;

        if (newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7){
            if(pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")){
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[] {newXCor, newYCor});
                if(encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())){
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                }
           }
        }
    }
    private void towerTypeMoves(ChessData pBoard, ArrayList<int[]> pMovesAvailable, int pXIncrementation, int pYIncrementation){
        int newXCor = this.xCor + pXIncrementation;
        int newYCor = this.yCor + pYIncrementation;

        if (newXCor >= 0 && newXCor <= 7 && newYCor >= 0 && newYCor <= 7) {
            if (pBoard.getCells()[newXCor][newYCor].getCellContent().equals(" ")) {
                pMovesAvailable.add(new int[]{newXCor, newYCor});
            } else {
                Piece encounteredPiece = pBoard.getPiece(new int[]{newXCor, newYCor});
                if (encounteredPiece != null && !super.color.equals(encounteredPiece.getColor())) {
                    pMovesAvailable.add(new int[]{newXCor, newYCor});
                }
            }
        }

    }

}
