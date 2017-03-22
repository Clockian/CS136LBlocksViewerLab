
public class RPGMain {
	public static void main(String[] args){
		Warrior bob = new Warrior("Bob");
		Warrior john = new Warrior("John");
		Warrior shawn = new Warrior("Shawn");
		Warrior pat = new Warrior("Pat");
		
		Arena arena = new Arena(4);
		
		arena.addPlayer(bob);
		arena.addPlayer(john);
		arena.addPlayer(shawn);
		arena.addPlayer(pat);
		
		int turn = 0;
		
		while(arena.getCurrentSize() > 1){
			arena.printStatus();
			System.out.println();
			arena.takeTurn(turn);
			
			
			System.out.println();
			arena.removeDead();
			System.out.println();
			arena.determineWinner();
			
			if(turn < arena.getCurrentSize() - 1){
				turn++;
			}
			else{
				turn = 0;
			}
			System.out.println("----------------------");
		}
	}
}
