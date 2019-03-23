
public class Player extends GameCharacter{
	private int maxHealth = 100;
	private int socialPoints;
	
	public Player(String name, int socialPoints, int health) {
		super(name, health);
		this.socialPoints = socialPoints;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getSocialPoints() {
		return socialPoints;
	}
	public void reduceSocialPoints(int social) {
		this.socialPoints -= social;
	}
	public void addSocialPoints(int social) {
		this.socialPoints += social;
	}
	
	
	
}
