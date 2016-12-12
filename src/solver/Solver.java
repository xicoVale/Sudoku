package solver;

import board.Board;

public class Solver {

	private Board board;
	
	public Solver() {
		this.board = new Board();
	}
	
	public void solve() {
		solve(0, 0, this.board);
	}
	
	public boolean solve(int col, int row, Board board) {
		Board copy = new Board(board.getBoard());
		
		int size = copy.getSize();
		
		if (copy.isEmpty(col, row)) {
			for (int value = 1; value <= size; value++) {
				if (copy.checkCol(col, value) 
						&& copy.checkRow(row, value) 
						&& copy.checkSquare(col, row, value)) {
					copy.setValue(col, row, value);
		
					boolean found = cont(col, row, copy);
					if (found) {
						return found;
					}
				}
			}
		}
		else {
			return cont(col, row, copy);
			
		}
		return false;
	}
	
	private boolean cont(int col, int row, Board board) {
		int size = board.getSize();
		if (col == size - 1 && row == size - 1) {
			board.print();
			return true;
		}
		else if (row == size -1) {
			int nextcol = col + 1;
			int nextrow = 0;
			return solve(nextcol, nextrow, board);
		}
		else {
			int nextrow = row + 1;
			return solve(col, nextrow, board);
		}
	}
}
