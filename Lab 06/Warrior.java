import java.util.Random;

public class Warrior extends Character{

	public Warrior(String name){
		super();
		this.name = name;
		Random rand = new Random();
		this.healthPoints = rand.nextInt(21) + 20;
		this.damageType = "SLASH";
	}
	
	//inputted array includes self
	@Override
	public Damage fight(Character[] contestants) {
		Character highestHPFoe;
		if(!this.getName().equals(contestants[0].getName())){
			highestHPFoe = contestants[0];
		}
		else{
			highestHPFoe = contestants[1];
		}
				
		// Find foe with largest HP
		if(contestants.length < 1){
			for(Character foe : contestants){
				// if self, don't fight, skip if tree and move onto next foe
				if(this.getName().equals(foe.getName())){
					// else, if foe is bigger than current, get foe
					if(highestHPFoe.getHealthPoints() < foe.getHealthPoints()){
						highestHPFoe = foe;
					}
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
		int dodgeChance = rand.nextInt(4);
		if((damage.getDamageType() == "SLASH" || damage.getDamageType() == "SMASH") && dodgeChance == 0){
			System.out.println(this.name + " dodged the attack, no damage taken");
		}
		else{
			System.out.println(this.name + " gets " + damage.getDamageType() + " recieving " + damage.getDamageAmount());
			this.setHealthPoints(this.getHealthPoints() - damage.getDamageAmount());
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
