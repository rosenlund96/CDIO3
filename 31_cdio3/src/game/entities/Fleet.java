package game.entities;

import game.Boundary.Outputable;


public class Fleet extends Ownable {

	private static final int RENT_1 = 500;
	private static final int RENT_2 = 1000;
	private static final int RENT_3 = 2000;
	private static final int RENT_4 = 4000;
	
	public Fleet(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);
		
	}



	@Override
	public void landOnField (Player Player) {
			for (int player = 0; player < Board.getNumberOfPlayers(); player++) {
			fieldManager.getFieldsOwned(player, fieldType.FLEET);
			}
		}
	
	
	@Override
	public int getRent() {
		return 0;
	}

	
	
	
}
