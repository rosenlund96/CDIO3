package game.entities;

import game.Boundary.Outputable;

public class Refuge extends Field {

	protected int bonus; 
	
	
	public Refuge(FieldManager fm, FieldType fieldType, Outputable output, int bonus) {
		super(fm, fieldType, output);
		this.bonus = bonus;
	}


	@Override
	public void landOnField(Player player) {
		if(bonus == 5000){
			depositBonus(5000);
		} else if(bonus == 500){
			depositBonus(500);
		}
		
	
	}
	
	
	private void depositBonus(int bonus){
		player.deposit(bonus);
	}
}
