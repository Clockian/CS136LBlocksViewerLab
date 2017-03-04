/*
 * Created by Jasque Saydyk and Joshua Pollock
 * Lab 05 - Sudoku
 * CS 136L Section 3801
 * 3 March 2017
 * Description - This class tests the current implementation of the 
 * Sudoku game
*/
public class Test {
	public static void main(String[] args){
		String start = "";
		start += "   26 7 1\n";
		start += "68  7  9 \n";
		start += "19   45  \n";
		start += "82 1   4 \n";
		start += "  46 29  \n";
		start += " 5   3 28\n";
		start += "  93   74\n";
		start += " 4  5  36\n";
		start += "7 3 18   \n";
		
		Sudoku test = new Sudoku(start);
		
		String start2 = "";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		start2 += "222222222\n";
		
		Sudoku test2 = new Sudoku(start2);
		
		// Testing test
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				System.out.print(test.getSquare(x, y));
				System.out.print("|");
			}
			System.out.println();
		}
		
		System.out.println("\nTesting Get Square in 9th column on first row");
		System.out.println(test.getSquare(0, 8));
		
		
		System.out.println("\nTesting isValid()");
		System.out.println(test.isValid());
		System.out.println();
		System.out.println();
		
		// Testing test2
		for(int x = 0; x < 9; x++){
			for(int y = 0; y < 9; y++){
				System.out.print(test2.getSquare(x, y));
				System.out.print("|");
			}
			System.out.println();
		}
		
		System.out.println("\nTesting Get Square in 9th column on first row");
		System.out.println(test2.getSquare(0, 8));
		
		
		System.out.println("\nTesting isValid()");
		System.out.println(test2.isValid());
	}
}
