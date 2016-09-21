package com.jonval.chess;

/**
 * Created by jonval on 21/09/16.
 */
public class Castling {


    private PieceSlide slide = new PieceSlide();
    private PieceFactory factory = new PieceFactory();

    private boolean leftWhite = true;
    private boolean rightWhite = true;

    private boolean leftBlack = true;
    private boolean rightBlack = true;

    private boolean white = true;
    private boolean black = true;

    public boolean castling(Team color, Piece[][] board) {

        if (GameState.inCheck != Team.NULL) return false;

        if (!leftBlack && !rightBlack) black = false;

        if (!leftWhite && !rightWhite) white = false;

        switch (color) {
            case WHITE: if (white) return whiteCastling(board);
                break;
            case BLACK: if (black) return blackCastling(board);
                break;
            default: System.err.println("Invalid team for Castling");
        }
        return false;
    }
    public boolean getLeftWhite() {
        return leftWhite;
    }

    public boolean getLeftBlack() {
        return leftBlack;
    }

    public boolean getRightWhite() {
        return rightWhite;
    }

    public boolean getRightBlack() {
        return rightBlack;
    }

    public void falseLeftWhite() {
        leftWhite = false;
    }

    public  void falseRightWhite() {
        rightWhite = false;
    }

    public void falseLeftBlack() {
        leftBlack = false;
    }

    public void falseRightBlack() {
        rightBlack = false;
    }

    public void falseWhiteCastling() {
        white = false;
    }

    public void falseBlackCastling() {
        black = false;
    }

    private boolean whiteCastling(Piece[][] board) {
        if (slide.checkSlide(new int[] {1, 0}, new int[] {0, 0}, new int[] {4, 0}, board)) return true;

        if (slide.checkSlide(new int[] {-1, 0}, new int[] {7, 0}, new int[] {4, 0}, board)) return true;

        return false;
    }

    private boolean blackCastling(Piece[][] board) {
        if (slide.checkSlide(new int[] {1, 0}, new int[] {0, 7}, new int[] {4, 7}, board)) return true;

        if (slide.checkSlide(new int[] {-1, 0}, new int[] {7, 7}, new int[] {4, 7}, board)) return true;

        return false;
    }
}
