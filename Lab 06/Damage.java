
public class Damage {
	
	private String characterName;
	private String damageType;
	private int damageAmount;
	
	public Damage(String characterName, String damageType, int damageAmount){
		this.characterName = characterName;
		this.damageType = damageType;
		this.damageAmount = damageAmount;
	}
	
	public String getCharacterName(){
		return this.characterName;
	}
	
	public String getDamageType(){
		return this.damageType;
	}
	
	public int getDamageAmount(){
		return this.damageAmount;
	}
}
