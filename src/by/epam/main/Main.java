package by.epam.main;

import java.util.Scanner;

import by.epam.exception.NameFlowerException;
import by.epam.exception.PriceFlowerException;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Plant;
import by.epam.readfromdb.ReadFromDB;
import by.epam.readfromxml.ParseXmlFile;



public class Main {

	public static int  option;
	
	public static void main(String[] args) throws Exception, NameFlowerException, PriceFlowerException {
		
		try{
		Plant rose = new Flower("Rosa", -50, - 10000);
		System.out.println("price"+rose.getPrice());
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
			}
		
		
		ReadFromDB.getDBConnection();
		
		boolean repeat = true;
		Scanner in  = new Scanner (System.in);
		while (repeat){
			System.out.println("1. Read DATA from XML File");
			System.out.println("2. Read DATA from DB");
			System.out.println("0. ExiT");
			
			option = in.nextInt();
			
			switch (option){
			case 1:
				Buket buket1 = ParseXmlFile.getBuketFromXML(ParseXmlFile.parsingXmlFile());
				OptionRunner.runner(buket1);
				break;
				
			case 2: 
				Buket buket2 = ReadFromDB.getBuketFromDB(ReadFromDB.getDBConnection());
				OptionRunner.runner(buket2);
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
		in.close();
		
		
//		Buket buket1 = new Buket("Origin");
//		Plant rose1 = new Flower("Rosa", 50, 10000, Color.White, Freshness.OldFresh);
//		Plant mimoza = new Flower ("Mimoza", 30, 15000, Color.Yellow, Freshness.FullFresh);
//		Plant rose2 = new Flower ("Rosa", 100, 20000, Color.Red, Freshness.MiddleFresh);
//		Plant vetka1 = new Pine ("Vetka", 50, 10000, Freshness.OldFresh);
//		Plant list1 = new Pine("Leaf", 60, 5000, Color.Yellow, Freshness.FullFresh);
//		buket1.addFlower(rose1).addFlower(mimoza).addFlower(rose2).addFlower(vetka1).addFlower(list1);
		
	}
}




/*try {
Plant rose1 = new Flower("Rosa", -50, -10000, Color.White, Freshness.OldFresh);
buket1.addFlower(rose1);
} catch (PriceFlowerException e1) {
e1.printStackTrace();
}
catch (LengthFlowerException e2){
e2.printStackTrace();
}
try {
Plant rose2 = new Flower("Rosa", -50, 10000, Color.White, Freshness.OldFresh);
buket1.addFlower(rose2);
} catch (PriceFlowerException e1) {
e1.printStackTrace();
}
catch (LengthFlowerException e2){
e2.printStackTrace();
}

try {
Plant rose3 = new Flower("Rosa", 50, 10000, Color.White, Freshness.OldFresh);
buket1.addFlower(rose3);
} catch (PriceFlowerException e1) {
e1.printStackTrace();
}
catch (LengthFlowerException e2){
e2.printStackTrace();
}

try {
Plant mimoza = new Flower ("Mimoza", 30, 15000, Color.Yellow, Freshness.FullFresh);
buket1.addFlower(mimoza);
} catch (PriceFlowerException e1) {
e1.printStackTrace();
}
catch (LengthFlowerException e2){
e2.printStackTrace();
}
try {
Plant rose2 = new Flower ("Rosa", 100, 20000, Color.Red, Freshness.MiddleFresh);
buket1.addFlower(rose2);
} catch (PriceFlowerException e1) {
e1.printStackTrace();
} 
catch (LengthFlowerException e2){
e2.printStackTrace();
}*/
