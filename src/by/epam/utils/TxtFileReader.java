package by.epam.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.exception.NameFlowerException;
import by.epam.model.Buket;

public class TxtFileReader {
	
	public TxtFileReader(){
		
	}
	
	public static void readLengthFromFile(Buket buket){
		int minLength = 0, maxLength = 0;
		try {
			 Scanner tt = new Scanner(new File("infoLength.txt"));
	         List<String> lines = new ArrayList<String>();
	         while (tt.hasNextLine()){	
	        	lines.add(tt.nextLine()); 
	         }
	         tt.close();
	         String [] numbers = lines.toArray(new String[lines.size()]);
	        	 try {
	        		 	minLength = Integer.parseInt(numbers[0]);
	        		 	maxLength = Integer.parseInt(numbers[1]);
	        		 	//System.out.println("minLength = "+minLength+" maxLength = "+maxLength);
	                } 
	        	 	catch (NumberFormatException e) {
	                    System.out.println("Incorrect symbol in the number "+e);
	                }
	        	 	catch (NegativeArraySizeException e){
	        	 		System.out.println("Incorrent buffer size "+e);
	        	 	}
	        	 buket.showFlowerByLength(minLength, maxLength);
	         
		 } catch (IOException e) {
				System.out.println("Cannot find file");
				System.out.println(e.getMessage());
				//e.printStackTrace();
		    }
		finally {
			if (minLength == 0 && maxLength ==0){
			System.out.println("\n----------------------------"+"" +
					" \n Please create file infoLength.txt and try again! \n----------------------------");
			}
		}
	}
	
	public static void findFlowerInFile(Buket buket) throws NameFlowerException{
		String nameFlower = "";
		Scanner nn  = new Scanner (System.in);
		System.out.println("Enter Name of flower");		
		nameFlower = nn.nextLine();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("infoBuket.txt"));
			String line;
			List<String> lines = new ArrayList<String>();
			while ((line = reader.readLine()) != null){
	            lines.add(line);
			}
			String [] names = lines.toArray(new String[lines.size()]);
			reader.close();
			boolean a = false;
			for (int i=0; i < names.length; i++){
			if (names[i].equals(nameFlower)){
				System.out.println("Buket = "+buket.getNameBuket()+" contains flower - "+nameFlower);
				a= true;
				}
			}	
			if (a == false) {
				throw new NameFlowerException ("Buket doesn't contain flower "+nameFlower);
			}
								
		} catch (IOException e) {
			System.out.println("Cannot find file");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}
	
}
