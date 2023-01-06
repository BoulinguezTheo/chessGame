package view;

import model.Cell;
import model.Player;

public interface Shows {
    public void displayBoard(int boardSize, Cell[][] cells, Player player1, Player player2);
    public void displayAskPlayerName(String number);
    public void displayAskPieceToMove(String name);
}
