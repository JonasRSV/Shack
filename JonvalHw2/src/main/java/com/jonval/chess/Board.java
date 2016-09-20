package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Board {

    public final Piece[][] board;

    Board() {
        Piece[][] standardBoard = new Piece[8][8];

        for (int ii = 0; ii < 8; ii ++) {
            for (int jj = 0; jj < 8; jj ++ ) {
                standardBoard[jj][ii] = PieceFactory.newPiece(Type.NULL, Team.NULL);
            }
        }

        standardBoard[0][0] = PieceFactory.newPiece(Type.TOWER, Team.WHITE);
        standardBoard[1][0] = PieceFactory.newPiece(Type.KNIGHT, Team.WHITE);
        standardBoard[2][0] = PieceFactory.newPiece(Type.RUNNER, Team.WHITE);
        standardBoard[3][0] = PieceFactory.newPiece(Type.QUEEN, Team.WHITE);
        standardBoard[4][0] = PieceFactory.newPiece(Type.KING, Team.WHITE);
        standardBoard[5][0] = PieceFactory.newPiece(Type.RUNNER, Team.WHITE);
        standardBoard[6][0] = PieceFactory.newPiece(Type.KNIGHT, Team.WHITE);
        standardBoard[7][0] = PieceFactory.newPiece(Type.TOWER, Team.WHITE);
        for (int i = 0; i < 8; i++) {
            standardBoard[i][1] = PieceFactory.newPiece(Type.PAWN, Team.WHITE);
        }

        standardBoard[0][7] = PieceFactory.newPiece(Type.TOWER, Team.BLACK);
        standardBoard[1][7] = PieceFactory.newPiece(Type.KNIGHT, Team.BLACK);
        standardBoard[2][7] = PieceFactory.newPiece(Type.RUNNER, Team.BLACK);
        standardBoard[3][7] = PieceFactory.newPiece(Type.QUEEN, Team.BLACK);
        standardBoard[4][7] = PieceFactory.newPiece(Type.KING, Team.BLACK);
        standardBoard[5][7] = PieceFactory.newPiece(Type.RUNNER, Team.BLACK);
        standardBoard[6][7] = PieceFactory.newPiece(Type.KNIGHT, Team.BLACK);
        standardBoard[7][7] = PieceFactory.newPiece(Type.TOWER, Team.BLACK);

        for (int i = 0; i < 8; i++) {
            standardBoard[i][6] = PieceFactory.newPiece(Type.PAWN, Team.BLACK);
        }

        board = standardBoard;
    }

}