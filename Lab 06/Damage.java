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
	
	public Damage(String fromCharacter, String attackCharacter, String damageType, int damageAmount){
		this.fromCharacter = fromCharacter;
		this.attackCharacter = attackCharacter;
		this.damageType = damageType;
		this.damageAmount = damageAmount;
	}
	
	public String getFromCharacterName(){
		return this.fromCharacter;
	}
	
	public String getAttackCharacterName(){
		return this.attackCharacter;
	}
	
	public String getDamageType(){
		return this.damageType;
	}
	
	public int getDamageAmount(){
		return this.damageAmount;
	}
}
