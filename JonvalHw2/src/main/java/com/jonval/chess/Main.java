package com.jonval.chess;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by jonval on 20/09/16.
 */

public class Main {
    private static GameState state  = new GameState();

    public static void main(String... args) {
        Board chessBoard = new Board();
        Scanner in = new Scanner(System.in);
        printall(chessBoard);
        int[] positionCURRENT = new int[2];
        int[] positionGO = new int[2];
        int turn = 0;
        Team color;
        boolean success = false;

        do {

            switch (turn % 2) {
                case 0:
                    System.out.print("\nWhite: ");
                    positionCURRENT[0] = in.nextInt();
                    positionCURRENT[1] = in.nextInt();
                    positionGO[0] = in.nextInt();
                    positionGO[1] = in.nextInt();
                    success = runTurn(Team.WHITE, positionCURRENT, positionGO, chessBoard);
                    break;
                case 1:
                    System.out.print("\nBlack");
                    positionCURRENT[0] = in.nextInt();
                    positionCURRENT[1] = in.nextInt();
                    positionGO[0] = in.nextInt();
                    positionGO[1] = in.nextInt();
                    success = runTurn(Team.BLACK, positionCURRENT, positionGO, chessBoard);
            }


            if (success) turn++;


            printall(chessBoard);
            System.out.println(state.shack(0, chessBoard.board, Team.NULL) + " is Checked");

        } while (state.mate(chessBoard.board) == Team.NULL);

    }
    private static boolean runTurn(Team color, int[] positionCURRENT, int[] positionGO, Board chessBoard) {


        switch (move(positionCURRENT, positionGO, chessBoard, color)) {
            case TRUE:
                System.out.println("Succesful Move\n");
                return true;
            case SPECIAL:
                System.out.println("Special Move\n");
                return true;
            case CASTLING:
                System.out.println("Castling\n");
                return true;
            case FALSE:
                System.out.println("Can't do that\n");
                return false;
        }


        return false;
    }


    private static ReturnState move(int[] positionCURRENT, int[] positionGO, Board chessBoard, Team color) {

        Piece piece = chessBoard.board[positionCURRENT[0]][positionCURRENT[1]];

        if (piece.team != color) return ReturnState.FALSE;

        switch (piece.move(positionCURRENT, positionGO, chessBoard.board, piece.team)) {
            case TRUE:
                chessBoard.board[positionGO[0]][positionGO[1]] = chessBoard.board[positionCURRENT[0]][positionCURRENT[1]];
                chessBoard.board[positionCURRENT[0]][positionCURRENT[1]] = PieceFactory.newPiece(Type.NULL, Team.NULL);
                if (state.passant.isPassant()) state.passant.removePassant(chessBoard.board);
                return ReturnState.TRUE;
            case SPECIAL:
                if (state.passant.isPassant()) state.passant.removePassant(chessBoard.board);
                chessBoard.board[positionGO[0]][positionGO[1]] = chessBoard.board[positionCURRENT[0]][positionCURRENT[1]];
                state.passant.addPassant(positionGO, piece.team, chessBoard.board);
                chessBoard.board[positionCURRENT[0]][positionCURRENT[1]] = PieceFactory.newPiece(Type.NULL, Team.NULL);
                return ReturnState.SPECIAL;
            case CASTLING:
                return ReturnState.CASTLING;
            case FALSE:
                return ReturnState.FALSE;
        }
        return ReturnState.FALSE;

    }


    private static void printall(Board chessBoard) {
        for (int ii = 0; ii < 8; ii ++) {
            for (int jj = 0; jj < 8; jj ++) {
                System.out.print("  " + chessBoard.board[jj][ii].type() + " " + jj + " " + ii + "  ");
                if (jj == 7) System.out.println();
            }
        }
    }
}