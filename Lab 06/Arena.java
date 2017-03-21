
public class Arena {
	
	private Character[] contestants;
	private int currentSize;
	
	
	public Arena(int numberOfPlayers){
		contestants = new Character[numberOfPlayers];
		currentSize = 0;
	}
	
	public int getCurrentSize(){
		return currentSize;
	}
	
	
	public void addPlayer(Character person){
		// If array is full
		if(currentSize == contestants.length){
			throw new IndexOutOfBoundsException();
		}
		else{
			contestants[currentSize] = person;
			currentSize++;
		}
	}
	
	
	public void removeDead(){
		for(int ii = 0; ii < contestants.length; ii++){
			if(contestants[ii].getAlive() == false){
				System.out.println("Taking " + contestants[ii].getName() + " to the graveyard");
				currentSize--;
				for(int jj = ii; jj < contestants.length; jj++){
					contestants[jj] = contestants[jj + 1];
					if(jj == contestants.length - 1){
						contestants[jj] = null;
					}
				}
			}
		}
	}
	
	
	public void printStatus(){
		for(Character x : contestants){
			System.out.println(x.toString());
		}
	}
	
	// players from 0 to currentSize
	public void takeTurn(int player){
		Character playerTurn = contestants[player];
		Damage damage = playerTurn.fight(contestants);;
		for(int ii = 0; ii < contestants.length; ii++){
			if(damage.getCharacterName().equals(contestants[ii].getName())){
				contestants[ii].damageRecieved(damage);
			}
		}
		
	}
}
