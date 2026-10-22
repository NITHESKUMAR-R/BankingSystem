package banckproject;

import java.io.*;
import java.util.*;



public class accdetils {

	public void accinfo(Scanner scan) {
		
		try{
			BufferedReader bufferride = new BufferedReader(new FileReader(new File("Account2.txt")));
			 System.out.println("Enter Your PhoneNo");
			 scan.nextLine();
		 String searchPhone =scan.nextLine();
			String line;

		    String name = "";
		    String Phone = "";
		    String address = "";
		    String dob = "";
		    String AccoNum = "";
		    String phone = "";
		    
		    
		    boolean found = false;

		    while ((line = bufferride.readLine()) != null) {

		        if (line.startsWith("Account Holder Name")) {
		            name = line;
		        }

		        else if (line.startsWith("Phone Number")) {
		        	Phone =line;
		            phone = line.split(":")[1].trim();
		        }

		        else if (line.startsWith("Account Holder Addres")) {
		            address = line;
		        }
		        else if (line.startsWith("Date OF Birth")) {
		            dob = line;
		        }


		        else if (line.startsWith("Account Number")) {
		        	AccoNum = line;

		            if (phone.equals(searchPhone)) {
		                System.out.println("--------------------------------");
		                System.out.println(name);
		                System.out.println(Phone);
		                System.out.println(address);
		                System.out.println(dob);
		                System.out.println( AccoNum);
		                System.out.println("--------------------------------");
		                System.out.println();

		                found = true;
		                break;
		            }
		        }
		    }

		    if (!found) {
		        System.out.println("Account Not Found");
		    }

		    bufferride.close();
		}
		catch (IOException e) {
		    System.out.println("Error occurred!");
		    e.printStackTrace();

		}	
	}
	
}
