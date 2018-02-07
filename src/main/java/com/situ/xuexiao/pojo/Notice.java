package com.situ.xuexiao.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {

	private Integer sequenceNO;
	private String ID;
	private String content;
	private String title;
	private String picture;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postedDate;
	private Teacher publisher;
	private Category category;

	public Notice() {
		super();
	}

	public Notice(String iD, String content, String title, String picture, Date postedDate, Teacher publisher) {
		super();
		ID = iD;
		this.content = content;
		this.title = title;
		this.picture = picture;
		this.postedDate = postedDate;
		this.publisher = publisher;
	}

	public Notice(Integer sequenceNO, String iD, String content, String title, String picture, Date postedDate,
			Teacher publisher, Category category) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.content = content;
		this.title = title;
		this.picture = picture;
		this.postedDate = postedDate;
		this.publisher = publisher;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Teacher getPublisher() {
		return publisher;
	}

	public void setPublisher(Teacher publisher) {
		this.publisher = publisher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Notice [sequenceNO=" + sequenceNO + ", ID=" + ID + ", content=" + content + ", title=" + title
				+ ", picture=" + picture + ", postedDate=" + postedDate + ", publisher=" + publisher + ", category="
				+ category + "]";
	}

}
