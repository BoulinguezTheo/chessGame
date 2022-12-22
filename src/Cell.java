public class Cell {
    String cell;
    String cellContent;
    String cellLeftPart;
    String cellRightPart;

    public Cell(){
        cellLeftPart = "|  ";
        cellContent = " ";
        cellRightPart = " ";
        cell = cellLeftPart + cellContent + cellRightPart;
    }

    private String setCellContent(String pieceRepresentation){
        cellContent = pieceRepresentation;
        return cell;
    }
    protected String getCell(){
        return this.cell;
    }

}
