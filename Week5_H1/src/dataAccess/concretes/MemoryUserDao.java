package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class MemoryUserDao implements UserDao{
	
	private List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " added to the MemoryUserDao");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " updated to the MemoryUserDao");
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println(user.getFirstName() + " delete from MemoryUserDao");
	}

	@Override
	public User getUser(int id) {
		for(User user : users)
			if(user.getId() == id)
				return user;
		
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		for(User user : users) 
			if(user.getPassword() == password && user.getePosta() == email)
				return user;
		
		return null;
	}
}