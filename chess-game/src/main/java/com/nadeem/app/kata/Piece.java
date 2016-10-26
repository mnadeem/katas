package com.nadeem.app.kata;

public abstract class Piece {

	public abstract String getName();
	public abstract boolean validate(Move move);
	public boolean available = true;
	private String id;

	private PieceColor pieceColor;

	public Piece(final String id, PieceColor color) {
		this.id = id;
		this.pieceColor = color;
	}
	
	public boolean isBlack() {
		return PieceColor.BLACK.equals(pieceColor);
	}
	
	public boolean isWhite() {
		return PieceColor.WHITE.equals(pieceColor);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getId() {
		return id;
	}
}
