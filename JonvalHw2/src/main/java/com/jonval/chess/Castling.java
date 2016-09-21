package com.jonval.chess;

class Castling {

    private PieceSlide slide = new PieceSlide();
    private PieceFactory factory = new PieceFactory();
    private boolean leftWhite = true;
    private boolean rightWhite = true;
    private boolean leftBlack = true;
    private boolean rightBlack = true;
    private boolean white = true;
    private boolean black = true;

    boolean castling(Team color, Piece[][] board) {

        if (GameState.inCheck != Team.NULL) return false;

        if (!leftBlack && !rightBlack) black = false;

        if (!leftWhite && !rightWhite) white = false;

        switch (color) {
            case WHITE:
                if (white) return whiteCastling(board);
                break;
            case BLACK:
                if (black) return blackCastling(board);
                break;
            default:
                System.err.println("Invalid team for Castling");
        }
        return false;
    }

    boolean getLeftWhite() {
        return leftWhite;
    }

    boolean getLeftBlack() {
        return leftBlack;
    }

    boolean getRightWhite() {
        return rightWhite;
    }

    boolean getRightBlack() {
        return rightBlack;
    }

    void falseLeftWhite() {
        leftWhite = false;
    }

    void falseRightWhite() {
        rightWhite = false;
    }

    void falseLeftBlack() {
        leftBlack = false;
    }

    void falseRightBlack() {
        rightBlack = false;
    }

    void falseWhiteCastling() {
        white = false;
    }

    void falseBlackCastling() {
        black = false;
    }

    private boolean whiteCastling(Piece[][] board) {
        return slide.checkSlide(new int[]{1, 0}, new int[]{0, 0}, new int[]{4, 0}, board)
                || slide.checkSlide(new int[]{-1, 0}, new int[]{7, 0}, new int[]{4, 0}, board);
    }

    private boolean blackCastling(Piece[][] board) {
        return slide.checkSlide(new int[]{1, 0}, new int[]{0, 7}, new int[]{4, 7}, board)
                || slide.checkSlide(new int[]{-1, 0}, new int[]{7, 7}, new int[]{4, 7}, board);
    }

}
