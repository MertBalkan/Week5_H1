package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao{
	void add(User user);
	void update(User user);
	void delete(User user);
	User getUserByEmailAndPassword(String email, String password);
	User getUser(int id);
	List<User> getAll();
}