package com.nadeem.app.kata.matrix;

import com.nadeem.app.kata.Cell;
import com.nadeem.app.kata.CellProvider;
import com.nadeem.app.kata.CellRenderer;
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
		super(new Matrix2DBoard(rows, cols), new Matrix2DConsoleRenderer());
	}

	public static class Matrix2DConsoleRenderer implements CellRenderer {
		public void render(CellProvider cellProvider) {
			displayMarker();
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Cell cell = cellProvider.get(new Matrix2DPoint(row, col));
					System.out.print(getData(cell));
				}
				System.out.println();
			}
			displayMarker();			
		}

		private void displayMarker() {
			for (int row = 0; row < rows; row++) {
				System.out.print("=");
			}
			System.out.println();
		}

		private String getData(Cell cell) {
			StringBuilder result = new StringBuilder();
			if (cell.getFood() != null) {
				result.append(cell.getFood().getSymbol()) ;
			} else if (cell.isEmpty()) {
				result.append(" ") ;
			} else {
				result.append("#");
			}
			return result.toString();
		}
	}
}
