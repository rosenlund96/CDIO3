package game.resources;

import game.entities.Field;
import game.entities.Field.FieldType;

public class FieldData {
	
	public static final int[] FIELDRENT_DATA = {
			100, 300, 500, 500, 5000, 2000, 700, 1000, 1300, 500,
			100, 1600, 2000, 2600, 500, 4000, 500, 100, 3200, 4000,
			500};
	public static final int[] FIELDBUYPRICE_DATA = {
			1000, 1500, 2000, 4000, 0, 0, 3000, 4000, 4300, 4000, 2500, 
			4750, 5000, 5500, 4000, 0, 0, 2500, 6000, 8000, 4000  };
	public static final boolean[] FIELDOWABLE_DATA = {
			true, true, true, true, true, false, false, true, true, true, 
			true, true, true, true, true, false, false, true, true, true, 
			true};
	public static final FieldType[] FIELDTYPE_DATA = {
			Field.FieldType.TERRITORY ,Field.FieldType.TERRITORY,
			Field.FieldType.TERRITORY, Field.FieldType.FLEET, 
			Field.FieldType.REFUGE, Field.FieldType.TAX, 
			Field.FieldType.TERRITORY, Field.FieldType.TERRITORY,
			Field.FieldType.TERRITORY, Field.FieldType.FLEET,
			Field.FieldType.LABOR_CAMP, Field.FieldType.TERRITORY,
			Field.FieldType.TERRITORY, Field.FieldType.TERRITORY,
			Field.FieldType.FLEET, Field.FieldType.TAX, 
			Field.FieldType.REFUGE, Field.FieldType.LABOR_CAMP,
			Field.FieldType.TERRITORY, Field.FieldType.TERRITORY,
			Field.FieldType.FLEET
			};
	
	
}
