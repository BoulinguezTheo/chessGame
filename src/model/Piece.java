package model;

public abstract class Piece {
    protected String color;
    protected int xCor;
    protected int yCor;
    protected String representation;

    public Piece(){
        
    }

    public String getRepresentation(){
        return this.representation;
    }
    public int getXCor(){
        return this.xCor;
    }
    public int getYCor(){
        return this.yCor;
    }
    public String getColor(){
        return this.color;
    }
}
