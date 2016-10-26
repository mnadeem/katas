package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.List;

import com.nadeem.app.kata.piece.Bishop;
import com.nadeem.app.kata.piece.King;
import com.nadeem.app.kata.piece.Knight;
import com.nadeem.app.kata.piece.Pawn;
import com.nadeem.app.kata.piece.Queen;
import com.nadeem.app.kata.piece.Rook;

public abstract class Player {

	private String name;
	private Color pieceColor;
	private List<Piece> pieces;

	public abstract Command getCommand();

	public Player(String name, Color pieceColor) {
		this.name = name;
		this.pieceColor = pieceColor;
		this.pieces = new ArrayList<Piece>();
		initPieces();
	}

	private void initPieces() {
		 for(int i = 0; i< 8; i++) {
             pieces.add(new Pawn(String.valueOf(i), pieceColor));
         }
         pieces.add(new Rook("1", pieceColor));
         pieces.add(new Rook("2", pieceColor));
         pieces.add(new Bishop("1", pieceColor));
         pieces.add(new Bishop("2", pieceColor));
         pieces.add(new Knight("1", pieceColor));
         pieces.add(new Knight("2", pieceColor));
         pieces.add(new Queen("1", pieceColor));
         pieces.add(new King("1", pieceColor));	
	}

	public String getName() {
		return this.name;
	}

	public List<Piece> getPieces() {
		return this.pieces;
	}
}
