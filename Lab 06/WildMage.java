/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a WildMage that is a RPGCharacter
*/
import java.util.Random;

public class WildMage extends RPGCharacter{

	/**
	 * Default constructor for a Wild Mage
	 * @param name - The unique name for the Wild Mage
	 */
	public WildMage(String name){
		super();
		this.name = name;
		this.rpgClass = "Wild Mage";
		Random rand = new Random();
		this.healthPoints = rand.nextInt(51) + 10;
		this.damageType = "FIRE";
	}
	
	
	/**
	 * Attacks all contestants with a small amount for fire damage
	 * @param contestants - Players who are currently in the arena
	 * @param numberOfPlayers - The number of players who are currently alive
	 */
	@Override
	public void fight(RPGCharacter[] contestants, int numberOfPlayers) {
		Random rand = new Random();
		System.out.println(this.getName() + " FIRE at everyone");
		
		for(int ii = 0; ii < numberOfPlayers; ii++){
			int hit = rand.nextInt(7);
			Damage damage = new Damage(this.name, contestants[ii].getName(), this.damageType, hit);
			contestants[ii].damageReceived(damage);
			
			// If receiving player dies, he does his final move
			Damage retaliate = contestants[ii].whenKilled(damage);
			if(retaliate != null){
				this.damageReceived(retaliate);
			}
		}
	}

	
	/**
	 * To handle what happens when character receives damage
	 * @param damage - The damage the character takes
	 */
	@Override
	public void damageReceived(Damage damage) {
		System.out.println(this.name + " gets " + damage.getDamageType() + " receiving " + damage.getDamageAmount());
		this.setHealthPoints(this.getHealthPoints() - damage.getDamageAmount());
	}

	
	/**
	 * Any special actions when this character is killed
	 * @param damage - The damage last done to the character to determine who attacked
	 * @return Damage to the player who did the finishing blow
	 */
	@Override
	public Damage whenKilled(Damage damage) {
		if(this.getAlive() == false){
			return new Damage(this.name, damage.getFromCharacterName(), this.damageType, 5);
		}
		return null;
	}
}
