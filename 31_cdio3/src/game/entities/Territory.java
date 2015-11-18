package game.entities;

public class Territory extends Ownable {
	
	private int rent;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, output);
		this.rent = rent;
	}

	@Override
	public int getRent() {
		return 0;
	}

	
}
