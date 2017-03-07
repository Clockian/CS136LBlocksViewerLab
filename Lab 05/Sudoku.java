/*
 * Created by Jasque Saydyk and Joshua Pollock
 * Lab 05 - Sudoku
 * CS 136L Section 3801
 * 28 February 2017
 * Description - This class creates backend of Sudoku game
 * Puzzle is to be 9x9 with sub squares of 3x3
*/
import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {
	
	private int[][] sudokuPuzzle;
	
	/**
	 * Initializes an empty Sudoku puzzle
	 */
	public Sudoku(){
		sudokuPuzzle = new int[9][9];
	}
	
	/**
	 * Initializes an initial configuration of puzzle
	 * @param starting_configuration Represents one character per grid square,
	 * each row ending with a character return, blank spaces represented with a space 
	 */
	public Sudoku(String starting_configuration){
		sudokuPuzzle = new int[9][9];
		
		// Split the string into 9 char long String segments, then put into array, 
		// representing the rows of a table
		String[] tokens = starting_configuration.split("\n");
		String row;
		Character temp;
		
		// Takes a row, then grabs each char from it and converts it to a number. Spaces are -1
		for(int ii = 0; ii < 9; ii++){
			row = tokens[ii];
			for(int jj = 0; jj < 9; jj++){
				temp = row.charAt(jj);
				sudokuPuzzle[ii][jj] = Character.getNumericValue(temp);
			}
		}
	}
	
	/**
	 * Gives the digit in the requested squares, numbered from 0 to 8
	 * @param row Row that digit exists in
	 * @param col Column that digit exists in
	 * @return char of digit in square
	 */
	public char getSquare(int row, int col){
		Integer tmp = sudokuPuzzle[row][col];
		
		// Spaces are -1, requires special conversion, or else you return dashes
		if(tmp == -1){
			return ' ';
		}
		else{
			return tmp.toString().charAt(0);
		}
	}
	
	/**
	 * Sets the puzzle to store the value at the given location
	 * @param row Row to store digit
	 * @param col Column to store digit
	 * @param value Digit to store at given location
	 */
	public void setSquare(int row, int col, char value){
		sudokuPuzzle[row][col] = Character.getNumericValue(value);
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
		for(int ii = 0; ii < 9; ii++){
			// Creates an ArrayList of a row of sudokuPuzzle
			ArrayList<Integer> listRow = new ArrayList<>();
			for(int jj = 0; jj < 9; jj++){
				listRow.add(sudokuPuzzle[ii][jj]);
			}
			
			// Evaluates row if it's numbers are in range for 1-9
			boolean inRangeRow = listRow.stream()
					.filter(c -> c != -1)
					.allMatch(c -> c >= 1 && c <= 9);
			
			// Evaluates row if it has any duplicates
			boolean anyRepeatsRow = listRow.stream()
					.filter(c -> c != -1)
					.allMatch(new HashSet<>()::add);
			
			// Creates an ArrayList of a column of sudokuPuzzle
			ArrayList<Integer> listCol = new ArrayList<>();
			for(int jj = 0; jj < 9; jj++){
				listCol.add(sudokuPuzzle[jj][ii]);
			}
			
			// Evaluates column if it's numbers are in range for 1-9
			boolean inRangeCol = listCol.stream()
					.filter(c -> c != -1)
					.allMatch(c -> c >= 1 && c <= 9);
			
			// Evaluates column if it has any duplicates
			boolean anyRepeatsCol = listCol.stream()
					.filter(c -> c != -1)
					.allMatch(new HashSet<>()::add);
			
			// Creates an ArrayList of a square of sudokuPuzzle
			ArrayList<Integer> listSquare = getSquare(ii);
			
			// Evaluates square if it's numbers are in range for 1-9
			boolean inRangeSqr = listSquare.stream()
					.filter(c -> c != -1)
					.allMatch(c -> c >= 1 && c <= 9);
			
			// Evaluates square if it has any duplicates
			boolean anyRepeatsSqr = listSquare.stream()
					.filter(c -> c != -1)
					.allMatch(new HashSet<>()::add);
			
			// Evaluate if valid or not
			if(inRangeRow == false || anyRepeatsRow == false ||
			   inRangeCol == false || anyRepeatsCol == false ||
			   inRangeSqr == false || anyRepeatsSqr == false) return false;
		}
		return true;
	}
	
	/**
	 * This gets a unique 3x3 quadrent of the sudoku puzzle
	 * @param quadrent numbered from 0 to 8 from left to right, top to bottom
	 * @return an ArrayList of the numbers in the 3 by 3 quadrent
	 */
	private ArrayList<Integer> getSquare(int quadrent){
		ArrayList<Integer> square = new ArrayList<>();
		
		// Initialize to be -1 to generate error if something goes wrong
		int row = -1;
		int col = -1;
		int endRow = -1;
		int endCol = -1;
		
		// Row and Col identify the top left index of square,
		// endRow and endCol identify bottom right index of square
		switch(quadrent){
		case 0: 
			row = 0; endRow = 3;
			col = 0; endCol = 3;
			break;
		case 1: 
			row = 0; endRow = 3;
			col = 3; endCol = 6;
			break;
		case 2: 
			row = 0; endRow = 3;
			col = 6; endCol = 9;
			break;
		case 3: 
			row = 3; endRow = 6;
			col = 0; endCol = 3;
			break;
		case 4: 
			row = 3; endRow = 6;
			col = 3; endCol = 6;
			break;
		case 5: 
			row = 3; endRow = 6;
			col = 6; endCol = 9;
			break;
		case 6: 
			row = 6; endRow = 9;
			col = 0; endCol = 3;
			break;
		case 7: 
			row = 6; endRow = 9;
			col = 3; endCol = 6;
			break;
		case 8: 
			row = 6; endRow = 9;
			col = 6; endCol = 9;
			break;
		default: 
			System.out.println("ERROR: getSquare()");
			break;
		}
		
		// Insert all units of the square in the array into the ArrayList
		for(int ii = row; ii < endRow; ii++){
			for(int jj = col; jj < endCol; jj++){
				square.add(sudokuPuzzle[ii][jj]);
			}
		}
		
		return square;
	}
	
	/**
	 * Checks if the puzzle has no blank spaces and is valid
	 * @return True if there are no blank spaces and is valid
	 */
	public boolean isSolved(){
		boolean valid = isValid();
		
		// Goes through all the rows of the table
		for(int ii = 0; ii < 9; ii++){
			
			// Creates an ArrayList of a row of sudokuPuzzle
			ArrayList<Integer> listRow = new ArrayList<>();
			for(int jj = 0; jj < 9; jj++){
				listRow.add(sudokuPuzzle[ii][jj]);
			}
			
			// Evaluates column if it's numbers are equal to -1
			boolean inRangeRow = listRow.stream().allMatch(c->c!=-1);
			
			// Evaluates if it is solved or not
			if(valid == false || inRangeRow == false) return false;
		}
		return true;
	}
}
