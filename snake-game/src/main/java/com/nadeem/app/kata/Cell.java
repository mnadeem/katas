package com.nadeem.app.kata;

import com.nadeem.app.kata.food.Food;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Cell {

	private Position position;
	private CellType cellType;
	private Food food;
	
	public Cell(final Position postition) {
		this.position = postition;
		this.cellType = CellType.EMPTY;
	}

	public Position getPosition() {
		return position;
	}

	public Food getFood() {
		return food;
	}

	public CellType getCellType() {
		return cellType;
	}

	private enum CellType {
		EMPTY,SNAKE_PART,SNAKE_HEAD;
	}

	public void markEmpty() {
		this.cellType = CellType.EMPTY;
		
	}

	public void markSnakePart() {
		this.cellType = CellType.SNAKE_PART;		
	}

	public void markSnakeHead() {
		this.cellType = CellType.SNAKE_HEAD;		
	}

	public void setFood(Food providedFood) {
		this.food = providedFood;		
	}

	public boolean isEmpty() {
		return this.cellType == CellType.EMPTY;
	}

	public boolean isSnakePart() {
		return this.cellType == CellType.SNAKE_PART;
	}

	public boolean isSnakeHead() {
		return this.cellType == CellType.SNAKE_HEAD;
	}


	@Override
	public String toString() {
		return "Cell [position=" + position + ", food=" + food + ", cellType=" + cellType + "]";
	}

}
