package model;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece {
    protected final static int xIndex = 0;
    protected final static int yIndex = 1;
    protected String color;
    protected int xCor;
    protected int yCor;
    protected String representation;

    public Piece() {
        this.xCor = -1;
        this.yCor = -1;
    }

    public abstract ArrayList<int[]> getMovesPossible(ChessData pBoard);

    public String getRepresentation() {
        return this.representation;
    }

    public int getXCor() {
        return this.xCor;
    }

    public int getYCor() {
        return this.yCor;
    }

    public String getColor() {
        return this.color;
    }

    public void setXCor(int xCor) {
        this.xCor = xCor;
    }

    public void setYCor(int yCor) {
        this.yCor = yCor;
    }

    public void setNewCoordinates(int[] pCoordinates) {
        setYCor(pCoordinates[0]);
        setXCor(pCoordinates[1]);
    }
}