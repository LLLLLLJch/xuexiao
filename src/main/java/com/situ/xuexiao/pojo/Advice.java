package com.situ.xuexiao.pojo;

import java.util.Date;

public class Advice {

	private Integer sequenceNO;
	private String ID;
	private String title;
	private String content;
	private Date postedDate;
	private String picture;
	private Category category;

	public Advice() {
		super();
	}

	public Advice(String iD, String title, String content, Date postedDate, String picture, Category category) {
		super();
		ID = iD;
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
		this.picture = picture;
		this.category = category;
	}

	public Advice(Integer sequenceNO, String iD, String title, String content, Date postedDate, String picture,
			Category category) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.title = title;
		this.content = content;
		this.postedDate = postedDate;
		this.picture = picture;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Advice [sequenceNO=" + sequenceNO + ", ID=" + ID + ", title=" + title + ", content=" + content
				+ ", postedDate=" + postedDate + ", picture=" + picture + ", category=" + category + "]";
	}

}
