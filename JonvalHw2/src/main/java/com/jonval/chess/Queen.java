package com.jonval.chess;

class Queen extends Piece {
    private Runner diagonals = new Runner(this.team);
    private Tower straightlines = new Tower(this.team);

    Queen(Team color) {
        super(color);
    }

    @Override
    public Type type() {
        return Type.QUEEN;
    }

    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team team) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);

        if (!friendlyFire &&
                diagonals.move(positionCURRENT, positionGO, board, team).equals(ReturnState.TRUE) ||
                straightlines.move(positionCURRENT, positionGO, board, team).equals(ReturnState.TRUE))
            return ReturnState.TRUE;
        return ReturnState.FALSE;
    }

}
