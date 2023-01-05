public class Cell {
    String cell;
    String cellContent;
    String cellLeftPart;
    String cellRightPart;
    String color;

    public Cell(){
        color = "\u001B[37m";
        cellLeftPart = "|  ";
        cellContent = " ";
        cellRightPart = " ";
        cell = cellLeftPart + cellContent + cellRightPart;
    }

    protected String setCellContent(String pieceRepresentation, String pColor){
        this.color = pColor;
        this.cellContent = pieceRepresentation;
        cell = cellLeftPart + cellContent + cellRightPart;
        return cell;
    }
    protected String getCell(){
        return this.cell;
    }
    protected String getCellLeft(){
        return this.cellLeftPart;
    }
    protected String getCellContent(){
        return this.cellContent;
    }
    protected String getCellRight(){
        return this.cellRightPart;
    }
    protected String getCellColor(){
        return this.color;
    }

}
