package game.entities;

public class Fleet extends Ownable {

	private static final int RENT_1 = 500;
	private static final int RENT_2 = 1000;
	private static final int RENT_3 = 2000;
	private static final int RENT_4 = 4000;
	
	public Fleet(int price) {
		super(price);
		this.RENT_1 = RENT_1;
		this.RENT_2 = RENT_2;
		this.RENT_3 = RENT_3;
		this.RENT_4 = RENT_4;
	}

	@Override
	public int getRent() {
		return 0;
	}
	
	
	
}
