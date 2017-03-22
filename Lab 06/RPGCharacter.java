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
	
	public RPGCharacter(){
		alive = true;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getHealthPoints(){
		return this.healthPoints;
	}
	
	public void setHealthPoints(int health){
		healthPoints = health;
		if(healthPoints <= 0){
			alive = false;
		}
	}
	
	public boolean getAlive(){
		return this.alive;
	}
	
	/**
	 * Method to fight other enemies
	 * @param enemies
	 * @param numberOfPlayers
	 * @return
	 */
	public abstract Damage fight(RPGCharacter[] enemies, int numberOfPlayers);
	
	/**
	 * To handle being damaged
	 * @param damage
	 */
	public abstract void damageReceived(Damage damage);
	
	/**
	 * Any special actions when this is killed
	 * @param damage
	 * @return
	 */
	public abstract Damage whenKilled(Damage damage);
	
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
