package core;

import entities.concretes.User;

public interface MyAuthenticationService {
	void register(User user);
	void login(User user);
}