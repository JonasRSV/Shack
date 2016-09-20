package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class PieceSlide {

    public boolean checkSlide(int[] directions, int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        switch (directions[0]) {
            case 0:
                    switch (directions[1]) {
                        case 0: System.err.println("Can't slide null distance");
                        case 1: return obstaclesY(positionCURRENT, positionGO, board);
                        case -1: return obstaclesYN(positionCURRENT, positionGO, board);
                        default: System.err.println("Invalid Direction");
                            break;
                    }
                break;
            case 1:
                    switch (directions[1]) {
                        case 0: return obstaclesX(positionCURRENT, positionGO, board);
                        case 1: return obstaclesXY(positionCURRENT, positionGO, board);
                        case -1: return obstaclesXYN(positionCURRENT, positionGO, board);
                        default: System.err.println("Invalid Direction");
                            break;
                    }
                break;
            case -1:
                    switch (directions[1]) {
                        case 0: return obstaclesXN(positionCURRENT, positionGO, board);
                        case 1: return obstaclesXNY(positionCURRENT, positionGO, board);
                        case -1: return obstaclesNXY(positionCURRENT, positionGO, board);
                        default: System.err.println("Invalid Direction");
                            break;
                    }
                break;
            default: System.err.println("Invalid Direction");
                return false;

        }
        return false;

    }

    private boolean obstaclesX(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] + index <= positionGO[0] - 1) {
            if (board[positionCURRENT[0]+index][positionCURRENT[1]].team != null) return false;
            index ++;
        }
        return true;
    }

    private  boolean obstaclesXN(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] - index >= positionGO[0] + 1) {
            if (board[positionCURRENT[0] - index][positionCURRENT[1]].team != null) return false;
            index ++;
        }
        return true;

    }

    private boolean obstaclesY(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[1] + index <= positionGO[1] - 1) {
            if (board[positionCURRENT[0]][positionCURRENT[1] + index].team != null) return false;
            index ++;
        }
        return true;
    }

    private boolean obstaclesYN(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[1] - index >= positionGO[1] + 1) {
            if (board[positionCURRENT[0]][positionCURRENT[1] - index].team != null) return false;
            index ++;
        }
        return true;
    }

    private  boolean obstaclesXY(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] + index <= positionGO[0] - 1 && positionCURRENT[1] + index <= positionGO[1] - 1) {
            if (board[positionCURRENT[0] + index][positionCURRENT[1] + index].team != null) return false;
            index ++;
        }
        return true;
    }

    private boolean obstaclesNXY(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] - index >= positionGO[0] + 1 && positionCURRENT[1] - index >= positionGO[1] + 1) {
            if (board[positionCURRENT[0] - index][positionCURRENT[1] - index].team != null) return false;
            index ++;
        }
        return true;

    }

    private boolean obstaclesXNY(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] - index >= positionGO[0] + 1 && positionCURRENT[1] + index <= positionGO[1] - 1) {
            if (board[positionCURRENT[0] - index][positionCURRENT[1] + index].team != null) return false;
            index ++;
        }
        return true;
    }

    private boolean obstaclesXYN(int[] positionCURRENT, int[] positionGO, Piece[][] board) {
        int index = 1;
        while(positionCURRENT[0] + index <= positionGO[0] - 1 && positionCURRENT[1] - index >= positionGO[1] + 1) {
            if (board[positionCURRENT[0] + index][positionCURRENT[1] - index].team != null) return false;
            index ++;
        }
        return true;
    }
}
