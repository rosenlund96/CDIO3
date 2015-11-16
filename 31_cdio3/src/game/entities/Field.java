package game.entities;

public abstract class Field {

	FieldManager FM = new FieldManager;
	int activePlayerPos; 
	String name; 
	
	
	
	public Field(FieldManager fm,  fieldType ft) {

		this.fieldType = fieldType;
		
	} 
	
	public abstract void landOnField(Player activePlayer);
		//Vil blive kaldt hver gang en spiller lander på et felt. 
	

	

	
	
	
	
}
