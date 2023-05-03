package foodie;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//5-1-2023 : Created by Elena Ilic

public class Foodie {
	public static ArrayList<Restaurant> foodieRestaurants = new ArrayList<>();
	public static ArrayList<User> foodieUsers = new ArrayList<>();;

	public static void main(String[] args) throws IOException {
		// set up data
		Scanner scanner1 = new Scanner(Paths.get("src/Foodie/restaurants.txt"), StandardCharsets.UTF_8.name());
		String restaurants = scanner1.useDelimiter("\\A").next();
		scanner1.close();

		// split the restaurant list
		String[] nameSeparation = restaurants.split("#");
		// convert into list
		ArrayList<String> rlist = new ArrayList<>();
		for (String s : nameSeparation) {
			rlist.add(s);
		}

		// create list to store args
		ArrayList<String[]> arg = new ArrayList<>();

		// Split restaurant into each portion
		for (String s : rlist) {
			arg.add(s.split("@"));
		}

		// Each restaurant is now split into a String array of arguments separated by
		// commas:
		// index 0: restaurant name
		// index 1: menu
		// index 2: prefs corresponding to menu (multiple prefs indicated with "+")
		// index 3: reviews

		// create Restaurant objects and populate restaurant list
		for (int s = 0; s < arg.size(); s++) {
			String name = arg.get(s)[0];

			// create arrays for menu items, corresponding prefs, and all reviews
			String[] foodNames = arg.get(s)[1].split(",");
			String[] prefNames = arg.get(s)[2].split(",");
			String[] reviews = arg.get(s)[3].split(",");

			// divide all preferences and add them to a list
			ArrayList<String[]> allPrefs = new ArrayList<>();
			for (String p : prefNames) {
				allPrefs.add(p.split("&"));
			}

			// convert all preferences to enum and add them to Preferences List
			ArrayList<Preferences[]> prefs = new ArrayList<>();
			for (String[] a : allPrefs) {
				int length = a.length;
				Preferences[] arr = new Preferences[length];

				for (int i = 0; i < length; i++) {
					arr[i] = Preferences.valueOf(a[i]);
				}

				prefs.add(arr);
			}

			// create menu
			ArrayList<Food> menu = new ArrayList<>();

			for (int j = 0; j < foodNames.length; j++) {
				menu.add(new Food(foodNames[j], prefs.get(j)));
			}

			// collect all preferences accomodated, ignoring duplicates
			HashSet<Preferences> uniquePrefs = new HashSet<>();

			// Go through all preferences and add it to set
			for (Preferences[] p : prefs) {
				for (Preferences p1 : p) {
					uniquePrefs.add(p1);
				}
			}

			// add unique prefs to an array for initialization
			Preferences[] restPrefs = new Preferences[uniquePrefs.size()];

			int k = 0;

			for (Preferences p : uniquePrefs) {
				restPrefs[k] = p;
				k++;
			}

			// create restaurant and add to list
			foodieRestaurants.add(new Restaurant(name, restPrefs, menu, reviews));
		}

		// Now intialize users list.
		Scanner scanner2 = new Scanner(Paths.get("src/Foodie/users.txt"), StandardCharsets.UTF_8.name());
		String users = scanner2.useDelimiter("\\A").next();
		scanner2.close();

		// separate user list
		String[] userSeparation = users.split("@");
		ArrayList<String> ulist = new ArrayList<>();

		for (String u : userSeparation) {
			ulist.add(u);
		}

		// Create list to store args
		ArrayList<String[]> arg2 = new ArrayList<>();

		// separate String into args and add to list
		for (String s : ulist) {
			arg2.add(s.split(","));
		}

		for (String[] d : arg2) {
			String username = d[0];
			String password = d[1];

			// create user prefs
			String[] userPrefs = d[2].split("&");

			// convert user prefs to enum
			Preferences[] uPrefs = new Preferences[userPrefs.length];

			for (int i = 0; i < userPrefs.length; i++) {
				uPrefs[i] = Preferences.valueOf(userPrefs[i]);
			}

			String fname = d[3];
			String lname = d[4];

			// create user and add to list
			User user = new Spartan(username, password, uPrefs);
			foodieUsers.add(user);
		
			
			
		}

		//TEST
		//User eilic = new Spartan("eilic","123Password!",new Preferences[]{Preferences.VEGAN}); 
		//HomeFrame h = new HomeFrame((Spartan)eilic);
		LoginFrame l = new LoginFrame();
		//new MenuFrame(Foodie.foodieRestaurants.get(0));
	}
}
