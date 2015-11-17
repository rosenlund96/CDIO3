package game.entities;

public abstract class Ownable {

	private int price;
	private Player owner;

	public Ownable(Field field, int price, Player owner) {
		this.price = price;
		this.owner = owner;
	}
	
	
	public int getRent() {
		return getRent();
	}
	
}
