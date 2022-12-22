import java.util.Scanner;

public class Interaction {
    Scanner inputUser;

    public Interaction(){
        inputUser = new Scanner(System.in);
    }

    protected String enterPlayerName(){
        return inputUser.nextLine();
    }
}
