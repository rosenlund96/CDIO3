package game.entities;

import game.Boundary.Outputable;

public class Tax extends Field {

	int taxAmount;



	public Tax(FieldManager fm, int taxAmount, Outputable output) {
		super(fm, FieldType.TAX, output);
		this.taxAmount = taxAmount;
	}



	@Override
	public void landOnField(Player player) {
		// If tax is 2000
		if(taxAmount == 2000){
			collectTax(2000, player);
		}else if(taxAmount == 4000){
			int value = fieldManager.getFieldsValue(player);
			int balance = player.getBalance();
			int totalAssets = value + balance;
			int pay10 = (int)Math.round(totalAssets*0.1);
			
			boolean percent = output.promptTax(player.getName(), taxAmount, pay10);
			if(percent)
				collectTax(pay10, player);
			else
				collectTax(taxAmount, player);
			
		}


	}
	
	private void collectTax(int amount, Player player){
		if(player.withdraw(amount) < amount){
			player.setBroke(true);
		}
		output.showWithdrawMessage(player.getName(), amount);
	}
	
}
