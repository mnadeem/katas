package com.nadeem.app.kata;

public class Rook extends Piece {

	public Rook(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Rook";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
