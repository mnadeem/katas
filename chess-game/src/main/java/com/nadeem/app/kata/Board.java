package com.nadeem.app.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nadeem.app.kata.piece.King;

/**
 * @author Nadeem Mohammad
 *
 */
public class Board {

	private boolean gameOver = false;
	private Map<Position, Square> spots;
	private PositionProvider positionProvider;
	private BoardRenderer renderer;

	public Board(final PositionProvider positionProvider, final BoardRenderer renderer) {
		this.positionProvider = positionProvider;
		this.renderer = renderer;
		this.spots = new HashMap<Position, Square>();
	}

	public void initialize(final List<Piece> pieces) {
		for (Piece piece : pieces) {
			Position position = this.positionProvider.initialPosition(piece);
			this.spots.put(position, new Square(position, piece));
		}
	}

	public boolean execute(final Command command) {
		Piece piece = command.getPiece();
		Position destination = command.getDestination();
		if (!piece.validate(destination)) {
			return false;
		}
		Square spot = getSpot(command.getDestination());
		Piece killed = spot.release();
		spot.occupy(piece);
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

	public void display() {
		this.renderer.render(spots.values());
	}

	public void displayMessage(String message) {
		this.renderer.render(message);
	}
}
