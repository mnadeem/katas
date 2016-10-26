package com.nadeem.app.kata;

public class Command {

	private Piece piece;
	private Position destination;

	public Command(final Piece piece, final Position destination) {
		this.piece = piece;
		this.destination = destination;
	}

	public Piece getPiece() {
		return piece;
	}

	public Position getDestination() {
		return destination;
	}
}
