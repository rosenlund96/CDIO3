package game.Boundary;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_resources.GUI;
import game.util.XMLReader;

/**
 * Handles indirection between the supplied GUI and the game
 */
public class GUIBoundary implements Outputable{

	XMLReader reader;
	
	public GUIBoundary(String langFilePath){
		reader = new XMLReader(langFilePath);
	}
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
	public void showWinner(String playerName) {
		GUI.showMessage(playerName + " " + reader.getElement("winner", 0));
		
	}

	@Override
	public String promptPlayerName(int playerNumber) {
		String s1 = reader.getElement("promptName", 0);
		String s2 = reader.getElement("promptName", 1);
		String msg = s1 + " " + playerNumber + " " + s2;
		return GUI.getUserString(msg);
	}

	@Override
	public void promptRollDice(String playerName) {
		String s1 = reader.getElement("roll", 0);
		String msg = playerName + ". " + s1;
		GUI.showMessage(msg);
	}
	
	@Override
	public boolean promptTax(String playerName, int taxAmount, int percentAmount){
		
		return true;
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

}
