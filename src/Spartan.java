package Foodie;

import java.util.ArrayList;

public class Spartan extends User{
	private int placesVisited;
	ArrayList<Preferences> foodPref = new ArrayList<>();
	

	public Spartan() {
		this.setUserID(null);
		this.foodPref.replaceAll(null);
		this.placesVisited = 0;
		//what more do we need? 
	}
	public Spartan(String userName, String password, Preferences[] foodiePref) {
		/*
		 * TODO parameterized constructor. idk what to put here yet.
		 */

 }
	public int getPlacesVisited() {
		return placesVisited;
	}

	public void setPlacesVisited(int placesVisited) {
		this.placesVisited = placesVisited;
	}

	public ArrayList<Preferences> getFoodPref() {
		return foodPref;
	}

	public void setFoodPref(ArrayList<Preferences> foodPref) {
		this.foodPref = foodPref;
	}
	
	public void addPreference(Preferences fp) {
		if(this.foodPref.contains(fp)) {
			System.out.println("Already added! Try again.");
		}else {
			this.foodPref.add(fp);
		}
	}
	
	@Override
	public String toString() {
		/*
		 * add 
		 */
		return "change later";
	}
}
