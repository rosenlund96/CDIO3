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
	public void landOnField (Player player) {
			int fieldsOwned = fieldManager.getFieldsOwned(player, FieldType.FLEET);
			if (fieldsOwned == 1){
				transferRent(RENT_1, player, owner);
			}
			else if(fieldsOwned == 2){
				transferRent(RENT_2, player, owner);
			}
			else if(fieldsOwned == 3){
				transferRent(RENT_3, player, owner);
			}
			else if(fieldsOwned == 4){
				transferRent(RENT_4, player, owner);
			}
			
		}
	
	
	public void transferRent(int rentAmount, Player player, Player owner){
		if (player.getBalance()>=rent) {
		player.withdraw(rentAmount);
		owner.deposit(rentAmount);
		output.showLandOnOwnedFieldMessage(rentAmount, owner);
		}
		else if(player.getBalance() < rent){
			owner.deposit(player.getBalance());
			player.withdraw(player.getBalance());
			player.setBroke(true);
			output.showBrokeMessage(owner, rent, player.getBalance());
	}
	}
	
	
	
	
	@Override
	public int getRent() {
		return 0;
	}

	
	
	
}
