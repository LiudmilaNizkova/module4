package by.epam.main;

import java.io.File;
import java.util.Scanner;

import by.epam.exception.NameFlowerException;
import by.epam.model.Buket;
import by.epam.utils.TxtFileReader;

public class OptionRunner {
	
	public OptionRunner(Buket buket){
		
	}
	
	static void runner(Buket buket) throws NameFlowerException{
		int action;
		boolean repeat = true;
		Scanner in  = new Scanner (System.in);
		
		while (repeat){
			System.out.println("1. Show info buket");
			System.out.println("2. Sort flowers by freshness");
			System.out.println("3. Show flowers by lenght");
			System.out.println("4. Show flowers by price");
			System.out.println("5. Find flower by Name");
			System.out.println("0. Exit");
			
			action = in.nextInt();
			
			switch (action){
			case 1: 
				buket.showInfoBuket();
				break;
				
			case 2:
				buket.sortFlowerByFresh();
				break;
				
			case 3:
				TxtFileReader.readLengthFromFile(buket);
				break;
				
			case 4:
				buket.sortFlowerByPrice();
				break;
				
			case 5:
				TxtFileReader.findFlowerInFile(buket);
				break;
				
			case 0:
				repeat = false;
				System.out.println("Exit!");
				break;
				
			default: 
				System.out.println("Incorrect value! Please, try again!");
				break;
				
			}
			
		}
//		in.close();
	}
}
