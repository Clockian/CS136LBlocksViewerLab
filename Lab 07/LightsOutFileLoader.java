/*
 * Created by Jasque Saydyk and Justin Coffey
 * Lab 07 - Lights Out
 * CS 136L Section 3801
 * 21 March 2017
 * Description - Loads the files necessary Lights Out game
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LightsOutFileLoader {
	public void load(LightsOut game, File inputfile) throws FileNotFoundException, UnsupportedLightsOutFileException{
		Scanner scan = new Scanner(inputfile);
		String line = scan.nextLine();
		for(int ii = 0; ii < line.length(); ii++){
			for(int jj = 0; jj < line.length(); jj++){
				Character input = line.charAt(jj);
				convertCharInput(game, ii, jj, input);
			}
			if(ii != line.length() - 1){
				line = scan.nextLine();
			}
		}
		scan.close();
	}
	
	/**
	 * This method converts the Character input to boolean for LightsOut class
	 * @param input - Character input that is either _ or X
	 * @return The boolean value representing an on or off light
	 * @throws UnsupportedLightsOutFileException 
	 */
	private void convertCharInput(LightsOut game, int row, int col, Character input) throws UnsupportedLightsOutFileException{
		if(input.equals('_')){
			game.forceLit(row, col, true);
		}
		else if(input.equals('X')){
			game.forceLit(row, col, false);
		}
		else{
			throw new UnsupportedLightsOutFileException();
		}
	}
}
