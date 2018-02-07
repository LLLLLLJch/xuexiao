package com.situ.xuexiao.pojo;

import java.io.Serializable;

public class Category implements Serializable {

	private Integer sequenceNO;
	private String ID;
	private Integer parentID;
	private String title;

	public Category() {
		super();
	}

	public Category(Integer sequenceNO, String iD, Integer parentID, String title) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.parentID = parentID;
		this.title = title;
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

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Category [sequenceNO=" + sequenceNO + ", ID=" + ID + ", parentID=" + parentID + ", title=" + title
				+ "]";
	}

}
