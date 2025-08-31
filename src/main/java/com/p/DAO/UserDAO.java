package com.p.DAO;

import java.util.List;

import com.p.models.User;

public interface UserDAO {
	
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
	User getUser(int id);
	List<User> getAllUsers();
	User checkLogin(String username, String password);
	
}