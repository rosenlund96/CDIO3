package game.entities;

public class Fleet extends Ownable {

	private static final int RENT_1 = 500;
	private static final int RENT_2 = 1000;
	private static final int RENT_3 = 2000;
	private static final int RENT_4 = 4000;
	
	public Fleet(int price) {
		super(price);

	}

	@Override
	public void LandOnField (Player Player) {
		
	}
	
	@Override
	public int getRent() {
		return 0;
	}

	
	
	
}
