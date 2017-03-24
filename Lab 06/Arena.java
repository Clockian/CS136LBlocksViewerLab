/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates methods to manage the arena
*/
public class Arena {
	
	private RPGCharacter[] contestants;
	private int currentPlayerCount;
	
	/**
	 * Default Constructor
	 * @param numberOfPlayers - Number of players for game for size of array
	 */
	public Arena(int numberOfPlayers){
		contestants = new RPGCharacter[numberOfPlayers];
		currentPlayerCount = 0;
	}
	
	/**
	 * Getter for current number of players in the array
	 * @return The current number of players in arena
	 */
	public int getCurrentPlayerCount(){
		return currentPlayerCount;
	}
	
	/**
	 * Adds an RPGCharacter to the array in the arena
	 * @param person - Any object that inherits RPGCharacter
	 */
	public void addPlayer(RPGCharacter person){
		// If array is full
		if(currentPlayerCount == contestants.length){
			throw new IndexOutOfBoundsException();
		}
		else{
			contestants[currentPlayerCount] = person;
			currentPlayerCount++;
		}
	}
	
	/**
	 * Removes any dead people from the Arena array
	 * @param currentTurn - The character whose turn it currently is
	 * @return The number of dead characters who were removed before the current turn
	 * Recommended that you subtract this from the turn so you don't repeat a character's turn
	 */
	public int removeDead(int currentTurn){
		int deadRemoved = 0;
		for(int ii = 0; ii < currentPlayerCount; ii++){
			if(contestants[ii].getAlive() == false){
				System.out.println("Taking " + contestants[ii].getName() + " to the graveyard");
				currentPlayerCount--;
				
				// Count up number of dead removed if they were before or are the current turn
				if(ii <= currentTurn){
					deadRemoved++;
				}
				
				// For all contestants after dead forward by one
				for(int jj = ii; jj < contestants.length-1; jj++){
					contestants[jj] = contestants[jj + 1];
					if(jj == contestants.length - 1){
						contestants[jj] = null;
					}
				}
			}
		}
		return deadRemoved;
	}
	
	/**
	 * Prints the status of everyone in Arena
	 */
	public void printStatus(){
		for(int ii = 0; ii < currentPlayerCount; ii++){
			System.out.println(contestants[ii].toString());
		}
	}
	
	/**
	 * Performs a single turn in the game
	 * @param player - The int of the player whose turn it is to fight
	 */
	public void takeTurn(int player){
		RPGCharacter playerTurn = contestants[player];
		playerTurn.fight(contestants, currentPlayerCount);
	}
	
	/**
	 * Determines if there is one person left in arena who is winner
	 * In the event of a tie, whoever took their turn first wins
	 */
	public void determineWinner(){
		if(currentPlayerCount <= 1){
			System.out.println("The winner is " + contestants[0].getName());
		}
	}
}
