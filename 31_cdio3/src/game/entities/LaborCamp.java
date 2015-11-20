package game.entities;

import game.Boundary.Outputable;
import game.util.DieCup;

public class LaborCamp extends Ownable {

	private int baseRent;
	private DieCup dices;
	private int amountPayed;

	public LaborCamp(FieldManager fm, int price, int baseRent, Outputable output ) {
		super(fm,price, baseRent, output);
		this.baseRent = baseRent;
		dices = new DieCup();
	}

	// checks if the field is owned 
	public void landOnField(Player player){
		if (this.owner == null) {
			super.landOnField(player);
		}
		// checks if the player is the owner 
		else if (this.owner != player) {
			int fieldsOwned = fieldManager.getFieldsOwned(player, FieldType.LABOR_CAMP);
			dices.roll();
			int amountToPay = dices.getSum() * baseRent * fieldsOwned; 
			transferRent(amountToPay, player);
		}
		// checks if the player is the owner
		else if (this.owner == player) {
			output.youOwnThisFieldMessage(owner);

		}
	}
	// method to transfer money from the player to the owner of the field
	public void transferRent(int amountToPay, Player player){
		// withdraws the due rent or the rest of the players balance if he/she can't afford it 
		amountPayed = player.withdraw(amountToPay);
		// deposits the withdrawed money
		owner.deposit(amountPayed);
		output.showLandOnOwnedFieldMessage(amountPayed, owner);
	}

	@Override
	public int getRent() {
		return rent;
	}



}
