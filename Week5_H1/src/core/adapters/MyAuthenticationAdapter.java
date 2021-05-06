package core.adapters;

import core.MyAuthenticationService;
import entities.concretes.User;
import googleAuthentication.GoogleAuthenticationManager;

public class MyAuthenticationAdapter implements MyAuthenticationService{
	
	GoogleAuthenticationManager googleAuthentication;
	
	public MyAuthenticationAdapter(GoogleAuthenticationManager googleAuthentication) {
		this.googleAuthentication = googleAuthentication;
	}

	@Override
	public void register(User user) {
		googleAuthentication.register(user);
	}

	@Override
	public void login(User user) {
		googleAuthentication.login(user);
	}
}
