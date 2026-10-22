package banckproject;

import java.io.*;
import java.util.*;

public class withdra {

	
	void withdraw(Scanner scan) { 
		   
		   try {   
			   
			   File file = new File("Amount.txt");
			   System.out.println("--------Before Withdrawal Must You Create the PIN--------");
		    	  System.out.println("Enter Your AC Number");
					scan.nextLine();
					String acno = scan.nextLine();
					
					
					BufferedReader bufferride = new BufferedReader(new FileReader(new File("PIN.txt")));
					String line2;
					 
					 boolean found = false;
					 boolean Accfound = false;
					 boolean withfound = false;
				
					while ((line2 = bufferride.readLine()) != null) {
						
						   if (line2.startsWith("PIN")) {
							   
							   String Accno = line2.split(":")[1].trim().split(" ")[0];
							   String pin = line2.split(":")[1].trim().split(" ")[1];
		                      
				            if(Accno.equals(acno)) {
				            	System.out.println("Enter Your PIN");
								String checkpin = scan.nextLine();
								Accfound =true;
				            	if(checkpin.equals(pin)) {
				            		 System.out.println("Account Found");			            	
									    found = true;
									    withfound=true;
						                break;
				            	}
							}			            
						}	
					}
					if (!Accfound) {
				        System.out.println("Your Account Number is Worng....");
				        System.out.println();
				        found=true;
				   }
					if (!found) {
						System.out.println("PIN is Incorrect...!!!");
				        System.out.println();
				   }
					
					bufferride.close();
					
				if(withfound) {
					
					boolean withdraw =false;
					ArrayList<String> amount = new ArrayList<>();

					BufferedReader reader = new BufferedReader(new FileReader("Amount.txt"));

					String line;

					while((line = reader.readLine()) != null){
						
					    if(line.startsWith("amount")){
					    	
					    	String Accno = line.split(":")[1].trim().split(" ")[0];
							   String Amount = line.split(":")[1].trim().split(" ")[1];
							   
					          if(Accno.equals(acno)){
					        	
					            System.out.println("Enter Your Withdraw Amount");
					            double withdrawamount = scan.nextDouble();
				            	double amountvalue = Double.parseDouble(Amount);
					            if(withdrawamount>0 && amountvalue >= withdrawamount) {
					            	amountvalue -= withdrawamount;
					            	 amount.add("amount : " + acno + " " + amountvalue);
					            	 System.out.println("Withdraw Succesfully...!!!");
					            	 System.out.println();
					            	 withdraw = true;
					    		}
					    		else {
					    			System.out.println("Invalid Amount");
					    			System.out.println();
					    			 amount.add(line);
					    			 withdraw = true;
					    		}				           
					        }
					        else{
					        	amount.add(line);
					        }
				}
					}
					if(!withdraw) {
						System.out.println("Your Account Not Found.....Plese First Deposite Amount..!!!");
						System.out.println();
					}

					reader.close();
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));

					for(String data : amount){
					    writer.write(data);
					    writer.newLine();
					}
					writer.close();		
				}
				
			}catch (IOException k) {
			    System.out.println("Error occurred!");
			    k.printStackTrace();
			    }
		 
      	}
}
