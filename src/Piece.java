public abstract class Piece {
    protected String color;
    protected int xCor;
    protected int yCor;
    protected String representation;

    public Piece(){
        
    }

    protected String getRepresentation(){
        return this.representation;
    }
    protected int getXCor(){
        return this.xCor;
    }
    protected int getYCor(){
        return this.yCor;
    }
    protected String getColor(){
        return this.color;
    }
}
