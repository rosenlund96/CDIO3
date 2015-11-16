package game.entities;

public class Tax extends Field {

	double taxRate = -1;
	int taxAmount;
	
	

	public Tax(String name, int activePlayerPos, int taxRate, int taxAmount) {
		super(name, activePlayerPos);
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
	}

	@Override
	public void landOnField(Player activePlayer) {
		if(Field[16]){
			taxAmount = 2000;
		}
		else if(Field[17]){
			taxAmount = 4000; 
			taxRate = activePlayer.getBalance()*0.1; 
		}
		

}
}
