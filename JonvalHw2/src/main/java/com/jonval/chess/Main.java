package com.jonval.chess;

import java.util.Scanner;
/**
 * Created by jonval on 20/09/16.
 */
public class Main {

    public static void main(String... args) {
        Board chessBoard = new Board();
        Scanner in = new Scanner(System.in);
        printall(chessBoard);
        while(true) {
            int[] positionCurrent = new int[] {in.nextInt(), in.nextInt()};
            int[] positionGO = new int[] {in.nextInt(), in.nextInt()};
            if (move(positionCurrent, positionGO, chessBoard)) System.out.println("Sucessful Move");
            printall(chessBoard);



        }

    }

    private static boolean move(int[] positionCURRENT, int[] positionGO, Board chessBoard) {
        Piece piece = chessBoard.board[positionCURRENT[0]][positionCURRENT[1]];
        if (piece.move(positionCURRENT, positionGO, chessBoard.board, piece.team)) {
            chessBoard.board[positionGO[0]][positionGO[1]] = chessBoard.board[positionCURRENT[0]][positionCURRENT[1]];
            chessBoard.board[positionCURRENT[0]][positionCURRENT[1]] = PieceFactory.newPiece(Type.NULL, Team.NULL);
            return true;
        }   else return false;

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
