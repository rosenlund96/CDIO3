package game.entities;

public class Balance {

	// attributes

	private int balance; 

	// Constructors

	public Balance(int startingBalance){
		this.balance = startingBalance;
	}

	public void deposit(int amount){
		this.balance += amount;
	}

	public int withdraw(int amount){
		if (amount <= balance){
			balance -= amount;
		}
		else{
			amount = balance;
			balance = 0;
		}
		return amount;
	}

	// Mutators

	public int getBalance(){
		return balance;
	}

	public void setBalance(int balance){
		this.balance = balance;
	}

}
