package game.entities;

import java.util.ArrayList;

import game.Boundary.Outputable;

public class Board {

	
	ArrayList<Player> players;
	Player activePlayer;
	int numberOfPlayers;
	FieldManager fm;
	

	// Konstruktor
	public Board(String[] names, int startingBalance, Outputable gui){
		for (int i = 0; i < names.length; i++) {
			players.add(new Player(names[i], startingBalance));
		}
		fm = new FieldManager(gui);
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
	// Finds a potential winner
	public boolean getWinner(){
		// Updates players arraylist 
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getBroke()){
				players.remove(i);
			}
		}
		// If arraylist is only one player long we have a winner
		if (players.size() == 1){
			return true;
		}
		return false;
	}
	
	public void nextTurn(){
	
	
		
	}
	
	public int getActiveplayerPosition(){
		return activePlayer.getPosition();

	}

	public int getActivePlayerBalance(){
		return activePlayer.getBalance();
	}

}
