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
	public abstract void landOnField(Player player){
		//Hvis feltet er ledigt
		int playerBalance = player.getBalance();
		output.promptBuy(player.getName(), price);
		
		
		
		
		
		
		//Hvis feltet er ejet.
	}
	
	
	public abstract int getRent();
	
}
