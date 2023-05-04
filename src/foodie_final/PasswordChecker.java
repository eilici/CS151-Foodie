package foodie;

public class PasswordChecker {

	public PasswordChecker() {

	}

	public void checkPassword(String pass) throws PasswordException {
		// Count upper lower number special
		// source:
		// https://www.geeksforgeeks.org/count-uppercase-lowercase-special-character-numeric-values/
		int upper = 0, lower = 0, number = 0, special = 0;

		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				upper++;
			else if (ch >= 'a' && ch <= 'z')
				lower++;
			else if (ch >= '0' && ch <= '9')
				number++;
			else
				special++;
		}

		// first check length
		if (pass.length() < 8) {
			throw new Minimum8CharactersRequired("password must be at least 8 characters.");
		}

		// check upper
		else if (upper == 0) {
			throw new UpperCaseCharacterMissing("Must have at least one uppercase character.");
		}

		// check lower
		else if (lower == 0) {
			throw new LowerCaseCharacterMissing("Must have at least one lowercase character.");
		}

		// check number
		else if (number == 0) {
			throw new NumberCharacterMissing("Must have at least one number.");
		}

		// check special
		else if (special == 0) {
			throw new SpecialCharacterMissing("Must have at least one special character (!,$,%,etc).");
		}
	}
}
