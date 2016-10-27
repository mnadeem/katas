package com.nadeem.app.kata.matrix;

import java.util.HashMap;
import java.util.Map;

import com.nadeem.app.kata.Piece;
import com.nadeem.app.kata.Position;
import com.nadeem.app.kata.PositionProvider;

/**
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DPositionProvider implements PositionProvider {
	
	private static final Point BLACK_ROOK_ONE = new Point(0, 0);
	private static final Point BLACK_ROOK_TWO = new Point(0, 7);
	private static final Point BLACK_KNIGHT_ONE = new Point(0, 1);
	private static final Point BLACK_KNIGHT_TWO = new Point(0, 6);
	private static final Point BLACK_BISHOP_ONE = new Point(0, 2);
	private static final Point BLACK_BISHOP_TWO = new Point(0, 5);
	private static final Point BLACK_KING = new Point(0, 4);
	private static final Point BLACK_QUEEN = new Point(0, 3);
	
	private static final Point WHITE_ROOK_ONE = new Point(7, 0);
	private static final Point WHITE_ROOK_TWO = new Point(7, 7);
	private static final Point WHITE_KNIGHT_ONE = new Point(7, 1);
	private static final Point WHITE_KNIGHT_TWO = new Point(7, 6);
	private static final Point WHITE_BISHOP_ONE = new Point(7, 2);
	private static final Point WHITE_BISHOP_TWO = new Point(7, 5);
	private static final Point WHITE_KING = new Point(7, 4);
	private static final Point WHITE_QUEEN = new Point(7, 3);
	
	private Map<String, Point> black = new HashMap<>();
	private Map<String, Point> white = new HashMap<>();
	
	public Matrix2DPositionProvider() {

		initBlackPositions();		
		initWhitePositionis();
	}

	private void initWhitePositionis() {
		white.put("Rook1", WHITE_ROOK_ONE);
		white.put("Rook2", WHITE_ROOK_TWO);
		white.put("Bishop1", WHITE_BISHOP_ONE);
		white.put("Bishop2", WHITE_BISHOP_TWO);
		white.put("Knight1", WHITE_KNIGHT_ONE);
		white.put("Knight2", WHITE_KNIGHT_TWO);
		white.put("King1", WHITE_KING);
		white.put("Queen1", WHITE_QUEEN);
		
		for (int i = 0; i < 8; i++) {
			black.put("Pawn"+String.valueOf(i), new Point(7, i));
		}
	}

	private void initBlackPositions() {
		black.put("Rook1", BLACK_ROOK_ONE);
		black.put("Rook2", BLACK_ROOK_TWO);
		black.put("Bishop1", BLACK_BISHOP_ONE);
		black.put("Bishop2", BLACK_BISHOP_TWO);
		black.put("Knight1", BLACK_KNIGHT_ONE);
		black.put("Knight2", BLACK_KNIGHT_TWO);
		black.put("King1", BLACK_KING);
		black.put("Queen1", BLACK_QUEEN);
		
		for (int i = 0; i < 8; i++) {
			black.put("Pawn"+String.valueOf(i), new Point(0, i));
		}
	}

	@Override
	public Position initialPosition(final Piece piece) {
		String key = piece.getName() + piece.getId();
		if (piece.isBlack()) {
			return this.black.get(key);
		}
		return this.white.get(key);
	}
}
