package business.abstracts;

import entities.concretes.User;

public interface UserValidationService {
	boolean checkPassword(User user);
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkAllInformations(User user);
	boolean validate(String emailStr);
}