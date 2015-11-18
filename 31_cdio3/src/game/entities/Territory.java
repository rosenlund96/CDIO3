package game.entities;

public class Territory extends Ownable {
	
	private int rent;

	public Territory(FieldManager fm, int price, int rent, Outputable output) {
		super(fm, price, output);
		this.rent = rent;
	}

	private void collectRent (int rent, Player player, Player owner){
		player.transfer
	}
	
	
	public void landOnField(Player player){
		int balance = player.getBalance();
		if (balance < rent) {
			
		}
	}
	
	@Override
	public int getRent() {
		return 0;
	}

	
}
