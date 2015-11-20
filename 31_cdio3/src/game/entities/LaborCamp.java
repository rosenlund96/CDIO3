package game.entities;

import game.Boundary.Outputable;
import game.entities.Field.FieldType;
import game.util.DieCup;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	private int dieSum;
	private DieCup dices;
	
	public LaborCamp(FieldManager fm, int price, int baseRent, Outputable output ) {
		super(fm,price, baseRent, output);
		this.baseRent = baseRent;
		dices = new DieCup();
	}

	
	public void landOnField(Player player){
		if (this.owner == null) {
			super.landOnField(player);
		}
		else if (this.owner != player) {
		int fieldsOwned = fieldManager.getFieldsOwned(player, FieldType.LABOR_CAMP);
		int amountToPay = dieSum * baseRent * fieldsOwned; 
		transferRent(amountToPay, player, owner);
		}
		else if (this.owner == player) {
			output.youOwnThisFieldMessage(owner);
			
		}
	}
	
	public void transferRent(int amountToPay, Player player, Player owner){
		if(player.getBalance()>amountToPay){
			player.withdraw(amountToPay);
			owner.deposit(amountToPay);
			
		}
		else if(player.getBalance()< amountToPay){
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
