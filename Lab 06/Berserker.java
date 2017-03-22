/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class creates a Berserker that is a RPGCharacter
*/
import java.util.Random;

public class Berserker extends RPGCharacter{

	public Berserker(String name){
		super();
		this.name = name;
		this.rpgClass = "Berserker";
		this.healthPoints = 35;
		this.damageType = "SMASH";
	}
	
	@Override
	public Damage fight(RPGCharacter[] enemies, int numberOfPlayers) {
		Random rand = new Random();
		RPGCharacter foe = enemies[rand.nextInt(numberOfPlayers)];
		System.out.println(this.getName() + " " + this.damageType + " " + foe.getName() + " for " + 20 + " damage");
		Damage damage = new Damage(this.name, foe.name, this.damageType, 20);
		return damage;
	}

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

	@Override
	public Damage whenKilled(Damage damage) {
		return null;
	}
}
