package game.entities;

import game.boundaries.Outputable;

public class Refuge extends Field {

	protected int bonus; 
	protected FieldType fieldType; 
	
	
	public Refuge(FieldManager fm, int bonus, Outputable output) {
		super(fm, output);
		this.bonus = bonus;
		this.fieldType = FieldType.REFUGE;
	}


	@Override
	public void landOnField(Player player) {
		if(bonus == 5000){
			depositBonus(player, 5000);
		} else if(bonus == 500){
			depositBonus(player, 500);
		}
		
	
	}
	
	
	private void depositBonus(Player player, int bonus){
		player.deposit(bonus);
		output.showDepositMessage(player.getName(), bonus);
	}
	

	
}
