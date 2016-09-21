package com.jonval.chess;

class Runner extends Piece {

    private PieceSlide slide = new PieceSlide();

    Runner(Team color) {
        super(color);
    }

    public Type type() {
        return Type.RUNNER;
    }


    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        boolean dxEdy = Math.abs(positionGO[0] - positionCURRENT[0]) == Math.abs(positionGO[1] - positionCURRENT[1]);
        int dX = positionGO[0] - positionCURRENT[0];
        int dY = positionGO[1] - positionCURRENT[1];
        int[] direction = new int[]{roundDirection(dX), roundDirection(dY)};
        if (!friendlyFire && dxEdy && slide.checkSlide(direction, positionCURRENT, positionGO, board))
            return ReturnState.TRUE;
        return ReturnState.FALSE;
    }

    private int roundDirection(int d) {
        if (d == 0) return 0;
        if (d > 0) return 1;
        return -1;
    }

}
