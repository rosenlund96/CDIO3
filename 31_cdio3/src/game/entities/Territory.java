package game.entities;

import game.Boundary.Outputable;

public class Territory extends Ownable {
	
	private int rent;
	private int rentAmount;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);
		this.rent = rent;
	}	
	
	public void landOnField(Player player){
		int balance = player.getBalance();
		if(balance >= rent)
		owner.deposit(player.withdraw(rent));
//		withdrawRent(rent, player);
//		depositRent(rent);
		else if(balance < rent){
			depositRent(balance); 
			player.setBalance = 0; 
			player.setBroke(true);
		}
		}
		
	private void withdrawRent (int rentAmount, Player player) {
		player.withdraw(rentAmount);
	}
	
	private void depositRent (int rentAmount) {
		owner.deposit(rentAmount);
	}
	
	// Skal nok ikke bruges
//	private void collectRent(int rent, Player player ){
//		if(player.withdraw(amount) < amount){
//			player.setBroke(true);
//		}
	
	@Override
	public int getRent() {
		return 0;
	}

	@Override 
	public Player getOwner() {
		return owner;
	}
	
}
