package game.entities;

import game.boundaries.Outputable;

public class Territory extends Ownable {
	
	private int rent;
	private int rentAmount;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, rent, output);
		this.rent = rent;
	}	
	// owner = null
	// super.landonfield
	public void landOnField(Player player){
		if (this.owner == null) {
			super.landOnField(player);
		}
		else if (this.owner != player) {
		output.showLandOnOwnedFieldMessage(rent, owner);	
		transferRent(player, owner);
		}
		else if (this.owner == player) {
			output.youOwnThisFieldMessage(owner);
		}
		}	

	public void transferRent(Player player, Player owner){ // fjern rentamount
		rentAmount = player.withdraw(rent); // rent amount ind her 
		owner.deposit(rentAmount);
		output.showLandOnOwnedFieldMessage(rentAmount, owner);
		}
		
	@Override
	public int getRent() { // skal returnere rent 
		return rent;
	}

	@Override 
	public Player getOwner() {
		return owner;
	}
	
}
