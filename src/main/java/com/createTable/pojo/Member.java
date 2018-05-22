package com.createTable.pojo;

public class Member {

	private String name;
	private String password;

	public Member() {
		super();
	}

	public Member(String userName, String password) {
		super();
		this.name = userName;
		this.password = password;
	}

	public String getUseName() {
		return name;
	}

	public void setUseName(String userName) {
		this.name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [userName=" + name + ", password=" + password + "]";
	}

}
