package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Board;

/**
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DBoard extends Board {

	public Matrix2DBoard() {
		super(new Matrix2DPositionProvider(), new Matrix2DBoardRenderer());
	}
}
