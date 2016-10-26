package com.nadeem.app.kata;

import com.nadeem.app.kata.piece.Piece;

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
