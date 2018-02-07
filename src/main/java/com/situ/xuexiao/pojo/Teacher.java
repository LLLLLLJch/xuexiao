package com.situ.xuexiao.pojo;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {
	private Integer sequenceNO;
	private String ID;
	private String name;
	private Integer age;
	private Integer gender;
	private String address;
	private Date birthday;
	private String picture;
	private Category Category;
	private Attence attence;
	private Salary salary;
	private Course course;
	private String password;

	public Teacher() {
		super();
	}

	public Teacher(String iD, String name, Integer age, Integer gender, String address, Date birthday, String picture,
			Category category, Course course) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.picture = picture;
		Category = category;
		this.course = course;
	}

	public Teacher(Integer sequenceNO, String iD, String name, Integer age, Integer gender, String address,
			Date birthday, String picture, Category category, Attence attence, Salary salary, Course course,
			String password) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.picture = picture;
		Category = category;
		this.attence = attence;
		this.salary = salary;
		this.course = course;
		this.password = password;
	}

	public Integer getSequenceNO() {
		return sequenceNO;
	}

	public void setSequenceNO(Integer sequenceNO) {
		this.sequenceNO = sequenceNO;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category category) {
		Category = category;
	}

	public Attence getAttence() {
		return attence;
	}

	public void setAttence(Attence attence) {
		this.attence = attence;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Course getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Teacher [sequenceNO=" + sequenceNO + ", ID=" + ID + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", address=" + address + ", birthday=" + birthday + ", picture=" + picture + ", Category="
				+ Category + ", attence=" + attence + ", salary=" + salary + ", course=" + course + ", password="
				+ password + "]";
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
