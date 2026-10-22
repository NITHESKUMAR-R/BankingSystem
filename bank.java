package banckproject;

import java.util.*;

public class bank extends amount {
	
	bank(){
		System.out.println("Press 1 Create Account");
		System.out.println();
		System.out.println("Press 2 View Account Details");
		System.out.println();
		System.out.println("Press 3 Set PIN");
		System.out.println();
		System.out.println("Press 4 Deposit Money");
		System.out.println();
		System.out.println("Press 5 Withdraw Money");
		System.out.println();
		System.out.println("Press 6 Check Balance");
		System.out.println();
		System.out.println("Press 7 Exit");
		System.out.println();
		System.out.print("Enter choice : ");
		System.out.println();

	}
	
	public static void main(String[] args)  {
		
		    creatAccount creAcc = new creatAccount();
	        accdetils Accountinfo = new accdetils();
			pin PINgendrate = new pin();
			deposite Dep = new deposite();
			withdra withdraw =new withdra();
			balnc balance = new balnc();
			
			
		Scanner scan =new Scanner(System.in);
		boolean proces = true ;
		while(proces) {
		bank bank = new bank();
	    int choise=scan.nextInt();
		
		switch(choise) {
		 
		case 1:
			creAcc.creatacc(scan);
			break ;
		case 2:
			Accountinfo.accinfo(scan);
			break ;
		case 3:
			PINgendrate.pingen(scan);
			break ;
		case 4:
			Dep.deposit(scan);
			break ;
		case 5:
			withdraw.withdraw(scan);
			break ;	 
		case 6:
			balance.balance(scan);
			 break;
			 
		case 7:
			proces = false;
			break ;
		default :
			System.out.println("Invalid choise ");
			 
		 }
		
       }
	}
}



