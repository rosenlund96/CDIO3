package game.entities;

import game.Boundary.Outputable;
import game.util.DieCup;

public class LaborCamp extends Ownable {
	
	private int baseRent;
	private int dieSum;

	public LaborCamp(FieldManager fm, int price, int baseRent, int dieSum, Outputable output ) {
		super(fm,price, baseRent, output);
		this.baseRent = baseRent;
		this.dieSum = DieCup.getSum();
	}

	
	public void landOnField(Player player){
		dieSum = DieCup.getSum();
		baseRent = 100; 
		int fieldsOwned = FieldManager.getFieldsOwned(owner, fieldType.LABOR_CAMP);
		int amountToPay = dieSum * baseRent * fieldsOwned; 
		transferRent(amountToPay, player, owner);
	
	}
	
	public void transferRent(int amountToPay, Player player, Player owner){
		if(player.getBalance()>amountToPay){
			player.withdraw(amountToPay);
			owner.deposit(amountToPay);
			output.showTransferMessageSucces(owner, amountToPay);
			
		}
		else if(player.getBalance()< amountToPay){
			player.withdraw(player.getBalance());
			owner.deposit(player.getBalance());
			player.setBroke(true);
			output.showTransferMessageFailed(owner, amountToPay);
		}
	}
	
	
	
	@Override
	public int getRent() {
		return 0;
	}
	
	

}
