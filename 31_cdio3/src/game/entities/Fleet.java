package game.entities;

import game.boundaries.Outputable;

public class Fleet extends Ownable {

	private static final int RENT_1 = 500;
	private static final int RENT_2 = 1000;
	private static final int RENT_3 = 2000;
	private static final int RENT_4 = 4000;

	public Fleet(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);

	}

	@Override
	public void landOnField (Player player) {
		if (owner == null)
			super.landOnField(player);
		else if (player != owner){
			int fieldsOwned = fieldManager.getFieldsOwned(owner, FieldType.FLEET);
			if (fieldsOwned == 1){
				transferRent(RENT_1, player);
			}
			else if(fieldsOwned == 2){
				transferRent(RENT_2, player);
			}
			else if(fieldsOwned == 3){
				transferRent(RENT_3, player);
			}
			else if(fieldsOwned == 4){
				transferRent(RENT_4, player);
			}
		}
	}


	public void transferRent(int rentAmount, Player player){
		int amount = player.withdraw(rentAmount);
		owner.deposit(amount);
		output.showLandOnOwnedFleetMessage(amount, owner, player);
	}


	@Override
	public int getRent() {
		return rent;
	}

}
