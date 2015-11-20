package game.entities;

import game.boundaries.Outputable;

public abstract class Field {

	FieldManager fieldManager;
	public enum FieldType{TERRITORY, LABOR_CAMP, FLEET, TAX, REFUGE}
	protected FieldType fieldType;
	protected Outputable output;
	
	
	
	public Field(FieldManager fm, Outputable output) {
		this.fieldManager = fm;
		this.output = output;
		
	} 
	
	
	public FieldType getFieldType(){
		return fieldType;
	}
	//Vil blive kaldt hver gang en spiller lander på et felt. 
	public abstract void landOnField(Player player);
		
	
	
}
