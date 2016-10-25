package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Game;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DGame extends Game {
	
	private static final int rows = 10;
	private static final int cols = 10;

	public Matrix2DGame() {
		super(new Matrix2DBoard(rows, cols), new Matrix2DConsoleRenderer(rows, cols));
	}
}
