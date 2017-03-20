import java.util.Random;

public class test {
	public static void main(String[] args){
		/*
		Random rand = new Random();
		while(true){
			//int healthPoints = rand.nextInt(21) + 20;
			System.out.println(rand.nextInt(4));
		}*/
		
		Warrior john = new Warrior("John");
		Warrior bob = new Warrior("Bob");
		Warrior shawn = new Warrior("Shawn");
		
		Queue x = new Queue(4);
		x.enqueue(john);
		x.enqueue(bob);
		x.enqueue(shawn);
		
		Character attacker;
		Character victim1;
		Character victim2;
		while(x.size() != 1){
			attacker = x.dequeue();
			// Attacker finds opponent
			for(int ii = 0; ii < x.size(); ii++){
				victim1 = x.dequeue();
				victim2 = x.dequeue();
			}
		}
		
		
		
		
		/*
		Character[] contestants = {john, bob, shawn};
		
		for(Character foe : contestants){
			Damage damage = foe.fight(contestants);
			for(Character find : contestants){
				if(find.getName().equals(damage.getCharacterName())){
					find.damageRecieved(damage);
					System.out.println(find.toString());
				}
			}
			
			for(Character dead: contestants){
				if(dead.getAlive() == false){
					dead = null;
					
				}
			}
		}*/
		
		
		/*
		Queue x = new Queue(4);
		x.enqueue(john);
		x.enqueue(bob);
		x.enqueue(shawn);
		
		System.out.println(x.toString());
		
		System.out.println(x.size());
		System.out.println(x.dequeue());
		System.out.println(x.size());
		System.out.println(x.dequeue());
		System.out.println(x.size());
		System.out.println(x.dequeue());
		System.out.println(x.size());*/
	}
}
