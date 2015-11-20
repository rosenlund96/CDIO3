package game.entities;

public class Player {


	// Attributes

	private int position = 0;
	private String name;
	private Balance balance;
	private boolean isBroke; 

	// Constructors

	public Player(String name, int startingBalance, int position, boolean isBroke){
		this.name = name;
		this.balance = new Balance(startingBalance);
		this.isBroke = false; 
		this.position = position;
	}

	// Mutators

	public String getName(){
		return name;
	}

	public int getPosition(){
		return position;
	}

	public void setPosition(int position){
		this.position = position;		
	}

	public void deposit(int amount){
		balance.deposit(amount);

	}

	public int withdraw(int amount){
		return balance.withdraw(amount);
	}
	
	public boolean getBroke(){
		return isBroke; 
	}
	
	public void setBroke(boolean isBroke){
		this.isBroke = isBroke; 
		//sætter spilleren til bankerot, hvis der ikke er flere knaster. 
	}
	public Balance getBalance(){
		return balance;
	}

}