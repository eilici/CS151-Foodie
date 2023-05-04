package foodie;

import java.util.ArrayList;
import java.util.Arrays;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes, getters, setters
//4-6-2023 Elena Ilic: Parameterized constructor, more attributes, writeReview
//4-30-2023 remove prev reviews
import java.util.List;

public class Spartan extends User {
	private List<ArrayList<Preferences>> foodPref;
	private String userName;
	private String password;

	public Spartan() {
		this.setUserID(null);
		this.foodPref.replaceAll(null);
	}

	public Spartan(String userName, String password, ArrayList<Preferences> foodPref) {
		this.userName = userName;
		this.password = password;
		this.foodPref = Arrays.asList(foodPref);
	}

	// write a review and add it to the list of reviews of a restaurant
	public void writeReview(Food food, Restaurant restaurant, String review, Preferences[] prefs) {
		// adds review to restaurant
		restaurant.addReview(review);

		// adds food preferences to lists for overall restaurant AND food
		for (Preferences p : prefs) {
			restaurant.addFoodPref(p);
			food.addFoodPref(p);

		}
	}

	public List<Preferences> getFoodPref() {
		return foodPref;
	}

	public void setFoodPref(ArrayList<Preferences> foodPref) {
		this.foodPref = foodPref;
	}

	public void addPreference(Preferences fp) {
		if (this.foodPref.contains(fp)) {
			System.out.println("Already added! Try again.");
		} else {
			this.foodPref.add(fp);
		}
	}

	@Override
	public String toString() 
	{
		String str = "Username: " + userName + "\nPreferences: " + foodPref;
		return str;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFoodPref(List<ArrayList<Preferences>> foodPref) {
		this.foodPref = foodPref;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Preferences> preference = new ArrayList<Preferences>();
		preference.add(Preferences.VEGAN);
		Spartan test = new Spartan("mdnekkar", "2342323", preference);
		
		System.out.println(test.toString());
	}
}
