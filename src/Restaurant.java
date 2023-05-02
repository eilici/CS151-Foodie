package Foodie;

import java.util.ArrayList;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes
//4-6-2023 Elena Ilic: class populated to match diagram
//4-30-2023 Elena Ilic: fixed calculateRating, addFoodPref, remove setStoreRating
//5-1-2-23 Elena Ilic: remove rating + methods related, replace Review with String

public class Restaurant {
	private String storeName;
	private ArrayList<Preferences> containsPrefs;
	private ArrayList<Food> menu;
	private ArrayList<String> reviews;

	public Restaurant(String storeName, Preferences[] containsPrefs, ArrayList<Food> menu, String[] reviews) {

		this.storeName = storeName;

		this.containsPrefs = new ArrayList<>();
		for (Preferences p : containsPrefs) {
			this.containsPrefs.add(p);
		}
		this.menu = menu;

		this.reviews = new ArrayList<>();
		for (String r : reviews) {
			this.reviews.add(r);
		}
	}

	// adds a food preference to available preferences accommodated by restaurant
	public void addFoodPref(Preferences foodPref) {
		// may have duplicates, switch to set.
		containsPrefs.add(foodPref);
	}

	// adds a review to list of reviews
	public void addReview(String review) {
		reviews.add(review);
	}

	// generic getters and setters
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public ArrayList<String> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		String str= storeName + "@";
		for (Food f: menu) {
			str = str + f.getName() + ",";
		}
		str = str +"@";
		for (Food f: menu) {
			for (Preferences p:f.getFoodPref()) {
				str = str + p.toString() + "&";
			}
			str = str + ",";
		}
		str = str +"@";
		for (String r: reviews) {
			str = str + r + ",";
		}
		return str;
	}

	public void addFood(Food food) {
		if (this.menu.contains(food)) {
			System.out.println("Food already in the restaurants menu.");
		} else {
			this.menu.add(food);
		}
	}

}
