package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Tower {

    private PieceSlide slide = new PieceSlide();
    public String type = "TOWER";

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        int dX = positionGO[0] - positionCURRENT[0];
        int dY = positionGO[1] - positionCURRENT[1];
        int[] direction = new int[] {roundDirection(dX), roundDirection(dY)};
        if (Math.abs(dX) != Math.abs(dY) && (Math.abs(dX) == 0 || Math.abs(dY) == 0) && slide.checkSlide(direction, positionCURRENT, positionGO, board)) return true;
        return false;
    }

    private int roundDirection(int d) {
        if (d == 0) return 0;
        if (d > 0) return 1;
        return -1;
    }
}