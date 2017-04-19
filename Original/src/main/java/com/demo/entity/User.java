package com.demo.entity;

public class User {
	private int id;
	private String name;
	private String info;

	public User() {
		super();
		this.id = 0;
		this.name = "xx";
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(String name, String info) {
		super();
		this.info = info;
		this.name = name;
	}

	public User(int id, String name, String info) {
		super();
		this.id = id;
		this.info = info;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "信息：User [id=" + id + ", name=" + name + ", info=" + info + "]";
	}
}
