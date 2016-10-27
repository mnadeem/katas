package com.nadeem.app.kata.piece;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.Color;
import com.nadeem.app.kata.Position;
/**
 * @author Nadeem Mohammad
 *
 */
public class Pawn extends Piece {

	public Pawn(String id, Color color) {
		super(id, color);
	}

	@Override
	public String getName() {
		return "Pawn";
	}

	@Override
	public boolean validate(Position destination) {
		return true;
	}
}
