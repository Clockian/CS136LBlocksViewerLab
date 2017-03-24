/*
 * Created by Jasque Saydyk and Niki Shirey
 * Lab 06 - RPG
 * CS 136L Section 3801
 * 21 March 2017
 * Description - This class runs the main program
*/
public class RPGMain {
	public static void main(String[] args){
		RPGCharacter bob = new Warrior("Bob");
		RPGCharacter john = new Warrior("John");
		RPGCharacter shawn = new Berserker("Shawn");
		RPGCharacter pat = new Berserker("Pat");
		RPGCharacter ron = new WildMage("Ron");
		RPGCharacter eli = new WildMage("Eli");
		
		Arena arena = new Arena(6);
		
		arena.addPlayer(bob);
		arena.addPlayer(john);
		arena.addPlayer(shawn);
		arena.addPlayer(pat);
		arena.addPlayer(ron);
		arena.addPlayer(eli);
		
		int turn = 0;
		
		// Game loop
		while(arena.getCurrentPlayerCount() > 1){
			// Print current state of contestants
			arena.printStatus();
			System.out.println();
			
			// Have a contestant fight
			arena.takeTurn(turn);
			System.out.println();
			
			// Remove any dead people from the arena
			int deadRemoved = arena.removeDead(turn);
			System.out.println();
			
			// Check if there is a winner
			arena.determineWinner();
			
			// Remove dead from turn counter
			if(deadRemoved > 0){
				turn = turn - deadRemoved;
			}
			
			// Advance turn counter to next player
			if(turn < arena.getCurrentPlayerCount() - 1){
				turn++;
			}
			else{
				turn = 0;
			}
			
			System.out.println("----------------------");
		}
	}
}
