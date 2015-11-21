package game.boundaries;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import game.entities.Player;
import game.util.XMLReader;

/**
 * Handles indirection between the supplied GUI and the game
 */
public class GUIBoundary implements Outputable{
	
	// Fields
	XMLReader reader;

	// Constructors
	public GUIBoundary(String langFilePath){
		reader = new XMLReader(langFilePath);
	}
	
	
	// Methods
	
	/****************************************************************
	 * Updating active player balance and position and displays 	*
	 *  the dice rolled by the player								*
	 ***************************************************************/
	@Override
	public void update(int[] dice, int pos, int balance, String playerName) {
		// Updating dice values
		GUI.setDice(dice[0], dice[1]);

		// Updating active player balance
		GUI.setBalance(playerName, balance);

		// Removing players current car
		GUI.removeAllCars(playerName);
		// Adding player car at updated position
		GUI.setCar(pos, playerName);
	}

	@Override
	public void showWelcome() {
		GUI.showMessage(reader.getElement("welcome", 0));

	}

	@Override
	public void showStartingPlayer(String playerName){
		String s1 = reader.getElement("starting", 0);
		
		String msg = playerName + " " + s1;
		
		GUI.showMessage(msg);
	}
	
	@Override
	public void showWinner(String playerName) {
		GUI.showMessage(playerName + " " + reader.getElement("winner", 0));

	}

	@Override
	public String promptPlayerName(int playerNumber, boolean error) {
		String s1, s2, msg;
		if(error){
			msg = reader.getElement("promptName", 2);			
		}
		else{
			s1 = reader.getElement("promptName", 0);
			s2 = reader.getElement("promptName", 1);
			msg = s1 + " " + playerNumber + " " + s2;
		}

		return GUI.getUserString(msg);
	}

	@Override
	public void promptRollDice(String playerName) {
		String s1 = reader.getElement("roll", 0);
		
		String msg = playerName + ". " + s1;
		GUI.showMessage(msg);
	}

	/************************************************************************
	 * Adds a new player to the board. using balance, name, and player #	*
	 * 																		*
	 * @param playerName Name of player which should be added to the board	*
	 * @param balance Starting balance of player							*
	 * @param playerNumber 0-5, otherwise error will occur					*
	 ***********************************************************************/
	public void addPlayer(String playerName, int balance, int playerNumber) {
		Color[] colors = {Color.BLUE, Color.WHITE, Color.MAGENTA, Color.YELLOW, Color.BLACK, Color.GREEN};

		Car car = new Car.Builder()
				.primaryColor(colors[playerNumber])
				.secondaryColor(colors[5-playerNumber]).build();
		GUI.addPlayer(playerName, balance, car);

	}

	@Override
	public void initializeBoard() {
		// TODO Auto-generated method stub
	
	}
	// Message used when money is taken from player
	@Override
	public void showWithdrawMessage(String playerName, int amount) {
		String s1 = reader.getElement("withdraw", 0);
		String s2 = reader.getElement("withdraw", 1);
		
		String msg = playerName + ": " + s1 + " " + amount + " " + s2;		
		GUI.showMessage(msg);
	}
	
	// Message used when money is given to player
	@Override
	public void showDepositMessage(String playerName, int bonus) {
		String s1 = reader.getElement("deposit", 0);
		String s2 = reader.getElement("deposit", 1);
		
		String msg = playerName + ": " + s1 + " " + bonus + " " + s2;
		GUI.showMessage(msg);
	}
	

	@Override
	public void showNotEnoughBalanceMessage(Player player) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showBrokeMessage(Player owner, int rent, int balance) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showTransferMessage(String playerName, String ownerName, int amount) {
		String s1 = reader.getElement("transfer", 0);
		String s2 = reader.getElement("transfer", 1);
		
		String msg = playerName + ": " + s1 + " " + amount + " " + s2 + " " + ownerName;
		GUI.showMessage(msg);
	}
	@Override
	public void showNotBoughtMessage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showFieldBoughtMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean promptTax(String playerName, int taxAmount, int percentAmount) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean promptBuy(String name, int price) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void showPlayerIsOwner(String playerName) {
		String s1 = reader.getElement("isOwner", 0);
		
		String msg = playerName + ": " + s1;
		GUI.showMessage(msg);
		
	}
	@Override
	public void showLandOnOwnedFleetMessage(int amount, Player owner, Player player) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showLandOnOwnedFieldMessage(int rent, Player player, Player owner) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showRollingDiceForRent(String playeName) {
		// TODO Auto-generated method stub
		
	}

}
