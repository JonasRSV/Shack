package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */

import java.util.Arrays;

public class King extends Piece {

    PieceFactory factory = new PieceFactory();
    private Castling castling = new Castling();

    public King(Team team) {
        super(team);
    }

    @Override
    public Type type() {
        return Type.KING;
    }

    @Override
    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {

        if(castlingMove(positionCURRENT, positionGO, board, color)) return ReturnState.CASTLING;

        int deltaX = positionGO[0] - positionCURRENT[0];
        int deltaY = positionGO[1] - positionCURRENT[1];
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        if (!friendlyFire && Math.abs(deltaX) < 2 && Math.abs(deltaY) < 2) {

            switch (color) {
                case WHITE:
                    castling.falseWhiteCastling();
                    break;
                case BLACK:
                    castling.falseBlackCastling();
                    break;
            }
            return ReturnState.TRUE;
        }


        return ReturnState.FALSE;
    }

    private boolean castlingMove(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {

        switch (color) {
            case WHITE:
                if (Arrays.equals(positionGO, new int[] {6, 0})
                        && castling.castling(Team.WHITE, board)
                        && board[7][0].type() == Type.TOWER
                        && castling.getRightWhite()) {

                    board[positionGO[0]][positionGO[1]] = board[positionCURRENT[0]][positionCURRENT[1]];
                    board[positionGO[0] - 1][positionGO[1]] = board[7][0];
                    board[7][0] = factory.newPiece(Type.NULL, Team.NULL);
                    board[positionCURRENT[0]][positionCURRENT[1]] = factory.newPiece(Type.NULL, Team.NULL);
                    castling.falseWhiteCastling();
                    return true;
                }
                if (Arrays.equals(positionGO, new int[] {2, 0})
                        && castling.castling(Team.WHITE, board)
                        && board[0][0].type() == Type.TOWER
                        && castling.getLeftWhite()) {

                    board[positionGO[0]][positionGO[1]] = board[positionCURRENT[0]][positionCURRENT[1]];
                    board[positionGO[0] + 1][positionGO[1]] = board[0][0];
                    board[0][0] = factory.newPiece(Type.NULL, Team.NULL);
                    board[positionCURRENT[0]][positionCURRENT[1]] = factory.newPiece(Type.NULL, Team.NULL);
                    castling.falseWhiteCastling();
                    return true;

                }
            case BLACK:
                if (Arrays.equals(positionGO, new int[] {6, 7})
                        && castling.castling(Team.BLACK, board)
                        && board[7][7].type() == Type.TOWER
                        && castling.getRightBlack()) {

                    board[positionGO[0]][positionGO[1]] = board[positionCURRENT[0]][positionCURRENT[1]];
                    board[positionGO[0] - 1][positionGO[1]] = board[7][7];
                    board[7][7] = factory.newPiece(Type.NULL, Team.NULL);
                    board[positionCURRENT[0]][positionCURRENT[1]] = factory.newPiece(Type.NULL, Team.NULL);
                    castling.falseBlackCastling();
                    return true;
                }
                if (Arrays.equals(positionGO, new int[] {2, 7})
                        && castling.castling(Team.BLACK, board)
                        && board[0][7].type() == Type.TOWER
                        && castling.getLeftBlack()) {

                    board[positionGO[0]][positionGO[1]] = board[positionCURRENT[0]][positionCURRENT[1]];
                    board[positionGO[0] + 1][positionGO[1]] = board[0][7];
                    board[0][7] = factory.newPiece(Type.NULL, Team.NULL);
                    board[positionCURRENT[0]][positionCURRENT[1]] = factory.newPiece(Type.NULL, Team.NULL);
                    castling.falseBlackCastling();
                    return true;

                }
        }

        return false;
    }
}
