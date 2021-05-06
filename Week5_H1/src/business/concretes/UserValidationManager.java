package business.concretes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import business.abstracts.UserValidationService;
import entities.concretes.User;

public class UserValidationManager implements UserValidationService{
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
		
	@Override
	public boolean checkPassword(User user) {
		return user.getPassword().length() < 6;
	}

	@Override
	public boolean checkFirstName(User user) {
		return user.getFirstName().length() < 2;
	}

	@Override
	public boolean checkLastName(User user) {
		return user.getLastName().length() < 2;
	}

	@Override
	public boolean checkAllInformations(User user) {
		boolean resultOfInformations = checkLastName(user) && checkFirstName(user) && checkPassword(user);
		return !resultOfInformations;
	}
}