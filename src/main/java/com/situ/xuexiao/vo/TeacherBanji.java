package com.situ.xuexiao.vo;

public class TeacherBanji {

	private String ID;
	private Integer teacherID;
	private Integer banjiID;

	public TeacherBanji() {
		super();
	}

	public TeacherBanji(String iD, Integer teacherID, Integer banjiID) {
		super();
		ID = iD;
		this.teacherID = teacherID;
		this.banjiID = banjiID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Integer getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}

	public Integer getBanjiID() {
		return banjiID;
	}

	public void setBanjiID(Integer banjiID) {
		this.banjiID = banjiID;
	}

	@Override
	public String toString() {
		return "TeacherBanji [ID=" + ID + ", teacherID=" + teacherID + ", banjiID=" + banjiID + "]";
	}

}
