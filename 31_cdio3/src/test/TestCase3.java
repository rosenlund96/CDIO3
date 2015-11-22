package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.boundaries.Outputable;
import game.entities.FieldManager;
import game.entities.Player;
import game.entities.fields.Territory;
import test.mockClasses.TestBoundary1;

public class TestCase3 {

	private Player player, owner;
	private Outputable output;
	private FieldManager fm;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("player", 2000, 0, false);
		owner = new Player("owner", 5000, 0, false);
		output = new TestBoundary1();
		fm = new FieldManager(output);

	}

	// TestCase 3.1
	@Test
	public void LowBalanceRent() {
		
		// Setup
		Territory t = new Territory(fm, 2500, 2500, output);

		assertEquals("Player startin balance incorrect", 2000, player.getBalance());
		assertEquals("Owner startin balance incorrect", 5000, owner.getBalance());
		assertEquals("Territory price incorrect ater setup", 2500, t.getPrice());
		assertEquals("Territory rent incorrectr after setup", 2500, t.getRent());

		// Act

		// setting owner
		t.landOnField(owner);

		// player landing and paying rent
		t.landOnField(player);

		// Assert
		assertEquals("owner recieved incorret rent", 4500, owner.getBalance());
		assertEquals("player gave incorret rent", 0, player.getBalance());
		assertTrue("Player should be broke. but is not", player.getBroke());
	}
	
	// TestCase 3.2
	@Test
	public void LowBalanceBuyField() {
		
		// Setup
		Territory t = new Territory(fm, 2500, 2500, output);

		assertEquals("Player startin balance incorrect", 2000, player.getBalance());
		assertEquals("Territory price incorrect ater setup", 2500, t.getPrice());
		assertEquals("Territory rent incorrectr after setup", 2500, t.getRent());

		// Act

		// setting owner
		t.landOnField(player);

		// Assert
		assertEquals("Player payed some, but should not have payed anything", 2000, player.getBalance());
		assertTrue("Player should not be owner", t.getOwner() == null);
	}
}