package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Pawn {
    public String type = "PAWN";

    public boolean move(int[] positionCURRENT, int[] positionGO, Piece[][] board, String color) {
        int deltaX = positionGO[0] - positionCURRENT[0];
        int deltaY = positionGO[1] - positionCURRENT[1];

        boolean emptyDestination = board[positionGO[0]][positionGO[1]].team == null;
        boolean friendlyFire = (board[positionCURRENT[0]][positionCURRENT[1]].team).equals(board[positionGO[0]][positionGO[1]].team);

        if ((deltaX == 0 && deltaY == 1) && color.equals("WHITE") && emptyDestination ) {
            return true;
        }
        if ((deltaX == 0 && deltaY == -1) && color.equals("Black") && emptyDestination ) {
            return true;
        }

        if ((deltaX == 1 || deltaX == -1) && deltaY == 1 && color.equals("WHITE") && !friendlyFire) {
            return true;
        }

        if ((deltaX == 1 || deltaX == -1) && deltaY == -1 && color.equals("BLACK") && !friendlyFire) {
            return true;
        }

        return false;
    }

}
