package Foodie;

import java.util.ArrayList;

public class Food {
	private String name;
	private ArrayList<Preferences> foodPref;

	
	public Food(String name, Preferences[] foodPref) {
		super();
		this.name = name;
		this.foodPref = new ArrayList<>();
		for (Preferences p: foodPref) {
			this.foodPref.add(p);
		}
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Preferences> getFoodPref() {
		return foodPref;
	}


	public void setFoodPref(ArrayList<Preferences> foodPref) {
		this.foodPref = foodPref;
	}

	public void addFoodPref(Preferences fp) {
		if(!this.foodPref.contains(fp)) {
			foodPref.add(fp);
		}else {
			System.out.println("Food Preference already added");
		}
	}
}
