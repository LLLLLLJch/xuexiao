package com.situ.xuexiao.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AskLeave {
	private Integer sequenceNO;
	private String ID;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postedDate;
	private Category category;
	private Category status;
	private Category dealResult;
	private String releasePeople;
	private Teacher recipient;

	public AskLeave() {
		super();
	}

	public AskLeave(String iD, String content, Date startTime, Date endTime, Date postedDate, Category category,
			String releasePeople) {
		super();
		ID = iD;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.postedDate = postedDate;
		this.category = category;
		this.releasePeople = releasePeople;
	}

	public AskLeave(Integer sequenceNO, String iD, String content, Date startTime, Date endTime, Date postedDate,
			Category category, Category status, Category dealResult, String releasePeople, Teacher recipient) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.postedDate = postedDate;
		this.category = category;
		this.status = status;
		this.dealResult = dealResult;
		this.releasePeople = releasePeople;
		this.recipient = recipient;
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

	public Date getPostedDate() {
		return postedDate;
	}

	public Category getDealResult() {
		return dealResult;
	}

	public void setDealResult(Category dealResult) {
		this.dealResult = dealResult;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getStatus() {
		return status;
	}

	public void setStatus(Category status) {
		this.status = status;
	}

	public String getReleasePeople() {
		return releasePeople;
	}

	public void setReleasePeople(String releasePeople) {
		this.releasePeople = releasePeople;
	}

	public Teacher getRecipient() {
		return recipient;
	}

	public void setRecipient(Teacher recipient) {
		this.recipient = recipient;
	}

	@Override
	public String toString() {
		return "AskLeave [sequenceNO=" + sequenceNO + ", ID=" + ID + ", content=" + content + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", postedDate=" + postedDate + ", category=" + category + ", status="
				+ status + ", dealResult=" + dealResult + ", releasePeople=" + releasePeople + ", recipient="
				+ recipient + "]";
	}

}
