package by.epam.testmodule4;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.exception.PriceFlowerException;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Plant;
import by.epam.readfromxml.ParseXmlFile;

public class ExceptionTest {

	 @Test (expectedExceptions = PriceFlowerException.class)
		public void verifyException() throws PriceFlowerException {
			Plant plant = new Flower("Rose", -50, -10000);
			}
	 
	 @Test(expectedExceptions = ArithmeticException.class)
		public void divisionWithException() {
			int i = 1 / 0;
		}
}
