package com.nadeem.app.kata;

public class King extends Piece {

	public King(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "King";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
