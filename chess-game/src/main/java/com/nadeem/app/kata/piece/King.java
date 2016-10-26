package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.PieceColor;
import com.nadeem.app.kata.Position;

public class King extends Piece {

	public King(String id, PieceColor color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "King";
	}

	@Override
	public boolean validate(Position destination) {
		return true;
	}

}
