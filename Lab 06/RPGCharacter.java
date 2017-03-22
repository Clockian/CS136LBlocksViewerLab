
public abstract class RPGCharacter {
	
	protected String name;
	protected String rpgClass;
	protected int healthPoints;
	protected String damageType;
	protected boolean alive;
	
	public RPGCharacter(){
		alive = true;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getHealthPoints(){
		return this.healthPoints;
	}
	
	public void setHealthPoints(int health){
		healthPoints = health;
		if(healthPoints <= 0){
			alive = false;
		}
	}
	
	public boolean getAlive(){
		return this.alive;
	}
	
	public abstract Damage fight(RPGCharacter[] enemies);
	
	public abstract void damageReceived(Damage damage);
	
	public abstract String toString();
}
