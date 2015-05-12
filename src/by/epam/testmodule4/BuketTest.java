package by.epam.testmodule4;

import org.testng.annotations.Test;
import org.testng.Assert;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.exception.NameFlowerException;
import by.epam.exception.PriceFlowerException;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Plant;
import by.epam.readfromdb.ReadFromDB;
import by.epam.readfromxml.ParseXmlFile;
import by.epam.utils.TxtFileReader;

public class BuketTest {
	
	 @Test
	public void testBuketSumma() throws Exception{
		Buket bouq = ParseXmlFile.getBuketFromXML(ParseXmlFile.parsingXmlFile());
		Double summa = bouq.getSumma();
		Assert.assertEquals(60000.0, summa, "Correct summa");
	}
	 @Test
	public void checkNameBouquetFromXML() throws Exception{
		Buket bouq = ParseXmlFile.getBuketFromXML(ParseXmlFile.parsingXmlFile());
		Assert.assertEquals("ExampleXML", bouq.getNameBuket());
	}
	 @Test
	public void checkNameBouquetFromDB() throws Exception{
		Buket bouq = ReadFromDB.getBuketFromDB(ReadFromDB.getDBConnection());
		Assert.assertEquals("Test", bouq.getNameBuket());
	}
	 @Test
	public void testAddFlower() throws Exception{
		Buket bouq = new Buket ("TestNG");
		Plant plant = new Flower("Rosa", 50, 10000, Color.White, Freshness.OldFresh);
		Assert.assertEquals(true, bouq.addFl(plant));
	}
	
	
	
}
