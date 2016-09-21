package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Null extends Piece {

    public Null(Team color) {
        super(color);
    }

    public Type type() {
        return Type.NULL;
    }

    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        return ReturnState.FALSE;
    }
}
