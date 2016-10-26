package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.PieceColor;
import com.nadeem.app.kata.Position;

public class Bishop extends Piece {

	public Bishop(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Bishop";
	}

	@Override
	public boolean validate(Position destination) {
		return true;
	}	
}
