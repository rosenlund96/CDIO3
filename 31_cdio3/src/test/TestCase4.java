package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import game.boundaries.Outputable;
import game.entities.FieldManager;
import game.entities.Player;

import game.entities.fields.Tax;
import test.mockClasses.TestBoundary1;

public class TestCase4 {
	private Player player;
	private Outputable output;
	private Tax tax;
	private FieldManager fm;
	@Before
	public void setUp() throws Exception {
		player = new Player("name", 5000, 0, false);
		output = new TestBoundary1();
		fm = new FieldManager(output);

	}

	// TestCase 4.1
	@Test
	public void Tax0(){
		
		// setup
		tax = new Tax(fm, 2000, output);

		assertEquals("Player startin balance incorrect", 5000, player.getBalance());
		assertEquals("taxamount incorrect after setup", 2000, tax.getTaxAmount());

		// act
		tax.landOnField(player);

		// assert
		assertEquals("Tax took incorrect amount", 3000, player.getBalance());

	}
}