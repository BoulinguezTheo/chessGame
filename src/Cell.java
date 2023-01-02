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

    protected String setCellContent(String pieceRepresentation){
        this.cellContent = pieceRepresentation;
        cell = cellLeftPart + cellContent + cellRightPart;
        return cell;
    }
    protected String getCell(){
        return this.cell;
    }

}
