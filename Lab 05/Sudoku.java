/*
 * Created by Jasque Saydyk and Joshua Pollock
 * Lab 05 - Sudoku
 * CS 136L Section 3801
 * 28 February 2017
 * Description - This class creates backend of Sudoku game
 * Puzzle is to be 9x9 with sub squares of 3x3
*/
public class Sudoku {
	
	/**
	 * Initializes an empty Sudoku puzzle
	 */
	public Sudoku(){
		
	}
	
	/**
	 * Initializes an initial configuration of puzzle
	 * @param starting_configuration Represents one character per grid square,
	 * each row ending with a character return, blank spaces represented with a space 
	 */
	public Sudoku(String starting_configuration){
		
	}
	
	/**
	 * Gives the digit in the requested square
	 * @param row Row that digit exists in
	 * @param col Column that digit exists in
	 * @return char of digit in square
	 */
	public char getSquare(int row, int col){
		return 0;
	}
	
	/**
	 * Sets the puzzle to store the value at the given location
	 * @param row Row to store digit
	 * @param col Column to store digit
	 * @param value Digit to store at given location
	 */
	public void setSquare(int row, int col, char value){
		
	}
	
	/**
	 * Checks if the three Sudoku rules are observed
	 * 1. No duplicate numbers in each row
	 * 2. No duplicate numbers in each column
	 * 3. No duplicate numbers in each sub-square(3x3)
	 * Should be 25 lines or smaller (hint: use private methods)
	 * @return True if all the rules are properly observed
	 */
	public boolean isValid(){
		return false;
	}
	
	/**
	 * Checks if the puzzle has no blank spaces and is valid
	 * @return True if there are no blank spaces and is valid
	 */
	public boolean isSolved(){
		return false;
	}
}
