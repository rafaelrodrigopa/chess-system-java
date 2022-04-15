package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;
	private int moveCount;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public ChessPostion getChessPosition() {
		return ChessPostion.fromPosition(position);
	}
	
	protected boolean isThereOponnentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		//Verifica se a cor da pe�a � diferente da cor da pe�a adversaria
		return p != null && p.getColor() != color;
	}
	
}
