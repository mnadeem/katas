package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.List;

import com.nadeem.app.kata.piece.Bishop;
import com.nadeem.app.kata.piece.King;
import com.nadeem.app.kata.piece.Knight;
import com.nadeem.app.kata.piece.Pawn;
import com.nadeem.app.kata.piece.Queen;
import com.nadeem.app.kata.piece.Rook;

/**
 * @author Nadeem Mohammad
 *
 */
public abstract class Player {

	private String name;
	private Color color;
	private List<Piece> pieces;

	public abstract Command getCommand();

	public Player(final String name, final Color color) {
		this.name = name;
		this.color = color;
		this.pieces = new ArrayList<Piece>();
		initPieces();
	}

	private void initPieces() {
		 for(int i = 0; i< 8; i++) {
             pieces.add(new Pawn(i, color));
         }
         pieces.add(new Rook(1, color));
         pieces.add(new Rook(2, color));
         pieces.add(new Bishop(1, color));
         pieces.add(new Bishop(2, color));
         pieces.add(new Knight(1, color));
         pieces.add(new Knight(2, color));
         pieces.add(new Queen(1, color));
         pieces.add(new King(1, color));	
	}

	public String getName() {
		return this.name;
	}

	public List<Piece> getPieces() {
		return this.pieces;
	}
}
