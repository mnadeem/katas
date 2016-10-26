package com.nadeem.app.kata;

public class Move {
	private Position source;
	private Position destination;
	
	public Move(final Position source, final Position destination) {
		this.source = source;
		this.destination = destination;
	}

	public Position getSource() {
		return source;
	}

	public Position getDestination() {
		return destination;
	}
	
}
