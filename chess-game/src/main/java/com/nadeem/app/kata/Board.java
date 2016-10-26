package com.nadeem.app.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	private boolean gameOver;
	private Map<Position, Spot> spots;
	private PositionProvider positionProvider;

	public Board() {
		this.spots = new HashMap<Position, Spot>();
	}

	public void initialize(List<Piece> pieces) {
		for (Piece piece : pieces) {
			Position position = this.positionProvider.provide(piece);
			this.spots.put(position, new Spot(position, piece));
		}
	}

	public boolean gameOver() {
		return this.gameOver;
	}

	public boolean execute(Command command) {
		Piece piece = command.getPiece();
		Move move = command.getMove();
		if (!piece.validate(move)) {
			return false;
		}
		Spot spot = getSpot(move.getSource());
		Piece killed = spot.release();
		if (killed instanceof King) {
			this.gameOver = true;
		}
		return true;
	}

	private Spot getSpot(Position source) {
		return this.spots.get(source);
	}
}
