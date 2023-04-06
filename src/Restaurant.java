package Foodie;

import java.util.ArrayList;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes
//4-6-2023 Elena Ilic: class populated to match diagram

public class Restaurant {
	private String storeName;
	private String storeRating;
	private ArrayList<Preferences> containsPrefs;
	private ArrayList<Food> menu;
	private ArrayList<Review> reviews;
	
	public void calculateRating() {
		//create a double to store average
		double avg = 0;
		//add each rating from review list to avg
		for (Review r : reviews) {
			avg += r.getRating();
		}
		//calculate avg
		return avg/reviews.size();
	}
	
	//adds a food preference to available preferences accommodated by restaurant
	public void addFoodPref(foodPref) {
		//may have duplicates, switch to set.
		containsPrefs.add(foodPref);
	}
	
	//adds a review to list of reviews
	public void addReview(Review review) {
		reviews.add(review);
	}

	//generic getters and setters
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreRating() {
		return storeRating;
	}

	public void setStoreRating(String storeRating) {
		this.storeRating = storeRating;
	}

	public ArrayList<Preferences> getContainsPrefs() {
		return containsPrefs;
	}

	public void setContainsPrefs(ArrayList<Preferences> containsPrefs) {
		this.containsPrefs = containsPrefs;
	}

	public ArrayList<Food> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Food> menu) {
		this.menu = menu;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}
