
public abstract class Character {
	
	protected String name;
	protected int healthPoints;
	protected String damageType;
	protected boolean alive;
	
	public Character(){
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
	
	public abstract Damage fight(Character[] enemies);
	
	public abstract void damageRecieved(Damage damage);
	
	public abstract String toString();
}
