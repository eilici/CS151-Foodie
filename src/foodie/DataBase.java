package foodie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class DataBase {

	public static ArrayList<Restaurant> foodieRestaurants = new ArrayList<>();
	public static ArrayList<User> foodieUsers = new ArrayList<>();;
	private FileViewer uR;
	private FileViewer uU;
	private File fileRestaurant;
	private File fileUsers;

	public DataBase() throws IOException {
		// set up data
		fileRestaurant = new File("src/foodie/restaurants.txt");
		FileViewer uR = new FileViewer(fileRestaurant);

		String restaurants = uR.getFileString();

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

		fileUsers = new File("src/foodie/users.txt");
		FileViewer uU = new FileViewer(fileUsers);

		String users = uU.getFileString();

		// separate user list
		String[] userSeparation = users.split(" @ ");
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

			// create user and add to list
			User user = new Spartan(username, password, uPrefs);
			foodieUsers.add(user);

		}

	}
	
	//update file when restaurant data is changed.
	public void updateRestaurants() throws IOException {
		String update = "";
		int count = 1;
		for (Restaurant r : DataBase.foodieRestaurants) {
			if (count == 1) {
				update = update + (r.writeData());
			} else {
				update = update + " # " + (r.writeData());
			}

			count++;
		}

		FileWriter fw = new FileWriter(fileRestaurant, false);
		fw.write(update);
		fw.close();
	}

	//update file when user data is changed.
	public void updateUsers() throws IOException {
		String update = "";
		int count = 1;
		for (User us : DataBase.foodieUsers) {
			if (count == 1) {
				update = update + ((Spartan) us).writeData();
			} else {
				update = update + " @ " + ((Spartan) us).writeData();
			}

			count++;
		}

		FileWriter fw = new FileWriter(fileUsers, false);
		fw.write(update);
		fw.close();
	}

}
