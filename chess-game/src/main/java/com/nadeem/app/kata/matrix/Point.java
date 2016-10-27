package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Position;

/**
 * @author Nadeem Mohammad
 *
 */
public class Point implements Position {
	
	private int row;
	private int column;
	
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
