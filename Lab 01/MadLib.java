package com.CS136L.Lab;

import java.util.Scanner;

public class MadLib {
	public static void main (String[] args){
		//Variables
		String noun;
		String adjective;
		String jobTitle;
		String pronoun;
		String verb1;
		String inanimateObject;
		String monster;
		String liquid;
		String verb2;
		String distance;
		String size;
		String attackName;
		
		//Input
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Input a Noun: ");
		noun = reader.nextLine();
		
		System.out.print("Input a Adjective: ");
		adjective = reader.nextLine();
		
		System.out.print("Input a Job Title: ");
		jobTitle = reader.nextLine();
		
		System.out.print("Input a Pronoun: ");
		pronoun = reader.nextLine();
		
		System.out.print("Input a Verb: ");
		verb1 = reader.nextLine();
		
		System.out.print("Input a Inanimate Object: ");
		inanimateObject = reader.nextLine();
		
		System.out.print("Input a Monster: ");
		monster = reader.nextLine();
		
		System.out.print("Input a Liquid: ");
		liquid = reader.nextLine();
		
		System.out.print("Input a Verb: ");
		verb2 = reader.nextLine();
		
		System.out.print("Input a Distance: ");
		distance = reader.nextLine();
		
		System.out.print("Input a Size: ");
		size = reader.nextLine();
		
		System.out.print("Input a Attack Name: ");
		attackName = reader.nextLine();
		
		reader.close();
		
		//Output
		System.out.println("\n My First MadLib Story");
		System.out.println("=========================");
		System.out.println("Once upon a time there was a " + noun + " who was a(n) " + adjective +
				"\n" + jobTitle + ". One day, the " + noun + " received a letter instructing " + pronoun + 
				"\nto " + verb1 + " the dragon protecting the " + inanimateObject + ". This was quite strange, as " + noun + 
				"\nhas never " + verb1 + " or even seen a dragon before. Despite that, " + noun + " went on " + pronoun + "’s," +
				"\nmerry way to the dragon, but was accosted by a " + monster + ". " + noun + " flung his " + liquid + " at the " + monster +
				"\nmaking the " + monster + " five times larger and hungry. " + noun + " tried to run away, only to be " + verb2 +
				"\nby the " + monster + ", which " + noun + " enjoyed. " + noun + " then used his skills as a(n) " + adjective +
				"\n" + jobTitle + " to " + verb2 + " the Monster to put it to sleep. " + noun + " then traveled " + distance +
				"\nto encounter the dragon, who turned out to be a " + size + " dragon. " + noun + 
				"\nthen to use his most powerful attack, " + attackName + ", but was burnt to a crisp by the dragon." + 
				"\n" + noun + "’s crispy body then fell into a lake of " + liquid + "," + " and here " + noun + "’s journey ends.");
	}
}
