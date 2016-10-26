package com.nadeem.app.kata;

public class Spot {

	private final Position position;
	private Piece piece;

	public Spot(Position position, Piece piece) {
		this.position = position;
		occupy(piece);
	}
	
	public void occupy(Piece piece) {
		this.piece = piece;
	}

	public Piece release() {
		Piece piece = this.piece;
		if (piece != null) {
			piece.setAvailable(false);
		}
		this.piece = null;
		return piece;
	}

	public Position getPosition() {
		return this.position;
	}
}
