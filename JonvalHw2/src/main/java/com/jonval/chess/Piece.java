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

        if ("PAWN".equals(piece)) makePawn();
        else if ("KNIGHT".equals(piece)) makeKnight();
        else if ("TOWER".equals(piece)) makeTower();
        else if ("QUEEN".equals(piece)) makeQueen();
        else if ("KING".equals(piece)) makeKing();
        else if ("RUNNER".equals(piece)) makeRunner();
        else System.err.println("Error, No Sutch Piece");


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
