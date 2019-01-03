package Data;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	private String url = "jdbc:sqlite:cowss.db";
	private String currentCowsTable = "currentCows";
	private String pastCowsTable = "pastCows";
	private String generalExpensesTable = "generalExpenses";
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	// constructor
	public DBConnect() {
		openConnection();
		createCurrentCowsTable();
		createPastCowsTable();
		createGeneralExpensesTable();
		closeConnection();
	}
	
	// Opens a connection to database
	public void openConnection() {
		try {
			conn = DriverManager.getConnection(url);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Closes connection to database
	public void closeConnection() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Creates database table if it does not exist
	public void createCurrentCowsTable() {
		try {
			stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS " + currentCowsTable + " (ID INTEGER, breed TEXT, "
					+ "gender TEXT, datePurchased TEXT, birthdate TEXT, purchasedFrom TEXT, pricePaid TEXT, "
					+ "vaccines TEXT, motherID INTEGER, fatherID INTEGER, castrated TEXT, notes TEXT)");
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createPastCowsTable() {
		try {
			stmt = conn.createStatement();
			stmt.execute("CREATE TABLE IF NOT EXISTS " + pastCowsTable + " (ID INTEGER, breed TEXT, "
					+ "gender TEXT, datePurchased TEXT, birthdate TEXT, purchasedFrom TEXT, pricePaid TEXT, "
					+ "vaccines TEXT, motherID INTEGER, fatherID INTEGER, castrated TEXT, notes TEXT, soldFor TEXT, "
					+ "soldTo TEXT)");
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createGeneralExpensesTable() {
		try {
		stmt = conn.createStatement();
		stmt.execute("CREATE TABLE IF NOT EXISTS " + generalExpensesTable + " (year TEXT, type TEXT, pricePer TEXT, totalCost TEXT)");
		stmt.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertBullIntoCurrent(int id, String breed, String gender, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String castrated, String notes) {
		String sql = "INSERT INTO " + currentCowsTable + " (ID, breed, gender, birthdate, datePurchased, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, castrated, notes) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try {
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
			pstmt.setString(11, castrated);
			pstmt.setString(12, notes);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public void insertHefferIntoCurrent(int id, String breed, String gender, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String notes) {
		String sql = "INSERT INTO " + currentCowsTable + "(ID, breed, gender, datePurchased, birthdate, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, notes) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try {
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
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public void insertBullIntoPast(int id, String breed, String gender, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String castrated, 
			String notes, String soldFor, String soldTo) {
		String sql = "INSERT INTO " + pastCowsTable + " (ID, breed, gender, birthdate, datePurchased, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, castrated, notes, soldFor, soldTo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try {
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
			pstmt.setString(11, castrated);
			pstmt.setString(12, notes);
			pstmt.setString(13, soldFor);
			pstmt.setString(14, soldTo);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public void insertHefferIntoPast(int id, String breed, String gender, String birthdate, String datePurchased, 
			String purchasedFrom, String price, String vaccines, int mother, int father, String notes, 
			String soldFor, String soldTo) {
		String sql = "INSERT INTO " + pastCowsTable + " (ID, breed, gender, birthdate, datePurchased, purchasedFrom, pricePaid, "
				+ "vaccines, motherID, fatherID, notes, soldFor, soldTo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		openConnection();
		try {
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
			pstmt.setString(12, soldFor);
			pstmt.setString(13, soldTo);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public void deleteRowFromCurrent(int id) {
		String sql = "DELETE FROM " + currentCowsTable + " WHERE ID = ?";
		
		openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public void deleteRowFromPast(int id) {
		String sql = "DELETE FROM " + pastCowsTable + " WHERE ID = ?";
		
		openConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public int getTotalCows() {
		int numOfCows = 0;
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM currentCows");
			if (!rs.isBeforeFirst()) {
				numOfCows = 0;
			}
			else {
				numOfCows = rs.getInt("total");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return numOfCows;
	}
	
	public int getMaleCount() {
		int maleCount = 0;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM currentCows WHERE gender = 'Male'");
			if (!rs.isBeforeFirst()) {
				maleCount = 0;
			}
			else {
				maleCount = rs.getInt("total");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return maleCount;
	}
	
	public ArrayList<String> getTotalExpenses(String year) {
		ArrayList<String> expenseList = new ArrayList<String>();
		String sql = "SELECT pricePaid FROM currentCows WHERE datePurchased LIKE '%" + year + "%' UNION ALL"
				+ " SELECT pricePaid FROM pastCows WHERE datePurchased LIKE '%" + year + "%' UNION ALL "
						+ "SELECT totalCost FROM generalExpenses WHERE year = " + year;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				expenseList = null;
			}
			else {
				while (rs.next()) {
					expenseList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return expenseList;
	}
	
	public ArrayList<String> getCowCosts(String year) {
		ArrayList<String> costList = new ArrayList<String>();
		String sql = "SELECT pricePaid FROM currentCows WHERE datePurchased LIKE '%" + year + "%' UNION ALL SELECT "
				+ "pricePaid FROM pastCows WHERE datePurchased LIKE '%" + year + "%'";
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				costList = null;
			}
			else {
				while (rs.next()) {
					costList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return costList;
	}
	
	public ArrayList<String> getCurrentCowsCost() {
		ArrayList<String> costList = new ArrayList<String>();
		String sql = "SELECT pricePaid FROM " + currentCowsTable;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				costList = null;
			}
			else {
				while (rs.next()) {
					costList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return costList;
	}
	
	public HashMap<String, ArrayList> getRow(int id) {
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		HashMap<String, ArrayList> sqlRowData = new HashMap<String, ArrayList>();
		boolean controlVar = false;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + currentCowsTable + " WHERE ID = " + id);
			if (!rs.isBeforeFirst()) {
				controlVar = false;
			}
			else {
				int cowId = rs.getInt("ID");
				String breed = rs.getString("breed");
				String gender = rs.getString("gender");
				String datePurchased = rs.getString("datePurchased");
				String birthdate = rs.getString("birthdate");
				String purchasedFrom = rs.getString("purchasedFrom");
				String pricePaid = rs.getString("pricePaid");
				String vaccines = rs.getString("vaccines");
				int motherId = rs.getInt("motherId");
				int fatherId = rs.getInt("fatherId");
				String castrated = rs.getString("castrated");
				String notes = rs.getString("notes");
				
				sqlRowData.put("strings", stringList);
				sqlRowData.put("integers", intList);
				
				sqlRowData.get("strings").add(breed);
				sqlRowData.get("strings").add(gender);
				sqlRowData.get("strings").add(datePurchased);
				sqlRowData.get("strings").add(birthdate);
				sqlRowData.get("strings").add(purchasedFrom);
				sqlRowData.get("strings").add(pricePaid);
				sqlRowData.get("strings").add(vaccines);
				sqlRowData.get("strings").add(castrated);
				sqlRowData.get("strings").add(notes);
				sqlRowData.get("integers").add(cowId);
				sqlRowData.get("integers").add(motherId);
				sqlRowData.get("integers").add(fatherId);
				
				controlVar = true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		if (controlVar == true) {
			return sqlRowData;
		}
		else {
			return null;
		}
	}
	
	public void writeGeneralExpense(String year, String expenseType, String pricePer, String total) {
		String sql = "INSERT INTO " + generalExpensesTable + " (year, type, pricePer, totalCost) VALUES(?,?,?,?)";
		
		openConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, year);
			pstmt.setString(2, expenseType);
			pstmt.setString(3, pricePer);
			pstmt.setString(4, total);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
	}
	
	public ArrayList<String> getHayPrices(String year) {
		ArrayList<String> priceList = new ArrayList<String>();
		String sql = "SELECT pricePer FROM " + generalExpensesTable + " WHERE type = 'Hay' AND year = " + year;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				priceList = null;
			}
			else {
				while (rs.next()) {
					priceList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return priceList;
	}
	
	public ArrayList<String> getTotalFeedCosts(String year) {
		ArrayList<String> costList = new ArrayList<String>();
		String sql = "SELECT totalCost FROM " + generalExpensesTable + " WHERE type = 'Feed' AND year = " + 
		year + " OR type = 'Hay' AND year = " + year;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				costList = null;
			}
			else {
				while (rs.next()) {
					costList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return costList;
	}
	
	public ArrayList<String> getTotalVetCosts(String year) {
		ArrayList<String> costList = new ArrayList<String>();
		String sql = "SELECT totalCost FROM " + generalExpensesTable + " WHERE type = 'Vet' AND year = " + year;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				costList = null;
			}
			else {
				while (rs.next()) {
					costList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return costList;
	}
	
	public ArrayList<String> getTotalEquipmentCosts(String year) {
		ArrayList<String> costList = new ArrayList<String>();
		String sql = "SELECT totalCost FROM " + generalExpensesTable + " WHERE type = 'Equipment' AND year = " + year;
		
		openConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.isBeforeFirst()) {
				costList = null;
			}
			else {
				while (rs.next()) {
					costList.add(rs.getString(1));
				}
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		closeConnection();
		
		return costList;
	}
}