import business.abstracts.AuthenticationService;
import business.abstracts.EMailSendService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import business.concretes.AuthenticationManager;
import business.concretes.EMailSendManager;
import business.concretes.UserManager;
import business.concretes.UserValidationManager;
import core.MyAuthenticationService;
import core.adapters.MyAuthenticationAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.MemoryUserDao;
import entities.concretes.User;
import googleAuthentication.GoogleAuthenticationManager;

public class Main {

	public static void main(String[] args) {
		
		User user1 = new User(1, "Mert", "Balkan", "mert__balkan@hotmail.com", "123456789");
		User user2 = new User(2, "AB", "XY", "A@hotmail.com", "123456789");
		User user3 = new User(3, "XY", "YZ", "X@hotmail.com", "123456789");
		
		UserDao userDao = new MemoryUserDao();
		UserService userService = new UserManager(userDao);
		EMailSendService emailSendService = new EMailSendManager();
		UserValidationService userValidationService = new UserValidationManager();
		AuthenticationService authenticationService = new AuthenticationManager(emailSendService, userService, userValidationService);

		authenticationService.register(user1);
		authenticationService.login("mert__balkan@hotmail.com", "123456789");
	

		MyAuthenticationService myAuthenticationService = new MyAuthenticationAdapter(new GoogleAuthenticationManager());
		myAuthenticationService.register(user2);
		myAuthenticationService.register(user3);
	}
}