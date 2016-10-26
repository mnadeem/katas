package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Move;

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
