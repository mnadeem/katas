package com.nadeem.app.kata;

public class Square {

	private final Position position;
	private Piece piece;

	public Square(final Position position, final Piece piece) {
		this.position = position;
		this.piece.setSpot(this);
		occupy(piece);
	}

	public void occupy(Piece piece) {
		this.piece = piece;
		piece.setSpot(this);
	}

	public Piece release() {
		Piece piece = this.piece;
		if (piece != null) {
			piece.setSpot(null);
			piece.setAvailable(false);
		}
		this.piece = null;
		return piece;
	}

	public Position getPosition() {
		return this.position;
	}
}
