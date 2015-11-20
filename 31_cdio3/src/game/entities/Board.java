package game.entities;

import java.util.ArrayList;

import game.Boundary.Outputable;

public class Board {

	
	ArrayList<Player> players;
	FieldManager fm;
	int playersTurn;

	// Konstruktor
	public Board(String[] names, int startingBalance, Outputable gui){
		for (int i = 0; i < names.length; i++) {
			players.add(new Player(names[i], startingBalance, i, false));
		}
		fm = new FieldManager(gui);
	}

	public void moveActivePlayer(int amount ){
		players.get(playersTurn).setPosition((players.get(playersTurn).getPosition()+ amount)%fm.getNumberOfFields() );

	}

	// Finds who gets to start

	public void findStartingPlayer(){

		int random = ((int)Math.random() * players.size());
		playersTurn = random;
		
	}
	// Finds a potential winner
	public boolean getWinner(){
		// Updates players arraylist 
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getBroke()){
				players.remove(i);
				playersTurn = playersTurn == 0? players.size()-1 : playersTurn-1;
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
		return players.get(playersTurn).getPosition();

	}

	public int getActivePlayerBalance(){
		return players.get(playersTurn).getBalance();
	}
	
	public String getActivePlayerName(){
		return players.get(playersTurn).getName();
	}
	
	

}
