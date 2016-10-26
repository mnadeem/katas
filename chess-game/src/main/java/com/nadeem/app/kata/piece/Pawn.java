package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Move;

public class Pawn extends Piece {

	public Pawn(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Pawn";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}
}
