import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Enemy e1 = new Enemy("Jason Bourne");
	Enemy e2 = new Enemy("James Bond");
	Enemy e3 = new Enemy("Jack Bauer");
	Enemy e4 = new Enemy("John McClaine");
	Enemy e5 = new Enemy("John Wick");
	Enemy e6 = new Enemy("Indiana Jones");
	Enemy e7 = new Enemy("John Rambo");
	Enemy e8 = new Enemy("Rocky Balboa");
	Neighbor n1 = new Neighbor("your dentist", 40);
	Neighbor n2 = new Neighbor("the bank teller", 30);
	Neighbor n3 = new Neighbor("your gardener", 40);
	Neighbor n4 = new Neighbor("your HOA manager", 50);
	Neighbor n5 = new Neighbor("the pool boy", 40);
	Neighbor n6 = new Neighbor("your babysitter", 20);
	Neighbor n7 = new Neighbor("a hitchhiker", 40);
	Neighbor n8 = new Neighbor("your mother in law", 20);
	GameCharacter tempNeighbor;
	GameCharacter tempEnemy;
	Player p1;


	public void run() {
		System.out.println("You have started");
		System.out.println("What is your player name?");
		String name = sc.nextLine();
		
		System.out.println("On a scale of 1-100, how is your reputation in your neighborhood?");
		int rep = sc.nextInt();
		while(rep < 1 || rep > 100) {
			System.out.println("Whoa try again");
			System.out.println("On a scale of 1-100, how is your reputation in your neighborhood?");
			rep = sc.nextInt();
		}
		
		System.out.println("On a scale of 1-100, how tough are you?");
		int health = sc.nextInt();
		while(health < 1 ||health > 100) {
			System.out.println("Whoa try again");
			System.out.println("On a scale of 1-100, how tough are you?");
			health = sc.nextInt();
		}

		p1 = new Player(name, rep, health);

		System.out.println(
				"Your mission, should you choose to accept it, is to just get home safe with your reputation intact.\nAfter all, you're just an average person.");
		System.out.println("=====>Your journey begins.<=====\n");

		setting();
		boolean alive = true;
		int count = 0;
		while (count < 6) {
			enemyEncounter();
			if(p1.getHealth() <= 0 || p1.getSocialPoints() <= 0) {
				System.out.println("\n=====Ooh noo you didn't make it home intact.=====\n");
				alive = false;
				break;
			}
			casualEncounter();
			if(p1.getHealth() <= 0 || p1.getSocialPoints() <= 0) {
				System.out.println("\n=====Ooh noo you didn't make it home intact.=====\n");
				alive = false;
				break;
			}else if(tempNeighbor.getHealth() <= 0) {
				System.out.println("\n=====Ooh noo you didn't make it home intact.=====\n");
				System.out.println("You went to jail for killing " + tempNeighbor.getName());
				alive = false;
				break;
				
			}
			count++;
		}
		if(alive) {
			System.out.println("You have made it home with " + p1.getHealth() + " health and " + p1.getSocialPoints() + " social points" );
		}

	}

	public void enemyEncounter() {
		int randomEncounter = randomIntGen(6);
		int randomPerson = randomIntGen(8);
		String name = "";
		String s1 = "You just encountered ";
		String s2 = "You have unfortunately encountered ";
		String s3 = "Out of the corner of your eye you see ";
		String s4 = "You were too loud and ";
		String s5 = "You go to Macy's to update your wardrobe but before you arrive ";
		String s6 = "You decide you have time to run by the bank before going home but ";

		String s11 = " and he pushes you down the stairs.";
		String s22 = " and he tries to steal your car.";
		String s33 = " and he narrowly misses you with his fist.";
		String s44 = " hears you and takes your phone. ";
		String s55 = " tries to practice his skills on your face.";
		String s66 = " sees you and needs to take your bike.";
		switch(randomPerson) {
		case 1:
			name = e1.getName();
			tempEnemy = e1;
			break;
		case 2:
			name = e2.getName();
			tempEnemy = e2;
			break;
		case 3: 
			name = e3.getName();
			tempEnemy = e3;
			break;
		case 4:
			name = e4.getName();
			tempEnemy = e4;
			break;
		case 5:
			name = e5.getName();
			tempEnemy = e5;
			break;
		case 6:
			name = e6.getName();
			tempEnemy = e6;
			break;
		case 7: 
			name = e7.getName();
			tempEnemy = e7;
			break;
		case 8:
			name = e8.getName();
			tempEnemy = e8;
			break;
		}
		
		switch(randomEncounter) {
		case 1:
			System.out.println(s1 + name + s11);
			break;
		case 2:
			System.out.println(s2 + name + s22);
			break;
		case 3:
			System.out.println(s3 + name + s33);
			break;
		case 4:
			System.out.println(s4 + name + s44);
			break;
		case 5:
			System.out.println(s5 + name + s55);
			break;
		case 6:
			System.out.println(s6 + name + s66);
			break;
		}
		int choice = choice();
		enemyEncounterOption(choice);

	}

	public void casualEncounter() {
		int randomPerson = randomIntGen(8);
		int randomEncounter = randomIntGen(5);
		String name = "";
		
		String s1 = "On your way home you see ";
		String s2 = "Walking to the pet store you are approached by ";
		String s3 = "In the grocery store ";
		String s4 = "You walk into the bank and ";
		String s5 = "As you are about to take a bite of your crispy croissant ";
		
		
		String s11 = " and they try to ask you something.";
		String s22 = " and they try to bring up old drama.";
		String s33 = " bumps into you with a cart and spills milk everywhere.";
		String s44 = " taps you on your shoulder";
		String s55 = " gets your attention and runs your direction at an alarming rate of speed.";
		
		switch(randomPerson) {
		case 1:
			name = n1.getName();
			tempNeighbor = n1;
			break;
		case 2:
			name = n2.getName();
			tempNeighbor = n2;
			break;
		case 3:
			name = n3.getName();
			tempNeighbor = n3;
		case 4:
			name = n4.getName();
			tempNeighbor = n4;
		case 5:
			name = n5.getName();
			tempNeighbor = n5;
			break;
		case 6:
			name = n6.getName();
			tempNeighbor = n6;
			break;
		case 7:
			name = n7.getName();
			tempNeighbor = n7;
		case 8:
			name = n8.getName();
			tempNeighbor = n8;
		}
		
		switch(randomEncounter) {
		case 1:
			System.out.println(s1 + name + s11);
			break;
		case 2:
			System.out.println(s2 + name + s22);
			break;
		case 3:
			System.out.println(s3 + name + s33);
			break;
		case 4:
			System.out.println(s4 + name + s44);
			break;
		case 5:
			System.out.println(s5 + name + s55);
			break;
		}
		

		
		int choice = choice();
		casualEncounterOption(choice);
	}


	public int choice() {
		System.out.println("What do you want to do? \n1: Attack\n2: Run\n3: Try to talk");
		int choice = sc.nextInt();
		return choice;
	}

	public void setting() {
		int random = randomIntGen(4);
		String s1 = "You get off work a little late but that's ok, You are in no rush";
		String s2 = "You get off work a few minutes early and decide to grab some groceries.";
		String s3 = "It's a typical day in the office and you leave right on time, the day was average.";
		String s4 = "You are walking out of the grocery store with a basket full of the finest poptarts";
		if (random == 1) {
			System.out.println(s1);
		} else if (random == 2) {
			System.out.println(s2);
		} else if (random == 3) {
			System.out.println(s3);
		} else if (random == 4) {
			System.out.println(s4);
		}

	}

	public int randomIntGen(int num) {
		int random = (int) (Math.random() * num + 1);
		return random;
	}

	public void enemyEncounterOption(int choice) {
		int random = (int)(Math.random() * 40 + 10);
		switch (choice) {
		case 1:
			System.out.println(p1.getName() + " tried to attack " + tempEnemy.getName() + " and obviously lost.");
			p1.reduceHealth(random);
			System.out.println("You now have " + p1.getHealth() + " health.\n");
			break;
		case 2:
			System.out.println("You run and you get away with your life but your neighbors aren't too impressed.");
			p1.reduceSocialPoints(random);
			System.out.println("You have " + p1.getSocialPoints() + " social points left because of your cowardice.\n");
			break;
		case 3:
			System.out.println("You try to stand your ground and talk it out but " + tempEnemy.getName() + " is too determined in his mission. "
								+ "Atleast you tried.\n");
			break;
		}
	}

	public void casualEncounterOption(int choice) {
		int random = (int)(Math.random() * 30 + 5);
		switch (choice) {
		case 1:
			if(tempNeighbor.getName().equalsIgnoreCase("a hitchhiker")) {
				System.out.println(p1.getName() + ", you attacked a hitchhiker but surprisingly people are happy about it.");
				p1.addSocialPoints(random);
				System.out.println("You have " + p1.getSocialPoints() + " social points\n");
				break;
			}
			System.out.println("You attack for no reason other than your pride and other people are staring at you.");
			p1.reduceSocialPoints(random);
			tempNeighbor.reduceHealth(random);
			System.out.println("You have " + p1.getSocialPoints() + " social points.");
			System.out.println(tempNeighbor.getName()+ " has " + tempNeighbor.getHealth() + " health as a result of your violence.\n" );
			break;
		case 2:
			System.out.println("You run away, probably from PTSD related to your earlier encounter with " + tempEnemy.getName());
			p1.reduceSocialPoints(random);
			System.out.println("You have " + p1.getSocialPoints() + " social points.\n");
			break;
		case 3:
			System.out.println("You make sweet conversation with " + tempNeighbor.getName() + " and your social points go up.");
			p1.addSocialPoints(random/2);
			System.out.println(p1.getName() + ", you have " + p1.getSocialPoints() + " social points.\n");
		}
		 
	}
}
