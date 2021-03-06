package game.entities.fields;

import game.boundaries.Outputable;
import game.entities.FieldManager;
import game.entities.Player;

public class Tax extends AbstractField {
	
	private int taxAmount;

	public Tax(FieldManager fieldManager, int taxAmount, Outputable output) {
		super(fieldManager, FieldType.TAX, output);
		this.taxAmount = taxAmount;
	}

	@Override
	public void landOnField(Player player) {
		// If tax is 2000
		
		if(taxAmount == 2000){
			collectTax(2000, player);

		// if tax amount is 4000, player should choose whether to pay 10% of assets or 4000
		}else if(taxAmount == 4000){

			// get total value of all fields owned
			int assets = fieldManager.getFieldsValue(player);
			int totalAssets = assets + player.getBalance();
			int payPercent = (int)Math.round(totalAssets*0.1);

			// ask player whether to pay the ten percent or 4000 kr.
			boolean percent = output.promptTax(player.getName(), taxAmount, payPercent);
			if(percent)
				collectTax(payPercent, player);
			else
				collectTax(taxAmount, player);
		}
	}
	
	/************************************************************
	 * Withdraws an amount of money from the players balance	*
	 ***********************************************************/
	private void collectTax(int amount, Player player){
		player.withdraw(amount);

		output.showWithdrawMessage(player.getName(), amount);
	}
	
	public int getTaxAmount(){
		return this.taxAmount;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", tax=" + taxAmount;
	}
}
