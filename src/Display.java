public class Display {
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_WHITE = "\u001B[37m";
    protected static final String ANSI_BLACK = "\u001B[31m";
    
    public Display(){
        

    }

    protected void displayBoard(int boardSize, Cell[][] cells, Player player1, Player player2){
        System.out.println();
        System.out.println("                  " + player1.getName());
        System.out.println("-----------------------------------------");
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){

                System.out.print(cells[i][j].getCellLeft());
                System.out.print((cells[i][j].getCellColor().equals("n") ? ANSI_BLACK : ANSI_WHITE) + cells[i][j].getCellContent() + ANSI_RESET);
                System.out.print(cells[i][j].getCellRight());
            }
            System.out.println("|");
            System.out.println("-----------------------------------------");
        }
        System.out.println("                  " + player2.getName());
        System.out.println();
    }

    protected void askPlayerName(String number){
        System.out.print("Enter player " + number +"'s name: ");
    }
    
}
