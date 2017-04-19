package com.demo.entity;

public class Uohter {

	private int id;	
	private User user;
	private String ohter;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOhter() {
		return ohter;
	}
	public void setOhter(String ohter) {
		this.ohter = ohter;
	}
	
	@Override
	public String toString() {
		return "Uohter [id=" + id + ", user=" + user.toString() + ", ohter=" + ohter + "]";
	}

}
