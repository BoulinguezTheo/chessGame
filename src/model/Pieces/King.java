package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.*;

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
        ArrayList<int[]> copyMovesAvailable = pMovesAvailable;
        ArrayList<Piece> pieceList = pBoard.getPieceList();
        Set<int[]> otherPiecesMoves = new LinkedHashSet<>();

        for(Piece piece : pieceList){
            if(piece.getRepresentation().equals(representation) && !piece.getColor().equals(color)){
                otherPiecesMoves.addAll(piece.generateMoves(pBoard));
            } else if (!piece.getColor().equals(color)) {
                otherPiecesMoves.addAll(piece.getMovesPossible(pBoard));
            }
        }

        ArrayList<int[]> movesToRemove = new ArrayList<>();
        for(int i = 0; i < copyMovesAvailable.size(); i++){
            int[] kingMove = copyMovesAvailable.get(i);
            int xKing = kingMove[xIndex];
            int yKing = kingMove[yIndex];

            for(int[] move : otherPiecesMoves){
                int xPiece = move[xIndex];
                int yPiece = move[yIndex];

                if(xKing == xPiece && yKing == yPiece){
                    copyMovesAvailable.remove(i);
                    i--;
                }
            }
        }
        copyMovesAvailable.removeAll(movesToRemove);
        return copyMovesAvailable;
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
