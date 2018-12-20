package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
					+ "gender TEXT, datePurchased DATE, birthdate DATE, purchasedFrom TEXT, pricePaid TEXT, "
					+ "vaccines TEXT, motherID INTEGER, fatherID INTEGER, notes TEXT)");
			stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void insertCow(int id, String breed, String gender, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String notes)
	{
		String sql = "INSERT INTO " + tableName + "(ID, breed, gender, datePurchased, birthdate, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, notes) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, breed);
			pstmt.setString(3, gender);
			pstmt.setString(4, birthdate);
			pstmt.setString(5, datePurchased);
			pstmt.setString(6, purchasedFrom);
			pstmt.setString(7, price);
			pstmt.setString(8, vaccines);
			pstmt.setInt(9, mother);
			pstmt.setInt(10, father);
			pstmt.setString(11, notes);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public int getTotalCows()
	{
		int numOfCows = 0;
		
		openConnection();
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM cows");
			numOfCows = rs.getInt("total");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return numOfCows;
	}
	
	public int getMaleCount()
	{
		int maleCount = 0;
		
		openConnection();
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM cows WHERE gender = 'Male'");
			maleCount = rs.getInt("total");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return maleCount;
	}
}















