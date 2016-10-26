package com.nadeem.app.kata;

import com.nadeem.app.kata.piece.Piece;

public interface PositionProvider {
	Position provide(final Piece piece);
}
