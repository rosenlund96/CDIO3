package game.Boundary;
/**
 * 
 * Interface defining methods for input output to screen from game
 * 
 */
public interface Outputable {
	public void update(int[] dice, int pos, int balance, String playerName);
	
	public void showWelcome();
	public void showWinner(String playerName);
	
	public String promptPlayerName(int playerNumber);
	public void promptRollDice(String playerName);
	
	public void addPlayer(String playerName, int balance, int playerNo);
	
	public void initializeBoard();
}
