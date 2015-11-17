package game.entities;

public class Tax extends Field {

	double taxRate = -1;
	int taxAmount;
	
	
	public Tax(FieldManager fm, String fieldType, double taxRate, int taxAmount) {
		super(fm, fieldType);
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}








	@Override
	public void landOnField(Player activePlayer) {
		if(fieldType == Tax1){
			taxAmount = 2000;
			activePlayer.changeBalance(taxAmount);
		}
		else {
			taxAmount = 4000; 
			taxRate = activePlayer.getBalance()*0.1; 
		}
		

}
}
