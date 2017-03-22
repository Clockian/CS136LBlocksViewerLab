/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a Warrior that is a RPGCharacter
*/
import java.util.Random;

public class Warrior extends RPGCharacter{

	public Warrior(String name){
		super();
		this.name = name;
		this.rpgClass = "Warrior";
		Random rand = new Random();
		this.healthPoints = rand.nextInt(21) + 20;
		this.damageType = "SLASH";
	}
	
	//inputted array includes self
	@Override
	public Damage fight(RPGCharacter[] contestants, int numberOfPlayers) {
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
		Random rand = new Random();
		int slash = rand.nextInt(7) + 10;
		Damage damage = new Damage(this.name, highestHPFoe.getName(), this.damageType, slash);
		System.out.println(this.getName() + " " + this.damageType + " " + highestHPFoe.getName() + " for " + slash + " damage");
		return damage;
	}

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

	@Override
	public Damage whenKilled(Damage damage) {
		return null;
	}
}
