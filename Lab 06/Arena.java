/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates methods to manage the arena
*/
import java.util.Random;

public class Arena {
	
	private RPGCharacter[] contestants;
	private int currentSize;
	
	
	public Arena(int numberOfPlayers){
		contestants = new RPGCharacter[numberOfPlayers];
		currentSize = 0;
	}
	
	public int getCurrentSize(){
		return currentSize;
	}
	
	/**
	 * Adds an RPGCharacter to the array in the arena
	 * @param person
	 */
	public void addPlayer(RPGCharacter person){
		// If array is full
		if(currentSize == contestants.length){
			throw new IndexOutOfBoundsException();
		}
		else{
			contestants[currentSize] = person;
			currentSize++;
		}
	}
	
	/**
	 * Removes any dead people from the arena array
	 */
	public void removeDead(){
		for(int ii = 0; ii < currentSize; ii++){
			if(contestants[ii].getAlive() == false){
				System.out.println("Taking " + contestants[ii].getName() + " to the graveyard");
				currentSize--;
				for(int jj = ii; jj < contestants.length-1; jj++){
					contestants[jj] = contestants[jj + 1];
					if(jj == contestants.length - 1){
						contestants[jj] = null;
					}
				}
			}
		}
	}
	
	/**
	 * prints the status of everyone in arena
	 */
	public void printStatus(){
		for(int ii = 0; ii < currentSize; ii++){
			System.out.println(contestants[ii].toString());
		}
	}
	
	/**
	 * performs a single turn in the game
	 * @param player
	 */
	public void takeTurn(int player){
		RPGCharacter playerTurn = contestants[player];
		Damage damage = playerTurn.fight(contestants, currentSize);
		
		// Ghetto solution to wild mage attack, bad form i know
		if(damage == null){
			Random rand = new Random();
			
			for(RPGCharacter x : contestants){
				if(!(x.getName().equals(playerTurn.getName()))){
					int hit = rand.nextInt(7);
					x.setHealthPoints(x.getHealthPoints() - hit);
					System.out.println(playerTurn.getName() + " FIRE " + x.getName() + " for " + hit + "damage");
				}
			}
		}
		
		// Go through each contestant and find who to do damage to
		for(int ii = 0; ii < currentSize; ii++){
			// This means wizard is attacking. it is handled above, skip
			if(damage == null){
				
			}
			else if(damage.getAttackCharacterName().equals(contestants[ii].getName())){
				contestants[ii].damageReceived(damage);
				Damage retaliate = contestants[ii].whenKilled(damage);
				if(retaliate != null){
					playerTurn.damageReceived(retaliate);
				}
			}
		}
	}
	
	/**
	 * determines if there is one person left in arena who is winner
	 */
	public void determineWinner(){
		if(currentSize <= 1){
			System.out.println("The winner is " + contestants[0].getName());
		}
	}
}
