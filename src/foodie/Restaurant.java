package foodie;

import java.util.ArrayList;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes
//4-6-2023 Elena Ilic: class populated to match diagram
//4-30-2023 Elena Ilic: fixed calculateRating, addFoodPref, remove setStoreRating
//5-1-2-23 Elena Ilic: remove rating + methods related, replace Review with String
//5-3-29023 Elena Ilic: fix toStrinf, make former toString into write file

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

	public String writeData() {
		String str = storeName + "@";

		int i = 1;
		for (Food f : menu) {
			if (i == 1) {
				str = str + f.getName();
			} else {
				str = str + "," + f.getName();
			}
			i++;
		}
		str = str + "@";

		int j = 1;
		for (Food f : menu) {
			if (j == 1) {
				int k = 1;
				for (Preferences p : f.getFoodPref()) {
					if (k == 1) {
						str = str + p.toString();
					} else {
						str = str + "&" + p.toString();
					}
					k++;
				}

			} else {
				str = str + "," ;
				int l = 1;
				for (Preferences p : f.getFoodPref()) {
					if (l == 1) {
						str = str + p.toString();
					} else {
						str = str + "&" + p.toString();
					}
					l++;
				}

			}
			j++;
		}
		str = str + "@";
		int m =1;
		
		for (String r : reviews) {
			if (m==1) {
				str = str + r;
			}
			else {
				str = str + "," + r;
			}
			m++;
		}
		return str;
	}

	public String toString() {
		return this.getStoreName();
	}

	public void addFood(Food food) {
		if (this.menu.contains(food)) {
			System.out.println("Food already in the restaurants menu.");
		} else {
			this.menu.add(food);
		}
	}

}