package com.dollop.dao;

import java.sql.SQLException;

import com.dollop.model.UserLogin;

public interface UserInterface {
	public boolean insertUser(UserLogin user) throws SQLException;
	public UserLogin viewUserById(int id);
	public boolean loginUser(String name,String password);
	public boolean updateUser(UserLogin user);
	public boolean deleteUser(int id);
}
