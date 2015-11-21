package game.entities.fields;

import game.boundaries.Outputable;
import game.entities.FieldManager;
import game.entities.Player;

public abstract class Field {

	public enum FieldType{TERRITORY, LABOR_CAMP, FLEET, TAX, REFUGE}
	
	protected FieldManager fieldManager;
	protected Outputable output;
	
	protected FieldType fieldType;
	
			
	public Field(FieldManager fieldManager, FieldType fieldType, Outputable output) {
		this.fieldManager = fieldManager;
		this.output = output;
		this.fieldType = fieldType;
		
	} 
	
	public FieldType getFieldType(){
		return fieldType;
	}
	
	// Can be called for aplayer landing on the field
	public abstract void landOnField(Player player);
		
	
	
}
