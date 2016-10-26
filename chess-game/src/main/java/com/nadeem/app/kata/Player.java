package com.nadeem.app.kata;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

	private String name;
	private PieceColor pieceColor;
	private List<Piece> pieces;

	public abstract Command getCommand();

	public Player(String name, PieceColor pieceColor) {
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
