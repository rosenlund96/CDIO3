package game.entities;

import game.Boundary.Outputable;

public abstract class Field {

	FieldManager fieldManager;
	public enum FieldType{TERRITORY, LABOR_CAMP, FLEET, TAX, REFUGE}
	protected FieldType fieldType;
	protected Outputable output;
	
	
	
	public Field(FieldManager fm,  FieldType fieldType, Outputable output) {
		this.fieldManager = fm;
		this.fieldType = fieldType;
		this.output = output;
		
	} 
	
	
	public FieldType getFieldType(){
		return fieldType;
	}
	
	public abstract void landOnField(Player player);
		//Vil blive kaldt hver gang en spiller lander på et felt. 
	

	

	
	
	
	
}
