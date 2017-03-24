/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a Warrior that is a RPGCharacter
*/
import java.util.Random;

public class Warrior extends RPGCharacter{

	/**
	 * Default constructor for a Warrior
	 * @param name - The unique name for the Warrior
	 */
	public Warrior(String name){
		super();
		this.name = name;
		this.rpgClass = "Warrior";
		Random rand = new Random();
		this.healthPoints = rand.nextInt(21) + 20;
		this.damageType = "SLASH";
	}
	
	
	/**
	 * Attacks a contestants with a slash, can't hit self
	 * @param contestants - Players who are currently in the arena
	 * @param numberOfPlayers - The number of players who are currently alive
	 */
	@Override
	public void fight(RPGCharacter[] contestants, int numberOfPlayers) {
		// Find character with highest HP
		RPGCharacter highestHPFoe = this.findHighestHP(contestants, numberOfPlayers);
		
		// Create and print attack
		Random rand = new Random();
		int slash = rand.nextInt(7) + 10;
		Damage damage = new Damage(this.name, highestHPFoe.getName(), this.damageType, slash);
		System.out.println(this.getName() + " " + this.damageType + " " + highestHPFoe.getName() + " for " + slash + " damage");
		
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
	 * Finds the character with the largest HP in list that is not self
	 * @param contestants - Players who are currently in the arena
	 * @param numberOfPlayers - The number of players who are currently alive
	 * @return The RPGCharacter with the largest HP that is not self
	 */
	private RPGCharacter findHighestHP(RPGCharacter[] contestants, int numberOfPlayers){
		RPGCharacter highestHPFoe;
		if(!this.getName().equals(contestants[0].getName())){
			highestHPFoe = contestants[0];
		}
		else{
			highestHPFoe = contestants[1];
		}
				
		// Find foe with largest HP
		for(int ii = 0; ii < numberOfPlayers; ii++){
			// if self, don't fight, skip if tree and move onto next foe
			if(!this.getName().equals(contestants[ii].getName())){
				// else, if foe is bigger than current, get for
				if(highestHPFoe.getHealthPoints() < contestants[ii].getHealthPoints()){
					highestHPFoe = contestants[ii];
				}
			}
		}
		return highestHPFoe;
	}

	
	/**
	 * To handle what happens when character receives damage, can dodge the attack
	 * @param damage - The damage the character takes
	 */
	@Override
	public void damageReceived(Damage damage) {
		Random rand = new Random();
		int dodgeChance = rand.nextInt(4);
		if((damage.getDamageType() == "SLASH" || damage.getDamageType() == "SMASH") && dodgeChance == 0){
			System.out.println(this.name + " dodged the attack, no damage taken");
		}
		else{
			System.out.println(this.name + " gets " + damage.getDamageType() + " receiving " + damage.getDamageAmount());
			this.setHealthPoints(this.getHealthPoints() - damage.getDamageAmount());
		}
	}
}
