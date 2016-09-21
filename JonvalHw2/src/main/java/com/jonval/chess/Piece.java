package com.jonval.chess;

public abstract class Piece {

    final Team team;

    Piece(Team color) {
        team = color;
    }

    public abstract Type type();

    public abstract ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color);

}
