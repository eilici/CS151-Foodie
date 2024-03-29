package foodie;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class DataBase {

	public DataBase() throws IOException {

	}
	
	//update file when restaurant data is changed.
	public void updateRestaurants(File fileRestaurant) throws IOException {
		String update = "";
		int count = 1;
		for (Restaurant r : Foodie.foodieRestaurants) {
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
	public void updateUsers(File fileUsers) throws IOException {
		String update = "";
		int count = 1;
		for (User us : Foodie.foodieUsers) {
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
