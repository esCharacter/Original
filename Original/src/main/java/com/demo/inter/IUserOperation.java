package com.demo.inter;

import java.util.List;

import com.demo.entity.Uohter;
import com.demo.entity.User;

public interface IUserOperation {
	public User selectUserById(int id);
	
	public List<User> selectUsers(String name);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(String id);
	
	public List<Uohter> getUserOhters(int id);
	
}
