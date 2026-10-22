package banckproject;

import java.util.*;
import java.io.*;

public class pin {

	public void pingen(Scanner scan) {
		
      try {   
    	  System.out.println("Enter Your AC Number");
			scan.nextLine();
			String acno = scan.nextLine();
			
			BufferedReader bufferride = new BufferedReader(new FileReader(new File("Account2.txt")));
			 String line2;
			 String name = "";
			 String accNo2 = "";
			 
			 boolean found = false;
		
			while ((line2 = bufferride.readLine()) != null) {
				
				   if (line2.startsWith("Account Holder Name")) {

	                    name= line2.split(":")[1].trim();
	                }
				
				    if (line2.startsWith("Account Number")) {

		            accNo2 = line2.split(":")[1].trim();
                      
		            if(accNo2.equals(acno)) {
		            	  System.out.println("Account Found");
	                        System.out.println("Name : "+ name);
						    found = true;
			                break;
					}			            
				}	
			}
			if (!found) {
		        System.out.println("Account Not Found");
		   }
			bufferride.close();
		if(found) {
			ArrayList<String> pinData = new ArrayList<>();

			BufferedReader reader = new BufferedReader(new FileReader("PIN.txt"));

			String line;
			boolean updated = false;

			while((line = reader.readLine()) != null){
				
			    if(line.startsWith("PIN")){
			        String oldAcc = line.split(":")[1].trim().split(" ")[0];
			        if(oldAcc.equals(acno)){
			            System.out.println("Create New PIN");
			            int newPin = scan.nextInt();
			            pinData.add("PIN : " + acno + " " + newPin);
			            updated = true;
			        }
			        else{
			            pinData.add(line);
			        }
		}
			}

			reader.close();

			if(!updated){
			    System.out.println("Create PIN");
			    int newPin = scan.nextInt();
			    pinData.add("PIN : " + acno + " " + newPin);
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("PIN.txt"));

			for(String data : pinData){
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


