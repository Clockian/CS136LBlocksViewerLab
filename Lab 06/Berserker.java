/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a Berserker that is a RPGCharacter
*/
import java.util.Random;

public class Berserker extends RPGCharacter{

	/**
	 * Default constructor for a Berserker
	 * @param name - The unique name for the Berserker
	 */
	public Berserker(String name){
		super();
		this.name = name;
		this.rpgClass = "Berserker";
		this.healthPoints = 35;
		this.damageType = "SMASH";
	}
	
	/**
	 * Attacks a contestant with a smash attack randomly, can hit self
	 * @param contestants - Players who are currently in the arena
	 * @param numberOfPlayers - The number of players who are currently alive
	 */
	@Override
	public void fight(RPGCharacter[] contestants, int numberOfPlayers) {
		Random rand = new Random();
		RPGCharacter foe = contestants[rand.nextInt(numberOfPlayers)];
		System.out.println(this.getName() + " " + this.damageType + " " + foe.getName() + " for " + 20 + " damage");
		Damage damage = new Damage(this.name, foe.name, this.damageType, 20);
		
		// Find opponent and deal damage
		for(int ii = 0; ii < numberOfPlayers; ii++){
			if(damage.getAttackCharacterName().equals(contestants[ii].getName())){
				contestants[ii].damageReceived(damage);
				
				// If receiving player dies, he does his final move
				Damage retaliate = contestants[ii].whenKilled(damage);
				if(retaliate != null){
					this.damageReceived(retaliate);
				}
			}
		}
	}

	/**
	 * To handle what happens when character receives damage
	 * @param damage - The damage the character takes
	 */
	@Override
	public void damageReceived(Damage damage) {
		int hit;
		if(damage.getDamageType().equals("SLASH")){
			hit = damage.getDamageAmount() * 2;
			this.setHealthPoints(this.getHealthPoints() - hit);
		}
		else if(damage.getDamageType().equals("FIRE")){
			hit = damage.getDamageAmount() / 2;
			this.setHealthPoints(this.getHealthPoints() - hit);
		}
		else{
			hit = damage.getDamageAmount();
			this.setHealthPoints(this.getHealthPoints() - hit);
		}
		System.out.println(this.name + " gets " + damage.getDamageType() + " receiving " + hit);
	}
}
