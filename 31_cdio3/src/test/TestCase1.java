package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.entities.*;
import game.entities.fields.Refuge;
import game.boundaries.Outputable;

import test.mockClasses.TestBoundary1;

public class TestCase1 {
	private Player player;
	private Outputable output;
	private Refuge refuge;
	private FieldManager fm;
	@Before
	public void setUp() throws Exception {
		player = new Player("name", 5000, 0, false);
		output = new TestBoundary1();
		fm = new FieldManager(output);

	}

	// TestCase1.1
	@Test
	public void Refuge0(){
		
		// setup
		refuge = new Refuge(fm, 0, output);

		assertEquals("Player startin balance incorrect", 5000, player.getBalance());
		assertEquals("Refuge bonus incorrect after setup", 0, refuge.getBonus());

		// act
		refuge.landOnField(player);

		// assert
		assertEquals("Refuge gave incorrect amount", 5000, player.getBalance());

	}

	// TestCase 1.2
	@Test
	public void Refuge500() {

		// setup
		refuge = new Refuge(fm, 500, output);

		assertEquals("Player startin balance incorrect", 5000, player.getBalance());
		assertEquals("Refuge bonus incorrect ater setup", 500, refuge.getBonus());

		// act
		refuge.landOnField(player);

		// assert
		assertEquals("Refuge gave incorrect amount", 5500, player.getBalance());

	}

	// TestCase 1.3
	@Test
	public void Refuge5000(){
		// setup
		refuge = new Refuge(fm, 5000, output);

		assertEquals("Player startin balance incorrect", 5000, player.getBalance());
		assertEquals("Refuge bonus incorrect ater setup", 5000, refuge.getBonus());

		// act
		refuge.landOnField(player);

		// assert
		assertEquals("Refuge gave incorrect amount", 10000, player.getBalance());
	}


}
