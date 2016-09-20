package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class King {
    public String type = "KING";

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int deltaX = positionGO[0] - positionCURRENT[0];
        int deltaY = positionGO[1] - positionCURRENT[1];
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        if (!friendlyFire && Math.abs(deltaX) < 2 && Math.abs(deltaY) < 2) return true;
        return false;
    }
}
