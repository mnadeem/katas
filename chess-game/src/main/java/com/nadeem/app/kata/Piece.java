package com.nadeem.app.kata;

/**
 * @author Nadeem Mohammad
 *
 */
public abstract class Piece {

	public abstract String getName();
	public abstract boolean validate(Position destination);

	public boolean available = true;
	private int id;

	private Color pieceColor;
	private Square spot;

	public Piece(final int id, Color color) {
		this.id = id;
		this.pieceColor = color;		
	}

	public String getSymbol() {
		return this.pieceColor.getCode() + getName().substring(0, 1);
	}

	public boolean isBlack() {
		return Color.BLACK.equals(pieceColor);
	}
	
	public boolean isWhite() {
		return Color.WHITE.equals(pieceColor);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId() {
		return id;
	}
	public Square getSpot() {
		return spot;
	}
	public void setSpot(Square spot) {
		this.spot = spot;
	}
}
