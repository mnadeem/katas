package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.Color;
import com.nadeem.app.kata.Position;

public class Bishop extends Piece {

	public Bishop(String id, Color color) {
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
