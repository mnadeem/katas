package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Move;

public class Bishop extends Piece {

	public Bishop(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Bishop";
	}

	@Override
	public boolean validate(Move move) {
		// TODO Auto-generated method stub
		return false;
	}

}
