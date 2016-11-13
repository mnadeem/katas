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
		return this.cellProvider.getNext(currentPosition.getPosition(), direction);
	}

	public void generateFood() {
		Cell foodCell = this.cellProvider.provideFoodCell();
		foodCell.setFood(this.foodProvider.provideFood());
	}

	public Collection<Cell> allCells() {
		return this.cellProvider.allCells();
	}

	public Cell getSnakeInitialPosition() {
		return this.cellProvider.getSnakeInitialPosition();
	}

	public void display(final CellRenderer cellRenderer) {
		cellRenderer.render(this.cellProvider);
	}
}
