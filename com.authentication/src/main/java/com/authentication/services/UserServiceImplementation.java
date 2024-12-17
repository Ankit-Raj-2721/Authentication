package com.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.entities.User;
import com.authentication.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repo;

	public boolean usernameExists(String username) {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		if(user != null) {
			return true;
		}
		else {
			return false;
		}	
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		if(usernameExists(username)) {
			//password = db_password => true
			User user = repo.findByUsername(username);
			String dbPass = user.getPassword();
			if(password.equals(dbPass))
				return true;
		}
		return false;
	}
}

