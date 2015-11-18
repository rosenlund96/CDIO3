package game.entities;

import game.Boundary.Outputable;

public class Territory extends Ownable {
	
	private int rent;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);
		this.rent = rent;
	}

	private void collectRent (int rent, Player player, Player owner){
		if 
		
		//player.transfer (rent, owner);
		
	}
	
	
	public void landOnField(Player player){
		int balance = player.getBalance();
		if(balance > rent)
		withdrawRent(rent);
		depositRent(rent);
		else if(balance < rent){
			owner.depositRent(balance); 
			player.setBalance = 0; 
			player.setBroke(true);
		}
		}
		
	
	
	private void collectRent(int rent, Player player ){
		if(player.withdraw(amount) < amount){
			player.setBroke(true);
		}
	
	@Override
	public int getRent() {
		return 0;
	}

	
}
