package model;

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

    public String setCellContent(String pieceRepresentation, String pColor){
        this.color = pColor;
        this.cellContent = pieceRepresentation;
        cell = cellLeftPart + cellContent + cellRightPart;
        return cell;
    }
    public String getCell(){
        return this.cell;
    }
    public String getCellLeft(){
        return this.cellLeftPart;
    }
    public String getCellContent(){
        return this.cellContent;
    }
    public String getCellRight(){
        return this.cellRightPart;
    }
    public String getCellColor(){
        return this.color;
    }

}
