package com.nadeem.app.kata;

import com.nadeem.app.kata.player.Player;

public class Game {

	private Player playerOne;
	private Player playerTwo;
	private Board board;

	public boolean enter(Player player) {
		if (playerOne == null) {
			playerOne = player;
		} else if (playerTwo == null) {
			playerTwo = player;
		} else {
			return false;
		}
		board.initialize(player.getPieces());
		return true;
	}

	public void start() {
		while(true) {
			processTurn(this.playerOne);
			if (board.gameOver()) {
				System.out.println(this.playerOne.getName() + " Wins!");
				break;
			}
			processTurn(playerTwo);
			if (board.gameOver()) {
				System.out.println(this.playerTwo.getName() + " Wins!");
				break;
			}
		}
	}

	private void processTurn(Player player) {
		Command command;
		do {
			command = player.getCommand();
			
		} while(!board.execute(command));
	}
}
