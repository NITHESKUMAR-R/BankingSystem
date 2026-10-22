package banckproject;

import java.io.*;
import java.util.*;

public class balnc {

	void balance(Scanner scan) {
		
		try {   
			   
			 File file = new File("Amount.txt");
			   System.out.println("--------Before CheckBalance Must You Deposite the Amount--------");
		    	  System.out.println("Enter Your AC Number");
					scan.nextLine();
					String acno = scan.nextLine();
					
					
					BufferedReader bufferride = new BufferedReader(new FileReader(new File("PIN.txt")));
					String line2;
					 
					 boolean found = false;
					 boolean Accfound = false;
					 boolean blncfound = false;
				
					while ((line2 = bufferride.readLine()) != null) {
						
						   if (line2.startsWith("PIN")) {
							   
							   String Accno = line2.split(":")[1].trim().split(" ")[0];
							   String pin = line2.split(":")[1].trim().split(" ")[1];
		                      
				            if(Accno.equals(acno)) {
				            	System.out.println("Enter Your PIN");
								String checkpin = scan.nextLine();
								Accfound =true;
				            	if(checkpin.equals(pin)) {
				            					            	
									    found = true;
									    blncfound=true;
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
				if(blncfound) {
					boolean balance =false;
					BufferedReader reader = new BufferedReader(new FileReader("Amount.txt"));

					String line;

					while((line = reader.readLine()) != null){
						
					    if(line.startsWith("amount")){
					    	
					    	String Accno = line.split(":")[1].trim().split(" ")[0];
							   String Amount = line.split(":")[1].trim().split(" ")[1];
							   
					          if(Accno.equals(acno)) {
					        	  System.out.println("Balance Amount : "+Amount);
					        	  System.out.println();
					        	  balance =true;
					          }
				}
					}
					if (!balance) {
						System.out.println("Your Account is Not Found Because Amount was Not Deposite...!!!");
				        System.out.println();
				   }

					reader.close();
				}
				
			}catch (IOException k) {
			    System.out.println("Error occurred!");
			    k.printStackTrace();
			    }
		
	}
}
