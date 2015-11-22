package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.boundaries.Outputable;
import game.entities.*;
import game.entities.fields.*;
import test.mockClasses.TestBoundary1;

public class TestCase2 {
	private Player player, owner;
	private Outputable output;
	private FieldManager fm;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("player", 5000, 0, false);
		owner = new Player("owner", 5000, 0, false);
		output = new TestBoundary1();
		fm = new FieldManager(output);

	}

	// TestCase 2.1
	@Test
	public void Territory2500() {
		
		// Setup
		Territory t = new Territory(fm, 2500, 2500, output);

		assertEquals("Player startin balance incorrect", 5000, player.getBalance());
		assertEquals("Owner startin balance incorrect", 5000, owner.getBalance());
		assertEquals("Territory price incorrect ater setup", 2500, t.getPrice());
		assertEquals("Territory rent incorrectr after setup", 2500, t.getRent());

		// Act

		// setting owner
		t.landOnField(owner);

		// player landing and paying rent
		t.landOnField(player);

		// Assert
		assertEquals("owner recieved incorret rent", 5000, owner.getBalance());
		assertEquals("player gave incorret rent", 2500, player.getBalance());
	}
}
