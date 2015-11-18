package game.entities;

import game.Boundary.Outputable;
import game.entities.Field.FieldType;
import game.resources.FieldData;

public class FieldManager {
	
	private final int NUMBER_OF_FIELDS = 21;
	private Field[] fields;
	
	public FieldManager(Outputable gui){
		initializeFields(gui);
		
	}
	// Is used to find the number of specific fieldtypes a player owns.
	public int getFieldsOwned(Player player, FieldType fieldtype){
		int count = 0;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getOwner() == player && fields[i].getFieldType() == fieldtype){
				count ++;		
			}
		}
		return count;
	}
	// Is used to calculate the tax value of all owned fields.
	public int getFieldsValue(Player player){
		int value = 0;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getOwner() == player){
				value += fields[i].getValue();
			}
		}
		return value;
	}
	
	
	
	private void initializeFields(Outputable gui){
		fields = new Field[NUMBER_OF_FIELDS];
		
		for (int i = 0; i < fields.length; i++) {
			switch(FieldData.FIELDTYPE_DATA[i]){
			case TERRITORY: fields[i] = new Territory(this, FieldData.FIELDBUYPRICE_DATA[i] , 
				FieldData.FIELDRENT_DATA[i], gui);
			break;
			case LABOR_CAMP: fields[i] = new LaborCamp(this, FieldData.FIELDBUYPRICE_DATA[i],
				FieldData.FIELDRENT_DATA[i], gui);
			break;
			case FLEET: fields[i] = new Fleet(this, FieldData.FIELDRENT_DATA[i], gui);
			break;
			case TAX: fields[i] = new Tax(this, FieldData.FIELDRENT_DATA[i], gui);
			break;
			case REFUGE: fields[i] = new Refuge(this, FieldData.FIELDRENT_DATA[i], gui);
			break;
			
			}
			
		}
		
		
	}

}
