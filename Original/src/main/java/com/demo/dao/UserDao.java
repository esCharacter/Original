package com.demo.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.Reader;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.entity.Uohter;
import com.demo.entity.User;
import com.demo.inter.IUserOperation;

@Repository
public class UserDao {

	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setdataSource(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public String getUserInfo(int id, String name) {
		return new User(id, name).toString();
	}

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * 增
	 * 
	 * @param user
	 */
	public void addUser(User user) {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();

		} finally {
			session.close();
		}

		return;
	}

	/**
	 * 删
	 * 
	 * @param id
	 */
	public void delUserbyId(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
		return;
	}

	/**
	 * 改
	 * 
	 * @param user
	 */
	public void updUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			User user2 = userOperation.selectUserById(180);
			user2.setInfo("123456789");
			userOperation.updateUser(user2);
			session.commit();

		} finally {
			session.close();
		}
		return;
	}

	/**
	 * 查
	 * 
	 * @return
	 */
	public List<User> getUser() {

		SqlSession session = getSession().openSession();
		List<User> users = null;
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			users = userOperation.selectUsers("ad%");

		} finally {
			session.close();
		}
		return users;
	}

	/**
	 * 级联查
	 * 
	 * @return
	 */
	public List<Uohter> getUserOhter() {

		SqlSession session = getSession().openSession();
		List<Uohter> ohters = null;
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			ohters = userOperation.getUserOhters(1);

		} finally {
			session.close();
		}
		System.out.println(ohters.toString());
		return ohters;
	}
}
