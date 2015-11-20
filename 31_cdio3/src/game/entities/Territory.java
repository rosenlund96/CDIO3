package game.entities;

import game.Boundary.Outputable;

public class Territory extends Ownable {
	
	private int rent;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);
		this.rent = rent;
	}	
	
	public void landOnField(Player player){
		if(player.getBalance() >= rent)
		output.showLandOnOwnedFieldMessage(rent, owner);	
		transferRent(rent, player, owner);
		}	

	public void transferRent(int rentAmount, Player player, Player owner){
		if (player.getBalance()>=rent) {
		player.withdraw(rentAmount);
		owner.deposit(rentAmount);
		output.showLandOnOwnedFieldMessage(rentAmount, owner);
		}
		else if(player.getBalance() < rent){
			owner.deposit(player.getBalance());
			player.withdraw(player.getBalance());
			player.setBroke(true);
			output.showBrokeMessage(owner, rent, player.getBalance());
	}
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
