package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
import java.util.Arrays;
public class Tower extends Piece {

    private PieceSlide slide = new PieceSlide();
    private Castling castling = new Castling();

    public Tower(Team color) {
        super(color);
    }

    public Type type() {
        return Type.TOWER;
    }

    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {

        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        int dX = positionGO[0] - positionCURRENT[0];
        int dY = positionGO[1] - positionCURRENT[1];
        int[] direction = new int[] {roundDirection(dX), roundDirection(dY)};

        if (!friendlyFire  && Math.abs(dX) != Math.abs(dY)
                && (Math.abs(dX) == 0 || Math.abs(dY) == 0)
                && slide.checkSlide(direction, positionCURRENT, positionGO, board)) {

            updateCastlingState(positionCURRENT, color);
            return ReturnState.TRUE;
        }

        return ReturnState.FALSE;
    }

    private int roundDirection(int d) {
        if (d == 0) return 0;
        if (d > 0) return 1;
        return -1;
    }

    private void updateCastlingState(int[] positionCURRENT, Team color) {

        switch (color) {
            case WHITE: if (Arrays.equals(positionCURRENT, new int[] {0, 0})) castling.falseLeftWhite();
                        if (Arrays.equals(positionCURRENT, new int[] {7, 0})) castling.falseRightWhite();
                break;
            case BLACK: if (Arrays.equals(positionCURRENT, new int[] {0, 7})) castling.falseLeftBlack();
                        if (Arrays.equals(positionCURRENT, new int[] {7, 7})) castling.falseRightBlack();
                break;
        }

    }
}