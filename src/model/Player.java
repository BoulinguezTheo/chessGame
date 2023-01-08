package model;

public class Player {
    protected String name;
    protected String color;

    public Player(){}
    public Player(String pName, String pColor){
        this.name = pName;
        this.color = pColor;
    }

    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }

    
    
}
