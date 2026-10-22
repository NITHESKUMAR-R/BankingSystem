package banckproject;


public class amount {
	
private double balance;
	
	public double deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			
		}
		else {
			System.out.println("Invalid Deposite");
		}
		return balance;
	}
	
	public void withdraw(double amount) {
		if(amount>0 &&  amount <= balance) {
			balance-=amount;
			System.out.println("Succesfully Withdraw");
		}
		else {
			System.out.println("Insufficient Balance");
		}
	}
	
	public double getbalance() {
		return balance;
	}
	
	public static void main(String[] args) {
		
		amount am= new amount();
		am.deposit(5412.20);
		am.withdraw(41.25);
		System.out.println(am.getbalance());
	}
	
	
}


