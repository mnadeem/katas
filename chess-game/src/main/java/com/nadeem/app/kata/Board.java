package com.nadeem.app.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nadeem.app.kata.piece.King;
import com.nadeem.app.kata.piece.Piece;

public class Board {

	private boolean gameOver;
	private Map<Position, Square> spots;
	private PositionProvider positionProvider;

	public Board() {
		this.spots = new HashMap<Position, Square>();
	}

	public void initialize(final List<Piece> pieces) {
		for (Piece piece : pieces) {
			Position position = this.positionProvider.provide(piece);
			this.spots.put(position, new Square(position, piece));
		}
	}

	public boolean execute(final Command command) {
		Piece piece = command.getPiece();
		Move move = command.getMove();
		if (!piece.validate(move)) {
			return false;
		}
		Square spot = getSpot(move.getSource());
		Piece killed = spot.release();
		if (killed instanceof King) {
			this.gameOver = true;
		}
		return true;
	}

	private Square getSpot(final Position source) {
		return this.spots.get(source);
	}

	public boolean gameOver() {
		return this.gameOver;
	}
}
