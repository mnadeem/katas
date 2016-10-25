package com.nadeem.app.kata.matrix;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.nadeem.app.kata.Board;
import com.nadeem.app.kata.Cell;
import com.nadeem.app.kata.CellProvider;
import com.nadeem.app.kata.Direction;
import com.nadeem.app.kata.Position;
import com.nadeem.app.kata.food.Apple;
import com.nadeem.app.kata.food.Banana;
import com.nadeem.app.kata.food.Food;
import com.nadeem.app.kata.food.FoodProvider;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Matrix2DBoard extends Board {

	public Matrix2DBoard(int rows, int columns) {		
		super(new MatrixCellprovider(rows, columns), new MatrixFoodProvider());
	}

	private static class MatrixCellprovider implements CellProvider {
		private final int rows;
		private final int cols;
		
		private Map<Matrix2DPoint, Cell> cells = new HashMap<Matrix2DPoint, Cell>();

		public MatrixCellprovider(int rows, int cols) {
			this.rows = rows;
			this.cols = cols;
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Matrix2DPoint postition = new Matrix2DPoint(row, col);
					cells.put(postition, new Cell(postition));
				}
			}
		}

		public Collection<Cell> allCells() {
			return cells.values();
		}

		public Cell getNext(Position position, Direction direction) {
			Matrix2DPoint point = (Matrix2DPoint) position;
			int row = point.row;
			int col = point.column;

			if (Direction.UP.equals(direction)) {
				row--;
			} else if (Direction.DOWN.equals(direction)) {
				row++;
			}else if (Direction.LEFT.equals(direction)) {
				col--;
			} else {
				col++;
			}		
			return get(row, col);
		}

		public Cell provideFoodCell() {
			int row = (int) (Math.random() * rows);
	        int column = (int) (Math.random() * cols);
			Cell cell = get(row, column);
			return cell;
		}

		public Cell getSnakeInitialPosition() {
			return get(0, 0);
		}		

		private Cell get(int row, int column) {
			if (row >= rows ) {
				row = 0;
			} else if (row < 0) {
				row = rows - 1;
			}
			if (column >= cols) {
				column = 0;
			} else if (column < 0) {
				column = cols - 1;
			}
			return cells.get(new Matrix2DPoint(row, column));
		}

		public Cell get(Position position) {
			Matrix2DPoint point = (Matrix2DPoint) position;
			int row = point.row;
			int col = point.column;

			return get(row, col);
		}		
	}

	private static class MatrixFoodProvider implements FoodProvider {

		public Food provideFood() {
			int max = 2;
			int min = 1;
			int rn = ThreadLocalRandom.current().nextInt(min, max + 1);
			if (rn == 1) {
				return new Banana();
			}
			return new Apple();
		}		
	}
}
