package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.Color;
import com.nadeem.app.kata.Position;

public class Rook extends Piece {

	public Rook(String id, Color color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Rook";
	}

	@Override
	public boolean validate(Position destination) {
		return true;
	}

}
