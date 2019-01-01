package Cows;

import Data.DBConnect;

public class Heffer extends Cow {
	private int amountOfBabies;
	
	public Heffer(int id, String breed, String gender, String birthdate, String datePurchased, String purchasedFrom, 
			String price, String vaccines, int mother, int father, String notes) {
		super(id, breed, gender, birthdate, datePurchased, purchasedFrom, price, vaccines, mother, father, notes);
	}
	
	public void writeHefferToCurrentDb(DBConnect dbObj) {
		dbObj.insertHefferIntoCurrent(id, breed, gender, birthdate, datePurchased, purchasedFrom,
				price, vaccines, mother, father, notes);
	}
	
	public void writeHefferToPastDb(DBConnect dbObj, String priceSoldFor, String soldTo) {
		dbObj.insertHefferIntoPast(id, breed, gender, birthdate, datePurchased, purchasedFrom,
				price, vaccines, mother, father, notes, priceSoldFor, soldTo);
	}
	
	public void setAmountOfBabies(int numOfBabies) {
		amountOfBabies = numOfBabies;
	}
	
	public int getAmountOfBabies() {
		return amountOfBabies;
	}
}
