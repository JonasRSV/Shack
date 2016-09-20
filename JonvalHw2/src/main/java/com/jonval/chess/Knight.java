package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Knight extends Piece {

    public Knight(Team color) {
        super(color);
    }

    @Override
    public Type type() {
        return Type.KNIGHT;
    }

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        boolean move1 = Math.abs(positionGO[0] - positionCURRENT[0]) == 2 && Math.abs(positionGO[1] - positionCURRENT[1]) == 1;
        boolean move2 = Math.abs(positionGO[0] - positionCURRENT[0]) == 1 && Math.abs(positionGO[1] - positionCURRENT[1]) == 2;
        return (move1 || move2) && !friendlyFire;
    }
}