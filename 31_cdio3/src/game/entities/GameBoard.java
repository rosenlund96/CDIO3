package game.entities;

import java.util.ArrayList;

import game.boundaries.Outputable;

public class GameBoard {

	ArrayList<Player> players;
	FieldManager fieldManager;
	int playerTurn;

	// Constructors
	public GameBoard(ArrayList<String> names, int startingBalance, Outputable gui){

		players =  new ArrayList<Player>();
		fieldManager = new FieldManager(gui);

		for (int i = 0; i < names.size(); i++) {
			players.add(new Player(names.get(i), startingBalance, i, false));
		}
		fieldManager = new FieldManager(gui);
	}

	public void moveActivePlayer(int amount ){
		players.get(playerTurn).setPosition(((players.get(playerTurn).getPosition() + amount) % fieldManager.getNumberOfFields())-1 );

	}

	// Resolves starting player

	public void findStartingPlayer(){

		int random = ((int)Math.random() * players.size());
		playerTurn = random;

	}
	// Finds a potential winner
	public boolean getWinner(){
		// Updates players arraylist 

		// If arraylist is only one player long we have a winner
		if (players.size() == 1){
			return true;
		}
		return false;
	}

	public String isActivePlayerBroke(){
		String playerName = null;
		if (players.get(playerTurn).getBroke()){
			playerName = players.get(playerTurn).getName();
			players.remove(playerTurn);
			playerTurn = playerTurn == 0? players.size()-1 : playerTurn-1;
		}

		return playerName;
	}

	public void nextTurn(){
		playerTurn++;
		if (playerTurn >= players.size()){
			playerTurn = 0;
		}	
	}

	public int getActivePlayerPosition(){
		return players.get(playerTurn).getPosition();

	}

	public int getActivePlayerBalance(){
		return players.get(playerTurn).getBalance();
	}

	public String getActivePlayerName(){
		return players.get(playerTurn).getName();
	}



}
