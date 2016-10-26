package com.nadeem.app.kata;

public class Command {

	private Piece piece;
	private Move move;

	public Command(Piece piece, Move move) {
		this.piece = piece;
		this.move = move;
	}

	public Piece getPiece() {
		return piece;
	}
	public Move getMove() {
		return move;
	}
}
