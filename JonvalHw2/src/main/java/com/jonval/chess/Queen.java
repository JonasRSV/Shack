package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Queen {
    public String type = "QUEEN";
    private Runner diagonals = new Runner();
    private Tower straightlines = new Tower();

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        if (!friendlyFire && diagonals.move(positionCURRENT, positionGO, board) && straightlines.move(positionCURRENT, positionGO, board)) return true;
        return false;
    }
}
