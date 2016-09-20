package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Queen extends Piece {


    private Runner diagonals = new Runner(this.team);
    private Tower straightlines = new Tower(this.team);

    public Queen(Team color) {
        super(color);
    }

    @Override
    public Type type() {
        return Type.QUEEN;
    }

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team team) {
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);
        return !friendlyFire && diagonals.move(positionCURRENT, positionGO, board, team) && straightlines.move(positionCURRENT, positionGO, board, team);
    }
}
