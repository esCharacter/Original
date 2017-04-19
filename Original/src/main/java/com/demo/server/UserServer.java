package com.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;

@Service
public class UserServer {

	@Autowired
	public UserDao userDao;

	public String showUserInfo() {
		return userDao.getUserInfo(12, "ABCdrit");
	}

	/**
	 * 增
	 * 
	 * @param info
	 * @param name
	 * @return
	 */
	public boolean addUser(String info, String name) {

		userDao.addUser(new User(name, info));

		return true;
	}

	/**
	 * 删
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteUser(String id) {
		userDao.delUserbyId(id);

		return true;
	}

	/**
	 * 改
	 * 
	 * @param id
	 * @param name
	 * @param info
	 * @return
	 */
	public boolean updateUser(int id, String name, String info) {
		userDao.updUser(new User(id, name, info));

		return true;
	}

	/**
	 * 查
	 * 
	 * @return
	 */
	public String getUser() {
		return userDao.getUser().toString();
	}

	public String getUserOhter() {
		return userDao.getUserOhter().toString();
	}
}
