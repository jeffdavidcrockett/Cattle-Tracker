package Cows;

import Data.DBConnect;

public class Cow 
{
	private int id;
	private String breed;
	private String birthdate;
	private String datePurchased;
	private String purchasedFrom;
	private boolean vaccines;
	private int mother;
	private int father;
	private String notes;
	
	public Cow(int id, String breed, String birthdate, String datePurchased, String purchasedFrom, 
			boolean vaccines, int mother, int father, String notes)
	{
		this.id = id;
		this.breed = breed;
		this.birthdate = birthdate;
		this.datePurchased = datePurchased;
		this.purchasedFrom = purchasedFrom;
		this.vaccines = vaccines;
		this.mother = mother;
		this.father = father;
		this.notes = notes;
	}
	
	public void writeCowToDb(DBConnect dbObj)
	{
		dbObj.insertCow(id, breed, birthdate, datePurchased, purchasedFrom,
				vaccines, mother, father, notes);
	}
	
	public void setDatePurchased(String month, String day, String year)
	{
		datePurchased = month + '-' + day + '-' + year;
	}
	
	public void setBirthdate(String date)
	{
		birthdate = date;
	}
	
	public void setVaccines(boolean state)
	{
		vaccines = state;
	}
	
	public void setMother(int mother)
	{
		this.mother = mother;
	}
	
	public void setFather(int father)
	{
		this.father = father;
	}
	
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getBreed()
	{
		return breed;
	}
	
	public String getBirthdate()
	{
		return birthdate;
	}
	
	public String getDatePurchased()
	{
		return datePurchased;
	}
	
	public String getPurchasedFrom()
	{
		return purchasedFrom;
	}
	
	public boolean getVaccines()
	{
		return vaccines;
	}
	
	public int getMother()
	{
		return mother;
	}
	
	public int getFather()
	{
		return father;
	}
	
	public String getNotes()
	{
		return notes;
	}
}
