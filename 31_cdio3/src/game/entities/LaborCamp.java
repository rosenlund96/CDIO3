package game.entities;

public class LaborCamp extends Ownable {
	
	private int baseRent;

	public LaborCamp(FieldManager fm, int price, int baseRent, Outputable output ) {
		super(fm,price, output);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent() {
		return 0;
	}
	
	

}
