package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Pawn extends Piece {

    public Pawn(Team color) {
        super(color);
    }

    @Override
    public Type type() {
        return Type.PAWN;
    }

    @Override
    public ReturnState move(int[] positionCURRENT, int[] positionGO, Piece[][] board, Team color) {
        int deltaX = positionGO[0] - positionCURRENT[0];
        int deltaY = positionGO[1] - positionCURRENT[1];

        boolean emptyDestination = board[positionGO[0]][positionGO[1]].team == Team.NULL;
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);

        if (emptyDestination && deltaY == 2 && color.equals(Team.WHITE) && deltaX == 0) return ReturnState.SPECIAL;

        if (emptyDestination && deltaY == -2 && color.equals(Team.BLACK) && deltaX == 0) return ReturnState.SPECIAL;

        if ((deltaX == 0 && deltaY == 1) && color.equals(Team.WHITE) && emptyDestination) return ReturnState.TRUE;

        if ((deltaX == 0 && deltaY == -1) && color.equals(Team.BLACK) && emptyDestination) return ReturnState.TRUE;

        if ((deltaX == 1 || deltaX == -1) && deltaY == 1 && color.equals(Team.WHITE) && !friendlyFire && !emptyDestination) return ReturnState.TRUE;

        if ((deltaX == 1 || deltaX == -1) && deltaY == -1 && color.equals(Team.BLACK) && !friendlyFire && !emptyDestination) return ReturnState.TRUE;

        return ReturnState.FALSE;
    }
}
