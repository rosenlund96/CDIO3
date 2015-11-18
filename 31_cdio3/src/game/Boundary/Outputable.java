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
	public void showWithdrawMessage(String playerName, int amount);
	public void showDepositMessage(String playerName, int bonus);
	
	public String promptPlayerName(int playerNumber);
	public void promptRollDice(String playerName);
	
	// spørg spilleren om han vil betale taxamount eller en procentdel af hans aktiver
	// returner true hvis procentDel
	public boolean promptTax(String playerName, int taxAmount, int percentAmount);
	
	public void addPlayer(String playerName, int balance, int playerNo);
	
	public void initializeBoard();
}
