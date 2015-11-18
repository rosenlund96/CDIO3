package game.entities;

import java.util.ArrayList;

import game.Boundary.Outputable;

public class Board {
	
	
	ArrayList<Player> players;
	// Konstruktor
	public Board(String[] names, int startingBalance, Outputable gui){
		for (int i = 0; i < names.length; i++) {
			players.add(new Player(names[i], startingBalance));
		}
		FieldManager fm = new FieldManager(gui);
		
		
	}



	public void moveActivePlayer(int amount ){
		

	}


	public void findStartingPlayer(){

	}

	public boolean getWinner(){

	}


	public int getActiveplayerPosition(){

	}

	public int getActivePlayerBalance(){

	}

}
