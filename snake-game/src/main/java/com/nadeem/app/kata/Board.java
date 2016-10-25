package com.nadeem.app.kata;

import java.util.Collection;

import com.nadeem.app.kata.food.FoodProvider;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Board {

	private CellProvider cellProvider;
	private FoodProvider foodProvider;

	public Board(final CellProvider cellProvider, final FoodProvider foodProvider) {
		this.cellProvider = cellProvider;
		this.foodProvider = foodProvider;
		this.generateFood();
	}

	public Cell getNextPosition(final Cell currentPosition, final Direction direction) {
		return cellProvider.getNext(currentPosition.getPosition(), direction);
	}

	public void generateFood() {
		Cell foodCell = cellProvider.provideFoodCell();
		foodCell.setFood(foodProvider.provideFood());
	}

	public Collection<Cell> allCells() {
		return cellProvider.allCells();
	}

	public Cell getSnakePosition() {
		return cellProvider.getSnakeInitialPosition();
	}

	public void display(final CellRenderer cellRenderer) {
		cellRenderer.render(this.cellProvider);
	}
}
