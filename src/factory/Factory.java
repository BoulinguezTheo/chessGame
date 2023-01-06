package factory;

import model.*;
import model.Pieces.*;

public class Factory {
    public static Player createPlayer(String pName){
        return new Player(pName);
    }
    public static Piece createPawn(int xCor, int yCor, String color){
        return new Pawn(xCor, yCor, color);
    }
    public static Piece createTower(String color, int pieceNum){
        int xCor = color.equals("n") ? 0 : 7;
        int yCor = pieceNum == 1 ? 0 : 7;
        return new Tower(xCor, yCor, color);
    }
    public static Piece createKnight(String color, int pieceNum){
        int xCor = color.equals("n") ? 0 : 7;
        int yCor = pieceNum == 1 ? 1 : 6;
        return new Knight(xCor, yCor, color);
    }
    public static Piece createBishop(String color, int pieceNum){
        int xCor = color.equals("n") ? 0 : 7;
        int yCor = pieceNum == 1 ? 2 : 5;
        return new Bishop(xCor, yCor, color);
    }
    public static Piece createQueen(String color){
        int xCor = color.equals("n") ? 0 : 7;
        int yCor = color.equals("n") ? 4 : 3;
        return new Queen(xCor, yCor, color);
    }
    public static Piece createKing(String color){
        int xCor = color.equals("n") ? 0 : 7;
        int yCor = color.equals("n") ? 3 : 4;
        return new King(xCor, yCor, color);
    }
}
