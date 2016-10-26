package com.nadeem.app.kata;

public class Knight extends Piece {

	public Knight(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Knight";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
