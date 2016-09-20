package com.jonval.chess;


public class PieceFactory {
    public static Piece newPiece(Type type, Team color) {
        switch (type) {
            case PAWN: return new Pawn(color);
            case KING: return new King(color);
            case RUNNER: return new Runner(color);
            case QUEEN: return new Queen(color);
            case TOWER: return new Tower(color);
            case KNIGHT: return new Knight(color);
            default: throw new IllegalArgumentException("Unknown Type");
        }
    }
}
