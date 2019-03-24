
public class GameCharacter {
	private int health;
	private String name;


	public GameCharacter(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	public void reduceHealth(int health) {
		this.health -= health;
	}
	
	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}
	
	
}
