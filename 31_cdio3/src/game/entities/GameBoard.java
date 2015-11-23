package game.entities;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthStyle;

import game.boundaries.Outputable;

public class GameBoard {

	private ArrayList<Player> players;
	private FieldManager fieldManager;
	private int playerTurn;

	// Constructors
	public GameBoard(ArrayList<String> names, int startingBalance, Outputable gui){

		players =  new ArrayList<Player>();
		fieldManager = new FieldManager(gui);

		for (int i = 0; i < names.size(); i++) {
			players.add(new Player(names.get(i), startingBalance, 0, false));
		}
		fieldManager = new FieldManager(gui);
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

	// Finds a potential winner
	public boolean getWinner(){
		// Updates players arraylist 
	
		// If arraylist is only one player long we have a winner
		if (players.size() == 1){
			return true;
		}
		return false;
	}

	public void moveActivePlayer(int amount ){
		players.get(playerTurn).setPosition(((players.get(playerTurn).getPosition() + amount) % fieldManager.getNumberOfFields()));
		

	}
	public void activePlayerFieldAction(){
		fieldManager.landOnFieldByNumber(players.get(playerTurn), players.get(playerTurn).getPosition());
	}

	// Resolves starting player
	public void findStartingPlayer(){
		playerTurn = (int)(Math.random() * players.size());
	}
	
	public String isActivePlayerBroke(){
		String playerName = null;
		if (players.get(playerTurn).getBroke()){
			playerName = players.get(playerTurn).getName();
			fieldManager.freeFields(players.get(playerTurn));
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



}
