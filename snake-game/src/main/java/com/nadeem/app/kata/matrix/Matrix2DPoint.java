package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Position;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DPoint implements Position {
	int row;
	int column;

	public Matrix2DPoint(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix2DPoint other = (Matrix2DPoint) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [row=" + row + ", column=" + column + "]";
	}		
}