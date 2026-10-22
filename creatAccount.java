package banckproject;

import java.util.*;
import java.io.*;


public class creatAccount {
	
	public void creatacc(Scanner scan) {
		int accNumber =0;
	try {
		
		    File f = new File("AccNo.txt");

		    BufferedReader read = new BufferedReader(new FileReader(f));
		    String value = read.readLine();
		    accNumber = Integer.parseInt(value);
		    read.close();
		    
		    accNumber++;
		    BufferedWriter w = new BufferedWriter(new FileWriter(f));

		    w.write(String.valueOf(accNumber));

		    w.close();
		}
		catch(IOException e) {

		    System.out.println("Error");
		    e.printStackTrace();

		  }
		
	try {
		scan.nextLine();
		System.out.println("Enter Your Name");
		String name = scan.nextLine();
		System.out.println("Enter Phone Number");
		String phoNo = scan.nextLine();
		System.out.println("Enter Your Addres");
		String addres = scan.nextLine();
		System.out.println("Enter Your DOB (example :dd/mm/yyyy )");
		String DOB = scan.nextLine();
		System.out.println("Account Created Succesfully");
		
		
		
	    File file = new File("Account2.txt");  
		
		BufferedWriter write = new BufferedWriter(new FileWriter(file ,true));
		
		write.write("Account Holder Name : "+name+"\n");
		write.write("Phone Number : "+phoNo+"\n");
		write.write("Account Holder Addres : "+addres+"\n");
		write.write("Date OF Birth : "+DOB+"\n");
		write.write("Account Number : "+"345800000"+accNumber+"\n");
		write.write("----------------------------\n");
	  write.close();
	  
	}catch(IOException a){
		System.out.println("Error Occurred");
		a.printStackTrace();
	}

	}
  }

