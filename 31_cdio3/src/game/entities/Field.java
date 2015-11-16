package game.entities;

public abstract class Field {

	FieldManager FM = new FieldManager;
	int activePlayerPos; 
	int effectValue;
	boolean extraTurn;
	String name; 
	
	
	
	public Field(String name, int effectValue, boolean extraTurn, int activePlayerPos) {
		this.effectValue = effectValue;
		this.extraTurn = extraTurn;
		this.activePlayerPos = activePlayerPos; 
		this.name = name; 
	} 
	
	public abstract void landOnField(Player activePlayer);
		//Vil blive kaldt hver gang en spiller lander på et felt. 
	
	public int getEffectValue(){
		return effectValue;
	}
	
	public boolean getExtraTurn(){
		return extraTurn;
	}
	
	
	
	
}
