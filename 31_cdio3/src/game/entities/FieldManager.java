package game.entities;

import game.boundaries.Outputable;
import game.entities.fields.Field;
import game.entities.fields.Fleet;
import game.entities.fields.LaborCamp;
import game.entities.fields.Ownable;
import game.entities.fields.Refuge;
import game.entities.fields.Tax;
import game.entities.fields.Territory;
import game.entities.fields.Field.FieldType;
import game.resources.FieldData;

public class FieldManager {

	public final int NUMBER_OF_FIELDS = 21;
	private Field[] fields;
	
	/**************************************************
	 * Construktor, takes a gui to pass to the fields *
	 **************************************************/
	public FieldManager(Outputable gui){
		initializeFields(gui);

	}
	
	public int getNumberOfFields(){
		return NUMBER_OF_FIELDS;
	}

	/***************************************************************************
	 * Returns an int with the number of fields owned of a type by a player    *
	 ***************************************************************************/
	public int getFieldsOwned(Player player, FieldType fieldtype){
		int count = 0;
		// Counts fields owned of a specific type by a player
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] instanceof Ownable){
				if (((Ownable)fields[i]).getOwner() == player && fields[i].getFieldType() == fieldtype){
					count ++;		
				}
			}
		}
		return count;
	}
	/****************************************
	 * Returnes the field number of a field *
	 ****************************************/
	public int getFieldNumber(Field field){
		int number  = 0;
		for(int i = 0; i < NUMBER_OF_FIELDS; i++){
			if(field == fields[i])
				number = i;
		}
		return number;
	
	}

	/*********************************************************
	 * Returnes the value of all fields owned by a player    *
	 *********************************************************/
	public int getFieldsValue(Player player){
		int value = 0;
		for (int i = 0; i < fields.length; i++) {
			// Checks whether fields[i] is of class Ownable
			if(fields[i] instanceof Ownable){
				//If it is, cast and use ownable methods
				if (((Ownable)fields[i]).getOwner() == player){
					value += ((Ownable)fields[i]).getPrice();
				}
			}
		}
		return value;
	}
	
	/***************************************************************
	 * Frees up all fields own by a player so others can buy them  *
	 ***************************************************************/
	public void freeFields(Player player){
		for(Field f: fields){
			if(f instanceof Ownable){
				if(((Ownable)f).getOwner() == player)
					((Ownable)f).clearOwner();
			}
		}
	}
	/*********************************************
	 * Uses landOnField on a field with a player *
	 *********************************************/
	public void landOnFieldByNumber(Player player, int fieldNumber){
		fields[fieldNumber].landOnField(player);
	}
	
	/************************************************************
	 * Creates the array of fields use from the FieldData class *
	 ************************************************************/
	private void initializeFields(Outputable gui){
		fields = new Field[NUMBER_OF_FIELDS];

		for (int i = 0; i < fields.length; i++) {
			switch(FieldData.FIELDTYPE_DATA[i]){
			case TERRITORY: 
				fields[i] = new Territory(this, FieldData.FIELDBUYPRICE_DATA[i],FieldData.FIELDRENT_DATA[i], gui);
				break;
			case LABOR_CAMP: 
				fields[i] = new LaborCamp(this, FieldData.FIELDBUYPRICE_DATA[i], FieldData.FIELDRENT_DATA[i], gui);
				break;
			case FLEET: 
				fields[i] = new Fleet(this, FieldData.FIELDBUYPRICE_DATA[i], gui);
				break;
			case TAX: 
				fields[i] = new Tax(this, FieldData.FIELDRENT_DATA[i], gui);
				break;
			case REFUGE: 
				fields[i] = new Refuge(this, FieldData.FIELDRENT_DATA[i], gui);
				break;
			}	
		}	
	}
}
