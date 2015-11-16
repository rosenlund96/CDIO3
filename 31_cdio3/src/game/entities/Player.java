package game.entities;

public class Player {

	private String name; 
	private int position;
	private Balance balance;
	private boolean extraTurn;
	
	
	public Player(String name, int startingBalance){
		this.name = name;
		this.balance = new Balance(startingBalance);
		this.position = 0; 
	}
	
	//returnere navnet på den nuværende spiller. 
	public String getName(){ 
		return name;
	}
	
	//ændre balancen på den nuværende spiller. 
	public void changeBalance(int deltaBalance){ 	 	
			balance.changeBalance(deltaBalance);
	}
	
	public void setBalance(int balance){
		this.balance.setBalance(balance);
	}
	
	//returnere den nuværende balance på spilleren. 
	public int getBalance(){
		return balance.getBalance();
	}
	
	public void setPosition(int newPosition) {
		// player can only land on field 2 to 12
		if(newPosition > 1 && newPosition < 13)
			this.position = newPosition; 
	}
	//returnere den nuværende position på spilleren
	public int getPosition(){
		return position; 
	}
	
	public void setExtraTurn(boolean extraTurn){
		this.extraTurn = extraTurn;
	}
	
	public boolean getExtraTurn(){
		return this.extraTurn;
	}
	
}

