import java.util.Random;

public class Warrior extends Character{

	public Warrior(String name){
		super();
		this.name = name;
		Random rand = new Random();
		this.healthPoints = rand.nextInt(21) + 20;
		this.damageType = "SLASH";
	}
	
	@Override
	public Damage fight(Character[] enemies) {
		Character highestHPFoe = enemies[0];
		// Find foe with largest HP
		if(enemies.length < 1){
			for(Character foe : enemies){
				if(highestHPFoe.getHealthPoints() < foe.getHealthPoints()){
					highestHPFoe = foe;
				}
			}
		}
		Random rand = new Random();
		int slash = rand.nextInt(7) + 10;
		Damage damage = new Damage(highestHPFoe.getName(), this.damageType, slash);
		System.out.println(this.getName() + " " + this.damageType + " " + highestHPFoe.getName() + " for " + slash + " damage");
		return damage;
	}

	@Override
	public void damageRecieved(Damage damage) {
		Random rand = new Random();
		if(damage.getDamageType() == "SLASH" || damage.getDamageType() == "SMASH" && rand.nextInt(4) == 0){
			System.out.println(this.name + " dodged the attack, no damage taken");
		}
		else{
			System.out.println(this.name + " gets " + damage.getDamageType() + " recieving " + damage.getDamageAmount());
			this.setHealthPoints(damage.getDamageAmount());
		}
	}

	@Override
	public String toString() {
		String status = (this.name + " is currently ");
		if(this.getAlive() == true){
			status += ("alive, Health: " + this.getHealthPoints());
		}
		else{
			status += ("dead");
		}
		return status;
	}
}
