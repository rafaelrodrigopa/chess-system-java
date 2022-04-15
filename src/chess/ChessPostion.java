package chess;

import boardgame.Position;

public class ChessPostion {

	private char column;
	private int row;
	public ChessPostion(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}

	//Transforma a posição do xadrez para posição da matrix
	protected Position toPosition() {
		
		// 'a' - 'a' = 0
		// 'b' - 'a' = 1
		// ...
		return new Position(8-row, column - 'a');
	}
	
	//Transforma a posição da matrix para posição do xadrez
	protected static ChessPostion fromPosition(Position position) {
		return new ChessPostion((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
