
public class Arena {
	
	private RPGCharacter[] contestants;
	private int currentSize;
	
	
	public Arena(int numberOfPlayers){
		contestants = new RPGCharacter[numberOfPlayers];
		currentSize = 0;
	}
	
	public int getCurrentSize(){
		return currentSize;
	}
	
	
	public void addPlayer(RPGCharacter person){
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
		for(int ii = 0; ii < currentSize; ii++){
			if(contestants[ii].getAlive() == false){
				System.out.println("Taking " + contestants[ii].getName() + " to the graveyard");
				currentSize--;
				for(int jj = ii; jj < contestants.length-1; jj++){
					contestants[jj] = contestants[jj + 1];
					if(jj == contestants.length - 1){
						contestants[jj] = null;
					}
				}
			}
		}
	}
	
	
	public void printStatus(){
		for(int ii = 0; ii < currentSize; ii++){
			System.out.println(contestants[ii].toString());
		}
	}
	
	// players from 0 to currentSize
	public void takeTurn(int player){
		RPGCharacter playerTurn = contestants[player];
		Damage damage = playerTurn.fight(contestants);
		for(int ii = 0; ii < currentSize; ii++){
			if(damage.getCharacterName().equals(contestants[ii].getName())){
				contestants[ii].damageReceived(damage);
			}
		}
		
	}
	
	public void determineWinner(){
		if(currentSize <= 1){
			System.out.println("The winner is " + contestants[0].getName());
		}
	}
}
