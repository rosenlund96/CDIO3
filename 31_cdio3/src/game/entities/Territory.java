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
		output.showLandOnOwnedFieldMessage(rent, owner);	
		owner.deposit(player.withdraw(rent));
		else if(balance < rent){
			depositRent(balance); 
			player.setBalance = 0; 
			player.setBroke(true);
			output.showBrokeMessage(owner, rent, balance);
		}
		}
	
	public void transferRent(int rentAmount, Player player, Player owner){
		player.withdraw(rentAmount);
		owner.deposit(rentAmount);
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
