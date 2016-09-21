package com.jonval.chess;

class GameState {

    Passant passant = new Passant();
    static Team inCheck = Team.NULL;

    Team shack(int kingPosition, Piece[][] board, Team color) {
        int i;
        for (i = kingPosition; i < 64; i++) {
            if (board[i % 8][i / 8].type() == Type.KING && kingPosition != i) {
                kingPosition = i;
                break;
            }
        }

        if (i == 64) {
            inCheck = color;
            return color;
        }

        int positionOfChecker;
        for (positionOfChecker = 0; positionOfChecker < 64; positionOfChecker++) {
            Piece checker = board[positionOfChecker % 8][positionOfChecker / 8];
            if (checker.move(new int[]{positionOfChecker % 8, positionOfChecker / 8}, new int[]{kingPosition % 8, kingPosition / 8}, board, checker.team).equals(ReturnState.TRUE)
                    && color == Team.NULL) {
                return shack(kingPosition, board, board[kingPosition % 8][kingPosition / 8].team);
            } else if (checker.move(new int[]{positionOfChecker % 8, positionOfChecker / 8}, new int[]{kingPosition % 8, kingPosition / 8}, board, checker.team).equals(ReturnState.TRUE)
                    && color != Team.NULL) return Team.BOTH;
        }
        return shack(kingPosition, board, color);
    }

}
