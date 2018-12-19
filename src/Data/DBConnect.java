package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBConnect 
{
	private String url = "jdbc:sqlite:cowss.db";
	private String tableName = "cows";
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	// constructor
	public DBConnect()
	{
		openConnection();
		createTable();
		closeConnection();
	}
	
	// Opens a connection to database
	public void openConnection() 
	{
		try
		{
			conn = DriverManager.getConnection(url);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	// Closes connection to database
	public void closeConnection()
	{
		try
		{
			if (stmt != null)
			{
				stmt.close();
			}
			if (pstmt != null)
			{
				pstmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	// Creates database table if it does not exist
	public void createTable()
	{
		try
		{
			stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS " + tableName + " (ID INTEGER, breed TEXT, "
					+ "datePurchased DATE, birthdate DATE, purchasedFrom TEXT, pricePaid TEXT, "
					+ "vaccines TEXT, motherID INTEGER, fatherID INTEGER, notes TEXT)");
			stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void insertCow(int id, String breed, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String notes)
	{
		String sql = "INSERT INTO " + tableName + "(ID, breed, datePurchased, birthdate, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, notes) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, breed);
			pstmt.setString(3, birthdate);
			pstmt.setString(4, datePurchased);
			pstmt.setString(5, purchasedFrom);
			pstmt.setString(6, price);
			pstmt.setString(7, vaccines);
			pstmt.setInt(8, mother);
			pstmt.setInt(9, father);
			pstmt.setString(10, notes);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}















