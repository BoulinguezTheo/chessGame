import java.util.ArrayList;

public class Chess {
    final int boardSize = 8;
    Player player1;
    Player player2;
    Cell cells[][];
    ArrayList<Piece> pieceList;
    Display printer;
    Interaction userInteractions;
    SetupPiece setupPiece;

    public Chess(){
        // Setup Objects needed
        setupPiece = SetupPiece.PAWN;
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
        int countSetup = 0;

        while(countSetup != 2){
            countSetup++;
            String setColor = (countSetup == 1 ? "n" : "b");
            initPawnSetInCell(completeStart, setColor, countSetup);
            initPieceSetInCell(completeStart, pieceToCreate("tower", setColor, 1));
            initPieceSetInCell(completeStart, pieceToCreate("tower", setColor, 2));
            initPieceSetInCell(completeStart, pieceToCreate("knight", setColor, 1));
            initPieceSetInCell(completeStart, pieceToCreate("knight", setColor, 2));
            initPieceSetInCell(completeStart, pieceToCreate("bishop", setColor, 1));
            initPieceSetInCell(completeStart, pieceToCreate("bishop", setColor, 2));
            initPieceSetInCell(completeStart, pieceToCreate("queen", setColor, 0));
            initPieceSetInCell(completeStart, pieceToCreate("king", setColor, 0));
        }
        return  completeStart;
    }

    private Piece pieceToCreate(String pPieceToCreate, String setColor, int pieceNum){
        return switch(pPieceToCreate){
            case "tower" -> Factory.createTower(setColor, pieceNum);
            case "knight" -> Factory.createKnight(setColor, pieceNum);
            case "bishop" -> Factory.createBishop(setColor, pieceNum);
            case "queen" -> Factory.createQueen(setColor);
            case "king" -> Factory.createKing(setColor);
            default -> new Pawn();
        };
    }
    private void initPawnSetInCell(ArrayList<Piece> pCompleteList, String pColor, int playerPiece){
        for (int i = 0; i < this.boardSize; i++){
                Piece pawn = Factory.createPawn((playerPiece == 1 ? 1 : 6) , i, pColor);
                pCompleteList.add(pawn);
                this.cells[pawn.getXCor()][pawn.getYCor()].setCellContent(pawn.getRepresentation(), pawn.getColor());
        }
    }
    private void initPieceSetInCell(ArrayList<Piece> pCompleteList, Piece pPiece){
        pCompleteList.add(pPiece);
        this.cells[pPiece.getXCor()][pPiece.getYCor()].setCellContent(pPiece.getRepresentation(), pPiece.getColor());
    }
}
