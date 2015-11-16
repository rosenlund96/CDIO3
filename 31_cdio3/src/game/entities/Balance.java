package game.entities;

public class Balance {

	private int balance; 
	
	
	public Balance(int balance){
		setBalance(balance);
	}
	//Sender balancen tilbage til player. 
	public int getBalance() {
		return balance; 
	}
	//Sætter en ny balance på baggrund af nuværende balance samt ændring
	public boolean setBalance(int balance ){
		// Makes sure balance cannot be set to less than 0
		if (balance < 0) {
			this.balance = 0;
			return false;
		}	
		
		this.balance = balance;
		return true;
		
	}
	//ændre balancen. Såfremt at balance er mindre end 0 sættes balancen til 0 og negativeBalance er false for at indikere en fejl. 
	public void changeBalance(int deltaBalance) {
		setBalance(balance + deltaBalance); 
		
	}
	
	
	
	
}
