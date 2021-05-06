package googleAuthentication;

import entities.concretes.User;

public class GoogleAuthenticationManager {
	
	public void register(User user) {
		//google codes...
		System.out.println(user.getFirstName() + " registered with google");
	}
	public void login(User user) {
		//google codes...
		System.out.println(user.getFirstName() + " loginned with google");
	}
	
}