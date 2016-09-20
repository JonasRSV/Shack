package com.jonval.chess;

/**
 * Created by jonval on 20/09/16.
 */
public class Piece extends Board{

    public String team;

    public Piece() {
        team = null;
    }

    public Piece(String piece, String color) {
        team = color;

        switch(piece) {
            case "PAWN": makePawn();
                break;
            case "KNIGHT": makeKnight();
                break;
            case "TOWER": makeTower();
                break;
            case "QUEEN": makeQueen();
                break;
            case "KING": makeKing();
                break;
            case "RUNNER": makeRunner();
                break;
            default: System.err.println("Error, No Sutch Piece");
                break;
        }

    }

    private void makePawn() {

    }

    private void makeKnight() {

    }

    private void makeTower() {

    }

    private void makeQueen() {

    }

    private void makeKing() {

    }

    private void makeRunner() {

    }
}
