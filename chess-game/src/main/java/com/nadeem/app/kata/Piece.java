package com.nadeem.app.kata;

public abstract class Piece {

	public abstract String getName();
	public abstract boolean validate(Position destination);

	public boolean available = true;
	private String id;

	private PieceColor pieceColor;
	private Square spot;

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
	public Square getSpot() {
		return spot;
	}
	public void setSpot(Square spot) {
		this.spot = spot;
	}
}
