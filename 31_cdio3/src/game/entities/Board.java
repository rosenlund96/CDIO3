package game.entities;

import java.util.ArrayList;

import game.Boundary.Outputable;

public class Board {


	ArrayList<Player> players;
	Player activePlayer;
	int numberOfPlayers;

	// Konstruktor
	public Board(String[] names, int startingBalance, Outputable gui){
		for (int i = 0; i < names.length; i++) {
			players.add(new Player(names[i], startingBalance));
		}
		FieldManager fm = new FieldManager(gui);
		numberOfPlayers = names.length;
	}



	public void moveActivePlayer(int amount ){
		activePlayer.setPosition((activePlayer.getPosition()+ amount)%fm.getNumberOfFields() );

	}

	// Finds who gets to start

	public void findStartingPlayer(){

		int random = ((int)Math.random() * numberOfPlayers);
		activePlayer = players.get(random);
		
	}

	public boolean getWinner(){

	}


	public int getActiveplayerPosition(){

	}

	public int getActivePlayerBalance(){

	}

}
