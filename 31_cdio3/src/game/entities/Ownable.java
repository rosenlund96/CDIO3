package game.entities;

import game.Boundary.Outputable;

public abstract class Ownable extends Field {

	protected int price;
	protected Player owner;

	public Ownable(FieldManager fm, int price, Outputable output) {
		super(fm, output);
		this.price = price;
	}
	
	@Override
	public void landOnField(Player player){
		//Hvis feltet er ledigt
		if(this.owner == null){
		int balance = player.getBalance();
		if(balance >= price) {
		output.promptBuy(player.getName(), price);
		player.withdraw(price);	
		}
		else {
			output.showNotEnoughBalanceMessage(player);
		}
		}
	}
	
	// fuck det her pis
	public abstract int getRent();
	
}
