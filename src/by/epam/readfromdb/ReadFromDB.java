package by.epam.readfromdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Pine;
import by.epam.model.Plant;

public class ReadFromDB {
	
	public ReadFromDB(){
		
	}

	public static ResultSet getDBConnection() throws ClassNotFoundException, SQLException{
		 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		 Connection m_connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Liudmila_Nizkova@epam.com/Documents/DBPlant.accdb");
		 Statement m_statement = m_connection.createStatement();
		 String query = "SELECT * FROM Plant";
		 ResultSet m_resultSet = m_statement.executeQuery(query);
		 return m_resultSet;
	}
	
	public static Buket getBuketFromDB(ResultSet m_resSet) throws SQLException{
		String name = null;
		int length =0;
		double price = 0;
		Color color = null;
		Freshness fresh = null;
		Plant plant = null;
		Buket myBuket1 = new  Buket ("ExampleDB");
		while (m_resSet.next()) {
			name = m_resSet.getString("name");
			length = m_resSet.getInt("length");
			price = m_resSet.getDouble("price");
			color = Color.getColor(m_resSet.getString("color"));
			fresh = Freshness.getFresh(m_resSet.getString("fresh"));
			if (m_resSet.getString("category").equals("Flower") ){
				plant = new Flower(name, length, price, color, fresh); 
			}
			if (m_resSet.getString("category").equals("Pine")){
				if (color == null){
					plant = new Pine(name, length, price, fresh);
				}
				else
					plant = new Pine (name, length, price, color, fresh);
			}

			myBuket1.addFlower(plant);	
		    }

		return myBuket1;
	}
	
}
