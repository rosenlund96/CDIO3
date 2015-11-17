package game.entities;

public abstract class Field {

	FieldManager fm = new FieldManager;
	protected String fieldType;
	
	
	
	public Field(FieldManager fm,  String fieldType) {

		this.fieldType = fieldType;
		
	} 
	
	
	public String getFieldType(String fieldType){
		return fieldType;
	}
	
	public abstract void landOnField(Player activePlayer);
		//Vil blive kaldt hver gang en spiller lander på et felt. 
	

	

	
	
	
	
}
