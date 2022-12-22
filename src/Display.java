public class Display {

    public Display(){
        

    }

    protected void displayBoard(int boardSize, Cell[][] cells, Player player1, Player player2){
        System.out.println();
        System.out.println("                  " + player1.getName());
        System.out.println("-----------------------------------------");
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                System.out.print(cells[i][j].getCell());
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
