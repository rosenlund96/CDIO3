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

		}
		}
		
	
	
	private void depositRent(int rent, Ownable owner ){
		
		}
	public void withdrawRent(int rent, Player player){
		int balance = player.getBalance() - rent;
		if(balance > rent)
			player.setBroke(true);
		
	}
	
	@Override
	public int getRent() {
		return 0;
	}

	
}
