package game.entities;

import game.Boundary.Outputable;

public abstract class Ownable extends Field {

	protected int price;
	protected int rent; 
	protected Player owner;

	public Ownable(FieldManager fm, int price, int rent ,Outputable output) {
		super(fm, output);
		this.price = price;
		this.rent = rent; 
	}

	public int getPrice(){
		return price;
	}
	
	//Hvis feltet er ledigt
	@Override
	public void landOnField(Player player){
		if(this.owner == null){
				if(output.promptBuy(player.getName(), price) == true){
				if (player.getBalance()>price){
				player.withdraw(price);	
				setOwner(player);
					output.showFieldBoughtMessage();
				}
				else{
					output.showNotBoughtMessage();
				}
			}
			else {
				output.showNotEnoughBalanceMessage(player);
			}
		}
	}


	protected void setOwner(Player owner){
		this.owner = owner; 
	}

	public Player getOwner(){
		return owner; 
	}


	// fuck det her pis
	public abstract int getRent();

}
