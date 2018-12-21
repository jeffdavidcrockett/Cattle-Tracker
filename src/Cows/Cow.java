package Cows;

import Data.DBConnect;

public class Cow 
{
	protected int id;
	protected String breed;
	protected String gender;
	protected String birthdate;
	protected String datePurchased;
	protected String purchasedFrom;
	protected String price;
	protected String vaccines;
	protected int mother;
	protected int father;
	protected String notes;
	
	public Cow(int id, String breed, String gender, String birthdate, String datePurchased, String purchasedFrom, 
			String price, String vaccines, int mother, int father, String notes)
	{
		this.id = id;
		this.breed = breed;
		this.gender = gender;
		this.birthdate = birthdate;
		this.datePurchased = datePurchased;
		this.purchasedFrom = purchasedFrom;
		this.price = price;
		this.vaccines = vaccines;
		this.mother = mother;
		this.father = father;
		this.notes = notes;
	}
	
	public void setDatePurchased(String month, String day, String year)
	{
		datePurchased = month + '-' + day + '-' + year;
	}
	
	public void setBirthdate(String date)
	{
		birthdate = date;
	}
	
	public void setVaccines(String state)
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
	
	public String getVaccines()
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
