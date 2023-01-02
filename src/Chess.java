import java.util.ArrayList;

public class Chess {
    final int boardSize = 8;
    Player player1;
    Player player2;
    Cell cells[][];
    ArrayList<Piece> pieceList;
    Display printer;
    Interaction userInteractions;

    public Chess(){
        // Setup Objects needed
        this.printer = new Display();
        this.cells = initCells();
        userInteractions = new Interaction();
        player1 = new Player(printer, userInteractions, "1");
        player2 = new Player(printer, userInteractions, "2");

        //Setup Board
        this.pieceList = setupBoard();
        this.printer.displayBoard(boardSize, cells, player1, player2);
    }
    
    // Initialize board method
    private Cell[][] initCells(){
        this.cells = new Cell[this.boardSize][this.boardSize];
        for(int i = 0; i < this.boardSize; i++){
            for (int j = 0; j < this.boardSize; j++){
                cells[i][j] = new Cell();
            }
        }
        return this.cells;
    }

    private ArrayList<Piece> setupBoard(){
        ArrayList<Piece> completeStart = new ArrayList<>();
        initBlackPawn(completeStart);
        initWhitePawn(completeStart);
        return  completeStart;
    }

    private void initBlackPawn(ArrayList<Piece> pCompleteList){
        for (int i = 0; i < this.boardSize; i++){
                Piece pawn = new Pawn(i, 2, "b");
                pCompleteList.add(pawn);
                this.cells[1][i].setCellContent(pawn.getRepresentation());
        }
    }
    
    private void initWhitePawn(ArrayList<Piece> pCompleteList){
        for (int i = 0; i < this.boardSize; i++){
                Piece pawn = new Pawn(i, 2, "b");
                pCompleteList.add(pawn);
                this.cells[6][i].setCellContent(pawn.getRepresentation());
        }
    }

    


}
