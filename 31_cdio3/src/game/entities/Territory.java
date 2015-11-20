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
		transferRent(rent, player, owner);
		}
		
	
	public void transferRent(int rentAmount, Player player, Player owner){
		if (player.getBalance()>=rent) {
		player.withdraw(rentAmount);
		owner.deposit(rentAmount);
		}
		else if(balance < rent){
			depositRent(balance); 
			player.setBalance = 0; 
			player.setBroke(true);
			output.showBrokeMessage(owner, rent, balance);
	}
		
	
	
	@Override
	public int getRent() {
		return 0;
	}

	@Override 
	public Player getOwner() {
		return owner;
	}
	
}
