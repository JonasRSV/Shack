package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class GameState {

    public Team shack(int kingPosition, Piece[][] board) {
        int i;
        for (i = kingPosition; i < 64; i ++) {
            if(board[i%8][i/8].type() == Type.KING && kingPosition != i) {
                kingPosition = i;
                break;
            }
        }

        if (i == 64) {
            return Team.NULL;
        }

        int positionOfChecker;
        for (positionOfChecker = 0; positionOfChecker < 64; positionOfChecker++) {
            Piece checker = board[positionOfChecker%8][positionOfChecker/8];
            if (checker.move(new int[] {positionOfChecker%8, positionOfChecker/8}, new int[] {kingPosition%8, kingPosition/8}, board, checker.team)) {
                return board[kingPosition%8][kingPosition/8].team;
            }

        }
        return shack(kingPosition, board);
    }
}
