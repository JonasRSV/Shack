package com.jonval.chess;
import java.util.ArrayList;
/**
 * Created by jonval on 21/09/16.
 */
public class Passant {
    PieceFactory factory = new PieceFactory();
    private ArrayList<Integer> possiblePassants = new ArrayList<Integer>();


    public void addPassant(int[] coordinates, Team color, Piece[][] board) {
        switch (color) {
            case WHITE:
                possiblePassants.add(coordinates[0]);
                possiblePassants.add(coordinates[1] - 1);
                board[possiblePassants.get(0)][possiblePassants.get(1)] = factory.newPiece(Type.NULL, color);
                break;
            case BLACK:
                possiblePassants.add(coordinates[0]);
                possiblePassants.add(coordinates[1] + 1);
                board[possiblePassants.get(0)][possiblePassants.get(1)] = factory.newPiece(Type.NULL, color);
                break;
        }
    }

    public void removePassant(Piece[][] board) {
        if (board[possiblePassants.get(0)][possiblePassants.get(1)].type() == Type.NULL) {
            board[possiblePassants.get(0)][possiblePassants.get(1)] = factory.newPiece(Type.NULL, Team.NULL);
        } else {
            switch (board[possiblePassants.get(0)][possiblePassants.get(1)].team) {
                case WHITE:
                    board[possiblePassants.get(0)][possiblePassants.get(1) - 1] = factory.newPiece(Type.NULL, Team.NULL);
                    break;
                case BLACK:
                    board[possiblePassants.get(0)][possiblePassants.get(1) + 1] = factory.newPiece(Type.NULL, Team.NULL);
                    break;
            }
        }
        possiblePassants.clear();
    }

    public boolean isPassant() {
        return !possiblePassants.isEmpty();
    }
}
