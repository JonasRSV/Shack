package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Null extends Piece {

    public Null(Team color) {
        super(color);
    }

    public Type type() {
        return null;
    }

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        return false;
    }
}
