package game.entities;

public class Refuge extends Field {

	protected int bonus; 
	
	

	public Refuge(FieldManager fm, String fieldType, int bonus) {
		super(fm, fieldType);
		this.bonus = bonus;
	}







	@Override
	public void landOnField(Player activePlayer) {
		activePlayer.changeBalance(bonus);
	}
}
