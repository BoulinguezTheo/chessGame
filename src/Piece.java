public abstract class Piece {
    protected String color;
    protected int xCor;
    protected int yCor;
    protected String representation = "p";

    public Piece(){
        
    }

    protected String getRepresentation(){
        return this.representation;
    }
}
