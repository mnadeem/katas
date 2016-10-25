package com.nadeem.app.kata;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public abstract class Game {

	private final Board board;
	private final CellRenderer cellRenderer;
	private final Snake snake;

	public Game(final Board board, final CellRenderer cellRenderer) {
		this.board = board;
		this.cellRenderer = cellRenderer;
		this.snake = new Snake(board.getSnakePosition());
	}

	public void move(final Direction direction) {
		Cell currentPosition = snake.getHead();
		Cell nextCell = board.getNextPosition(currentPosition, direction);
		if (snake.crashWithIteself(nextCell)) {
			throw new GameOverException();
		} else {	
			if (nextCell.getFood() != null) {
				Counter.getInstance().incrementScoreBy(nextCell.getFood().getBonus());
				snake.grow(nextCell);
				board.generateFood();
			}
			snake.move(nextCell);
		}
	}

	public void display() {
		this.board.display(cellRenderer);
	}
}
