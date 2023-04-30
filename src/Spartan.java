package Foodie;

import java.util.ArrayList;
import java.util.Arrays;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes, getters, setters
//4-6-2023 Elena Ilic: Parameterized constructor, more attributes, writeReview
import java.util.List;

public class Spartan extends User{
	private int placesVisited;
	List<Preferences> foodPref = new ArrayList<>();
	String userName;
	String password;
	ArrayList<Review> prevReviews;

	public Spartan() {
		this.setUserID(null);
		this.foodPref.replaceAll(null);
		this.placesVisited = 0;
		prevReviews = new ArrayList<>();
	}
	
	public Spartan(String userName, String password, Preferences[] foodPref) {
		this.userName = userName;
		this.password = password;
		this.foodPref = Arrays.asList(foodPref);
		prevReviews = new ArrayList<>();
	 }
	
	//write a review and add it to the list of reviews of a restaurant
	public void writeReview(Food food, Restaurant restaurant, String review, double rating, Preferences[] prefs){
		//create a new object from parameters given by user
		Review r = new Review(review, rating);
		
		//adds review to restaurant and updates its rating
		restaurant.addReview(r);
		restaurant.calculateRating();
		
		//adds food preferences to lists for overall restaurant AND food
		for (Preferences p: prefs){
			restaurant.addFoodPref(p);
			food.addFoodPref(p);
			
		}
	}
	
	public int getPlacesVisited() {
		return placesVisited;
	}

	public void setPlacesVisited(int placesVisited) {
		this.placesVisited = placesVisited;
	}

	public List<Preferences> getFoodPref() {
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
