package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			
			//Uma casa acima
			p.setValues(position.getRow() -1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Duas casas acima
			p.setValues(position.getRow() -2, position.getColumn());
			Position p2 = new Position(position.getRow() -1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Diagonal esquerda
			p.setValues(position.getRow() -1, position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Diagonal direita
			p.setValues(position.getRow() -1, position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}else {
			//Uma casa acima
			p.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Duas casas acima
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && !getBoard().thereIsAPiece(p2)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Diagonal esquerda
			p.setValues(position.getRow() + 1, position.getColumn()-1);
			if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//Diagonal direita
			p.setValues(position.getRow() + 1, position.getColumn()+1);
			if(getBoard().positionExists(p) && isThereOponnentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
}
