package game.entities;

public class LaborCamp extends Ownable {
	
	private int baseRent;

	public LaborCamp(int baseRent, int price) {
		super(price);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent() {
		return 0;
	}
	
	

}
