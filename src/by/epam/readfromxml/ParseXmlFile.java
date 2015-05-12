package by.epam.readfromxml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Pine;
import by.epam.model.Plant;

public class ParseXmlFile {
	
	public static Document parsingXmlFile() throws Exception{
		try { 
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setNamespaceAware(true);
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = (Document) dBuilder.parse(new File("Buket_XML.xml"));
			return document;
		
		}catch (Exception e){
			String message = "XML parsing error!";
			e.printStackTrace();
			throw new Exception (message);
		}
	}
	
	public static Buket getBuketFromXML (Document doc){
		doc.getDocumentElement().normalize();
		Element root = (Element) doc.getDocumentElement();
		NodeList nl = root.getElementsByTagName("item");
		Buket myBuket = new  Buket ("ExampleXML");
		if (nl != null && nl.getLength() > 0){
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				Plant plt = getPlantFromXML(el);
				myBuket.addFlower(plt);	
			}
		}
		return myBuket;
	}
	
	public static Plant getPlantFromXML (Element plantEl){
		String name = getTextValue(plantEl, "name");
		int length = Integer.parseInt(getTextValue(plantEl,"length"));
		double price = Double.parseDouble(getTextValue(plantEl,"price"));
		Color color = Color.getColor(getTextValue(plantEl,"color"));
		Freshness fresh = Freshness.getFresh(getTextValue(plantEl,"fresh"));
		String type = plantEl.getAttribute("type");
		Plant pl1 = null;
		if (type.equals("Flower")){
			pl1 = new Flower(name, length, price, color, fresh);
		}
		if (type.equals("Pine")) {
			if (color == null){
				pl1 = new Pine(name, length, price, fresh);
			}
			else
			pl1 = new Pine (name, length, price, color, fresh);
		}
		Plant plant = pl1;
		return plant;
	}
	
	public static String getTextValue (Element plantEl, String tagName){
		String textValue = null;
		NodeList noteList = plantEl.getElementsByTagName(tagName);
		if (noteList != null && noteList.getLength() > 0){
			Element element = (Element) noteList.item(0);
			textValue = element.getFirstChild().getNodeValue();
		}
		return textValue;
	}
		
	public static void printData(){
		
	}
}
