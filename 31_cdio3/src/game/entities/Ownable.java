package game.entities;

public abstract class Ownable extends Field {

	protected int price;
	protected Player owner;

	public Ownable(FieldManager fm, int price, Outputable output) {
		super(fm, output);
		this.price = price;
	}
	
	
	public abstract int getRent();
	
}
