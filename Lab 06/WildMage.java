/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a WildMage that is a RPGCharacter
*/
import java.util.Random;

public class WildMage extends RPGCharacter{

	public WildMage(String name){
		super();
		this.name = name;
		this.rpgClass = "Wild Mage";
		Random rand = new Random();
		this.healthPoints = rand.nextInt(51) + 10;
		this.damageType = "FIRE";
	}
	
	/**
	 * See Arena takeTurn method for how this is implemented. That is a ghetto solution due to lack of time
	 */
	@Override
	public Damage fight(RPGCharacter[] enemies, int numberOfPlayers) {
		return null;
	}

	@Override
	public void damageReceived(Damage damage) {
		System.out.println(this.name + " gets " + damage.getDamageType() + " receiving " + damage.getDamageAmount());
		this.setHealthPoints(this.getHealthPoints() - damage.getDamageAmount());
	}

	@Override
	public Damage whenKilled(Damage damage) {
		if(this.getAlive() == false){
			return new Damage(this.name, damage.getFromCharacterName(), this.damageType, 5);
		}
		return null;
	}

}
