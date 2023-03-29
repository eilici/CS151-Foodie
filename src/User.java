package Foodie;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
	private String userName;
	private String userID;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public User() {
		/*
		 * non parameterized constructor
		 */
	}
	/*
	 * Parameterized constructor checks if the userName and password is valid first before creating an instance of it. 
	 * Does nothing and returns a statement of error if invalid input is used.
	 */
	public User(String firstName, String lastName, String userName, String password) {
		if(userNameChecker(userName) && passwordChecker(password)) {
			this.userName = userName;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userID = generateID();
		}else if (!passwordChecker(password)){
			System.out.println("Password invalid, please try again.");
		}else if (!userNameChecker(userName)){
			System.out.println("userName invalid, please try again.");
		}else {
			System.out.println("Error 404 : idfk what happened lol.");
		}
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/*
	 * sourced from : https://www.geeksforgeeks.org/how-to-validate-a-username-using-regular-expressions-in-java/
	 */
	public boolean userNameChecker(String userName) {
		/*
		 * regex to check valid username
		 */
		String regex = "^[A-Za-z]\\w{11,15}$";
		
		/*
		 * compile from regex class
		 */
		Pattern p = Pattern.compile(regex);
		
		/*
		 * if username is empty, return false
		 */
		if(userName == null) {
			return false;
		}
		/* 
		 * pattern class contains matcher() method
		 * to find matching between given username 
		 * and regular expression 
		 */
		Matcher m  = p.matcher(userName);
		/*
		 * return if the username matched the regex
		 */
		return m.matches();
	}
	
	/*
	 * checks the validity of the password, used similar logic to method above.
	 */
	public boolean passwordChecker(String password) {
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		if(password == null) {
			return false;
		}
		
		Matcher m = p.matcher(password);
		
		return m.matches();
	}
	
	public void login(String username, String password) {
		/*
		 * add code later
		 */
	}
	
	public String generateID() {
		Random r = new Random();
		String randomNumberID = String.format("%04", r.nextInt(1001));
		ArrayList<String> ID = new ArrayList<>();
		ID.add(firstName.substring(0,1));
		ID.add(lastName.substring(0, 1));
		ID.add("-");
		ID.add(randomNumberID);
		userID = String.join("", ID);
		return userID;
	}
	
	@Override
	public String toString() {
		return "User ID : " + this.userID + "\n First Name : " + this.firstName + "\nLast Name : " + this.lastName + "\n userName : " + this.userName;
	}
	
}
