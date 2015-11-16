package game.entities;

public class Refuge extends Field {

	int bonus; 
	
	
	public Refuge(String name, int activePlayerPos, int bonus) {
		super(name, activePlayerPos);
		this.bonus = bonus;
	}



	@Override
	public void landOnField(Player activePlayer) {
		if(Field[12]){
			activePlayer.changeBalance(bonus);
		}
		else if(Field[13]){
			activePlayer.changeBalance(bonus);
		}
		
	}

}
