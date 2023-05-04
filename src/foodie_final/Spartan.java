package foodie;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
//EDIT HISTORY:
//3-28-2023 Robert Veloya: uploaded class with attributes, getters, setters
//4-6-2023 Elena Ilic: Parameterized constructor, more attributes, writeReview
//4-30-2023 remove prev reviews
import java.util.List;

public class Spartan extends User {
	private List<Preferences> foodPref;
	private String userName;
	private String password;

	public Spartan() {
		this.setUserID(null);
		this.foodPref.replaceAll(null);
	}

	public Spartan(String userName, String password, Preferences[] foodPref) {
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
	public String toString() {
		String str = "Username: " + userName + "\nPreferences: " + foodPref;
		return str;
	}

	public String writeData() {
		String str = (this.getUserName() + "," + this.getPassword() + ",");

		int count = 1;
		for (Preferences p : this.getFoodPref()) {
			if (count == 1) {
				str = str + p.toString();
			}
			else {
				str = str +"&"+p.toString();
			}
			count++;
		}
		
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

	public void setFoodPref(List<Preferences> foodPref) {
		this.foodPref = foodPref;
	}

//	public void writeToFile(File f) {
//		String content = new String(Files.readAllBytes(Paths.get(f)));
//		String prefs = new String("");
//		
//		int count = 1;
//		for (Preferences p : this.getFoodPref()) {
//			if (count == 1) {
//				prefs.concat(p.toString());
//			}
//			else {
//				prefs.concat("&" + prefs.toString());
//			}
//			f.
//		}
//		
//		if (content.equals("")){
//			f.append(this.getUserName() + " , " + this.getPassword() + " , " );
//		}
//		f.append(this.getUserName() + " , " + this.getPassword() + " , " );
//	}

}