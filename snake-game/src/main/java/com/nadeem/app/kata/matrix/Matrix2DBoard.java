package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Board;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DBoard extends Board {

	public Matrix2DBoard(int rows, int columns) {		
		super(new Matrix2DCellprovider(rows, columns), new MatrixFoodProvider());
	}
}
