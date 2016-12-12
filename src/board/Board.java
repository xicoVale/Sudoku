package board;

import java.util.Scanner;

public class Board {

	private final int SIZE = 9;
	private int[][] board = new int [SIZE][SIZE];
	
	public Board() {
		init();
	}
	public Board(int[][] board){
		setBoard(board);	
	}
	
	public int getSize() {
		return this.SIZE;
	}
	
	public void setBoard(int [][] board) {
		for(int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				this.board[col][row] = board[col][row];
			}
		}
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	
	/**
	 * Board initialisation
	 * 
	 */
	public void init() {
		// Initialise board with -1
		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				this.board[row][col] = -1;
			}
		}
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			
			int col = Integer.parseInt(line.split(" ")[0]);
			if (col == -1) {
				break;
			}
			int row = Integer.parseInt(line.split(" ")[1]);
			int value = Integer.parseInt(line.split(" ")[2]);
			
			setValue(col, row, value);
		}
		in.close();
	}
	
	public boolean isEmpty(int col, int row) {
		return board[col][row] == -1;
	}
	
	public void setValue(int col, int row, int value) {
		this.board[col][row] = value;
	}
	
	/**
	 * Checks if a value already exists in this row
	 * 
	 * @param row
	 * @param value
	 * @return true if value doesn't exist or false otherwise
	 */
	public boolean checkRow(int row, int value) {
		for (int col = 0; col < SIZE; col++) {
			if (board[col][row] == value) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a value already exists in this column
	 * 
	 * @param col
	 * @param value
	 * @return true if the value doesn't exist or false otherwise
	 */
	public boolean checkCol(int col, int value) {
		for (int row = 0; row < SIZE; row++) {
			if (board[col][row] == value) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if a value already exists in the current 3x3 matrix
	 * 
	 * @param col
	 * @param row
	 * @param value
	 * @return true of the value doesn't exist or false otherwise
	 */
	public boolean checkSquare(int col, int row, int value) {
		int colStart = col - (col % 3);
		int rowStart = row - (row % 3);
		
		
		for (int c = colStart; c < colStart + 3; c++) {
			for (int r = rowStart; r < rowStart + 3; r++) {
				if (board[c][r] == value) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void print() {
		for (int col = 0; col < SIZE; col++) {
			for (int row = 0; row < SIZE; row++) {
				System.out.print(board[col][row] + " ");
			}
			System.out.println();
		}
	}
}
