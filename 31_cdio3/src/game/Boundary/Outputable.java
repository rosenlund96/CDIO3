package game.Boundary;

import game.entities.Player;

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
	//Du er landet på et felt ejet af en anden og skal betale amountToPay, overførsel godkendt
	public void showTransferMessageSucces(Player owner, int amountToPay);
	//Du er landet på et felt ejet af en anden og skal betale amountToPay, du har ikke nok penge og er gået bankerot
	public void showTransferMessageFailed(Player owner, int amountToPay);
	
	public String promptPlayerName(int playerNumber);
	public void promptRollDice(String playerName);
	
	// spørg spilleren om han vil betale taxamount eller en procentdel af hans aktiver
	// returner true hvis procentDel
	public boolean promptTax(String playerName, int taxAmount, int percentAmount);
	
	public void addPlayer(String playerName, int balance, int playerNo);
	
	public void initializeBoard();

	public void promptBuy(String name, int price);

	public void showNotEnoughBalanceMessage(Player player);

	public void showBrokeMessage(Player owner, int rent, int balance);

	public void showLandOnOwnedFieldMessage(int rent, Player owner);
}
