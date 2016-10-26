package com.nadeem.app.kata;

public class Queen extends Piece {

	public Queen(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Queen";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
