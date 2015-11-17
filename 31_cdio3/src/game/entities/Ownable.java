package game.entities;

public abstract class Ownable extends Field {

	protected int price;
	protected Player owner;

	public Ownable(int price) {
		super();
		this.price = price;
	}
	
	public abstract int getRent();
	
}
