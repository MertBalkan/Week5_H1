package business.concretes;

import business.abstracts.AuthenticationService;
import business.abstracts.EMailSendService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import entities.concretes.User;

public class AuthenticationManager implements AuthenticationService{
	
	private EMailSendService emailSendService;
	private UserService userService;
	private UserValidationService userValidationService;
	
	public AuthenticationManager(EMailSendService emailSendService, UserService userService,
			UserValidationService userValidationService) {
		this.emailSendService = emailSendService;
		this.userService = userService;
		this.userValidationService = userValidationService;
	}

	@Override
	public void register(User user) {
		if(!userValidationService.checkAllInformations(user)) {
			System.out.println("An error occured. Please be sure that you filled all spaces correct.");
			return;
		}
		if(!userValidationService.validate(user.getePosta())) {
			System.out.println("Email missing...");
			return;
		}
		emailSendService.sendEmail(user);
		userService.add(user);
	}

	@Override
	public void login(String email, String password) {
		User userToLogin = userService.getUserByEmailAndPassword(email, password);

		if(userToLogin == null) {
			System.out.println("User is null...");
			return;
		}
		
		if(!userValidationService.checkAllInformations(userToLogin)) {
			System.out.println("An error occured. Please be sure that you filled all spaces correct.");
			return;
		}
		
		if(!userValidationService.validate(userToLogin.getePosta())) {
			System.out.println("Email missing...");
			return;
		}
		
		System.out.println("Welcome to the system " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
}