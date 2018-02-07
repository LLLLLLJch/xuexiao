package com.situ.xuexiao.pojo;

import java.io.Serializable;

public class Course implements Serializable {
	private Integer sequenceNO;
	private String ID;
	private String name;
	private Integer score;
	private Category category;

	public Course() {
		super();
	}

	public Course(Integer sequenceNO, String iD, String name, Integer score, Category category) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.name = name;
		this.score = score;
		this.category = category;
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

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Course [sequenceNO=" + sequenceNO + ", ID=" + ID + ", name=" + name + ", score=" + score + ", category="
				+ category + "]";
	}

}
