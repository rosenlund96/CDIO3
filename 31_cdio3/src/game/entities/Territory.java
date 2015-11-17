package game.entities;

public class Territory extends Ownable {
	
	private int rent;

	public Territory(int price, int rent) {
		super(price);
		this.rent = rent;
	}

	@Override
	public int getRent() {
		return 0;
	}

}
