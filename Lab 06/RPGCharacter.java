/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates abstract RPGCharacter
*/
public abstract class RPGCharacter {
	
	protected String name;
	protected String rpgClass;
	protected int healthPoints;
	protected String damageType;
	protected boolean alive;
	
	
	/**
	 * Default constructor for a trait that every character has, initially alive
	 */
	public RPGCharacter(){
		alive = true;
	}
	
	
	/**
	 * Getter for the name of a character
	 * @return Name of character
	 */
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * Getter for current HP of character
	 * @return current HP
	 */
	public int getHealthPoints(){
		return this.healthPoints;
	}
	
	
	/**
	 * Setter for HP of character
	 * @param health - New HP amount for health to be
	 */
	public void setHealthPoints(int health){
		healthPoints = health;
		
		// If HP is zero, then set character to dead
		if(healthPoints <= 0){
			alive = false;
		}
	}
	
	
	/**
	 * Getter for current alive state
	 * @return Current state of alive or dead
	 */
	public boolean getAlive(){
		return this.alive;
	}
	
	
	/**
	 * Fight other enemies
	 * @param contestants - Array of people who are fighting
	 * @param numberOfPlayers - Number of people who are currently alive and fighting
	 */
	public abstract void fight(RPGCharacter[] contestants, int numberOfPlayers);
	
	
	/**
	 * To handle what happens when character receives damage
	 * @param damage - The damage the character takes
	 */
	public abstract void damageReceived(Damage damage);
	
	
	/**
	 * Any special actions when this character is killed
	 * @param damage - The damage last done to the character to determine who attacked
	 * @return Damage to the player who did the finishing blow
	 */
	public Damage whenKilled(Damage damage){
		return null;
	}
	
	
	/**
	 * String representation of the object
	 */
	public String toString(){
		String status = (this.name + " the ");
		if(this.getAlive() == true){
			status += (this.rpgClass + ", Health: " + this.getHealthPoints());
		}
		else{
			status += ("dead");
		}
		return status;
	}
}
