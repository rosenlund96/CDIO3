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

	public FieldManager(Outputable gui){
		initializeFields(gui);

	}
	
	public void landOnFieldByNumber(Player player, int fieldNumber){
		fields[fieldNumber].landOnField(player);
	}
	
	
	// Is used to find the number of specific fieldtypes a player owns.
	public int getFieldsOwned(Player player, FieldType fieldtype){
		int count = 0;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] instanceof Ownable){
				if (((Ownable)fields[i]).getOwner() == player && fields[i].getFieldType() == fieldtype){
					count ++;		
				}
			}

		}
		return count;
	}
	
	public int getFieldNumber(Field field){
		int number  = 0;
		for(int i = 0; i < NUMBER_OF_FIELDS; i++){
			if(field == fields[i])
				number = i;
		}
		return number;
	
	}
	// Is used to calculate the tax value of all owned fields.
	public int getFieldsValue(Player player){
		int value = 0;
		for (int i = 0; i < fields.length; i++) {
			// check whether fields[i] is of class Ownable
			if(fields[i] instanceof Ownable){
				// if it is, cast and use ownable methods
				if (((Ownable)fields[i]).getOwner() == player){
					value += ((Ownable)fields[i]).getPrice();
				}
			}
		}
		return value;
	}

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

	public void freeFields(Player player){
		for(Field f: fields){
			if(f instanceof Ownable){
				if(((Ownable)f).getOwner() == player)
					((Ownable)f).clearOwner();
			}
		}
	}
	public int getNumberOfFields(){
		return NUMBER_OF_FIELDS;
	}


}
