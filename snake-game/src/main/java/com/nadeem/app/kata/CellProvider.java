package com.nadeem.app.kata;

import java.util.Collection;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public interface CellProvider {

	Collection<Cell> allCells();
	Cell getNext(Position position, Direction direction);
	Cell provideFoodCell();
	Cell getSnakeInitialPosition();
	Cell get(Position position);
}
