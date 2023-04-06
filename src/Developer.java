package Foodie;

public class Developer extends User
{
	//instance variables
	private boolean devClearance;
	
	/**
	 * Parameterized constructor that calls the super constructor
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param clearance
	 */
	public Developer(String firstName, String lastName, String userName, String password, boolean clearance)
	{
		super(firstName, lastName, userName, password);
		devClearance = clearance;
	}
	
	/**
	 * Adds the restaurants to the restaurant manager
	 */
	public void addRestaurant()
	{
		
	}
	
	/**
	 * Adds the user to the user manager
	 */
	public void addUser()
	{
		
	}

}
