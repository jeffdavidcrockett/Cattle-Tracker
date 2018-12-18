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
			stmt.execute("CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER, breed TEXT, "
					+ "datePurchased DATE, birthdate DATE, purchasedFrom TEXT, vaccines TEXT, mother INTEGER,"
					+ "father INTEGER, notes TEXT)");
			stmt.close();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void insertCow(int id, String breed, String birthdate, String datePurchased, 
			String purchasedFrom, boolean vaccines, int mother, int father, String notes)
	{
		String sql = "INSERT INTO " + tableName + "(id, breed, datePurchased, birthdate, purchasedFrom, "
				+ "vaccines, mother, father, notes) VALUES(?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, breed);
			pstmt.setString(3, birthdate);
			pstmt.setString(4, datePurchased);
			pstmt.setString(5, purchasedFrom);
			pstmt.setBoolean(6, vaccines);
			pstmt.setInt(7, mother);
			pstmt.setInt(8, father);
			pstmt.setString(9, notes);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}















