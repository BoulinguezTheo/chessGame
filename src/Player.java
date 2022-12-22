public class Player {
    protected String name;

    public Player(Display display, Interaction enterName, String pNumber){
        display.askPlayerName(pNumber);
        this.name = enterName.enterPlayerName();
    }

    protected String getName(){
        return this.name;
    }

    
    
}
