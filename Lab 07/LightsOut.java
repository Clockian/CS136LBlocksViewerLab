/*
 * Created by Jasque Saydyk and Justin Coffey
 * Lab 07 - Lights Out
 * CS 136L Section 3801
 * 21 March 2017
 * Description - Changes the lights in the Lights Out game
*/
public class LightsOut {
	
	boolean[][] board;
	
	
	/**
	 * For our basic constructor initialize your state to represent an empty
	 * lights out puzzle. The board should be square with the size representing the
	 * number of lights along each axis. Use the menu bar to make sure different
	 * sizes work for your game.
	 * @param size - Number of lights along each axis of square board
	 */
	public LightsOut(int size){
		board = new boolean[size][size];
	}
	
	
	/**
	 * Returns the size of the board as initialized in the constructor
	 * @return The size of the board as initialized in the constructor
	 */
	public int getSize(){
		return board.length;
	}
	
	
	/**
	 * Should take a row and column number and return true if that spot is
	 * currently lit
	 * @param row - The row index
	 * @param col - The column index
	 * @return 
	 */
	public boolean isLit(int row, int col){
		return board[row][col];
	}
	
	
	/**
	 * Takes a row, column and boolean value, and sets the puzzle to store value
	 * at the given location.
	 * @param row - The row index
	 * @param col - The column index
	 * @param value - The boolean value to change flip value to
	 */
	public void forceLit(int row, int col, boolean value){
		try{
			board[row][col] = value;
		}
		catch(ArrayIndexOutOfBoundsException e){
			//Does nothing as per assignment
		}
	}
	
	
	/**
	 * Simulates a press of a light in the game. This toggles the location specified
	 * as well as the four surrounding lights.
	 * @param row - The row index
	 * @param col - The column index
	 */
	public void press(int row, int col){
		boolean initialState = board[row][col];
		if(initialState == true){ 
			forceLit(row, col, false);
			forceLit(row + 1, col, false);
			forceLit(row - 1, col, false);
			forceLit(row, col + 1, false);
			forceLit(row, col - 1, false);
		}
		else{
			forceLit(row, col, false);
			forceLit(row + 1, col, false);
			forceLit(row - 1, col, false);
			forceLit(row, col + 1, false);
			forceLit(row, col - 1, false);
		}
	}
}
