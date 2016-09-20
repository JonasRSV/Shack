package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class King extends Piece {

    public King(Team team) {
        super(team);
    }

    @Override
    public Type type() {
        return Type.KING;
    }

    @Override
    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        int deltaX = positionGO[0] - positionCURRENT[0];
        int deltaY = positionGO[1] - positionCURRENT[1];
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        return !friendlyFire && Math.abs(deltaX) < 2 && Math.abs(deltaY) < 2;
    }
}
