package sudoku;

import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {
	
    private Sudoku setUpFullSudoku()
    {
		String start = "";
		start += "435269781\n";
		start += "682571493\n";
		start += "197834562\n";
		start += "826195347\n";
		start += "374682915\n";
		start += "951743628\n";
		start += "519326874\n";
		start += "248957136\n";
		start += "763418259\n";
		return new Sudoku(start);
    }
	
	
	// (new) Instantiating Sudoku puzzles with invalid characters or layouts
	// should throw an IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void instantiateIllegalArgumentException(){
		String start = "";
		start += "2   6 2 1\n";
		start += "68  7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  4A 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "7 3 18   \n";
		Sudoku test = new Sudoku(start);
	}
	
	// (new) Instantiating Sudoku puzzles with invalid characters or layouts
	// should throw an IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void instantiateRepeatRowIllegalArgumentException(){
		String start = "";
		start += "2   6 2 1\n";
		start += "68  7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  46 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "7 3 18   \n";
		Sudoku test = new Sudoku(start);
	}
	
	// (new) Instantiating Sudoku puzzles with invalid characters or layouts
	// should throw an IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void instantiateRepeatColumnIllegalArgumentException(){
		String start = "";
		start += "2   6   1\n";
		start += "68  7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  46 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "2 3 18   \n";
		Sudoku test = new Sudoku(start);
	}
	
	// (new) Instantiating Sudoku puzzles with invalid characters or layouts
	// should throw an IllegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void instantiateRepeatSquareIllegalArgumentException(){
		String start = "";
		start += "2   6   1\n";
		start += "62  7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  46 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "7 3 18   \n";
		Sudoku test = new Sudoku(start);
	}
	
	// getSquare should return the correct character for a given location
	@Test
	public void canGetSquare(){
		Sudoku test = setUpFullSudoku();
		Assert.assertEquals(9, Character.getNumericValue(test.getSquare(3, 4)));
	}
	
	// setSquare should set correctly for a given location
	@Test
	public void canSetSquare(){
		Sudoku test = setUpFullSudoku();
		test.setSquare(2, 2, '7');
		Assert.assertEquals(7, Character.getNumericValue(test.getSquare(2, 2)));
	}
	
	// (new) setSquare should throw an IllegalArgumentException if it is
	// passed an invalid character
	@Test(expected=IllegalArgumentException.class)
	public void badSetSquare(){
		Sudoku test = setUpFullSudoku();
		test.setSquare(2, 2, 'A');
	}
	
	// isValid should return false if there are any repeated numbers in a row
	private boolean isValidRow(Sudoku puzzle){
		return puzzle.isValid();
	}
	
	// isValid should return false if there are any repeated numbers in a column
	private boolean isValidColumn(Sudoku puzzle){
		return puzzle.isValid();
	}
	
	// isValid should return false if there are any repeated numbers in any of
	// the nine 3x3 subsquares
	private boolean isValidSquare(Sudoku puzzle){
		return puzzle.isValid();
	}
	
	// isValid should return true if no earlier rules are violated
	@Test
	public void isValidTest(){
		Sudoku puzzle = setUpFullSudoku();
		Assert.assertEquals(true, isValidRow(puzzle));
		Assert.assertEquals(true, isValidColumn(puzzle));
		Assert.assertEquals(true, isValidSquare(puzzle));
	}
	
	// isSolved should return false if there are any blank spaces
	@Test
	public void isSolvedFalse(){
		String start = "";
		start += "2   6   1\n";
		start += "6   7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  46 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "7 3 18   \n";
		Sudoku test = new Sudoku(start);
		Assert.assertEquals(false, test.isSolved());
	}
	
	// isSolved should return true if no earlier solve or validity rules are violated
	@Test
	public void isSolvedTrue(){
		Sudoku puzzle = setUpFullSudoku();
		Assert.assertEquals(true, puzzle.isSolved());
	}
}
