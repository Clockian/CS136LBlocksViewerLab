/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a damage object to pass around
*/
public class Damage {
	
	private String fromCharacter;
	private String attackCharacter;
	private String damageType;
	private int damageAmount;
	
	/**
	 * Default constructor for Damage class
	 * @param fromCharacter - Character who is sending the damage
	 * @param attackCharacter - Character who is receiving the damage
	 * @param damageType - Type of the damage being sent
	 * @param damageAmount - The amount of the damage
	 */
	public Damage(String fromCharacter, String attackCharacter, String damageType, int damageAmount){
		this.fromCharacter = fromCharacter;
		this.attackCharacter = attackCharacter;
		this.damageType = damageType;
		this.damageAmount = damageAmount;
	}
	
	/**
	 * Getter for character who is sending the damage
	 * @return The character who is sending the damage name
	 */
	public String getFromCharacterName(){
		return this.fromCharacter;
	}
	
	/**
	 * Getter for Character who is receiving the damage
	 * @return The character who is receiving the damage name
	 */
	public String getAttackCharacterName(){
		return this.attackCharacter;
	}
	
	/**
	 * Getter for the type of the damage being sent
	 * @return Type of the damage being sent
	 */
	public String getDamageType(){
		return this.damageType;
	}
	
	/**
	 * Getter for the amount of the damage being sent
	 * @return The amount of the damage being sent
	 */
	public int getDamageAmount(){
		return this.damageAmount;
	}
}
