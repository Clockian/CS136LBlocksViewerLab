
public class RPGMain {
	public static void main(String[] args){
		Warrior bob = new Warrior("bob");
		Warrior john = new Warrior("john");
		Warrior shawn = new Warrior("shawn");
		Warrior pat = new Warrior("pat");
		
		Arena arena = new Arena(4);
		
		arena.addPlayer(bob);
		arena.addPlayer(john);
		arena.addPlayer(shawn);
		arena.addPlayer(pat);
		
		int turn = 0;
		
		while(arena.getCurrentSize() != 1){
			arena.printStatus();
			System.out.println();
			arena.takeTurn(turn);
			System.out.println();
			if(turn < arena.getCurrentSize() - 1){
				turn++;
			}
			else{
				turn = 0;
			}
			System.out.println();
			arena.removeDead();
		}
	}
}
