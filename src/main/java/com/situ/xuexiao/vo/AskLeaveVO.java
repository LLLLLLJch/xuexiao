package com.situ.xuexiao.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AskLeaveVO {

	private String ID;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date postedDate;
	private int type;
	private int status;
	private int dealResult;
	private String releasePeople;
	private int recipient;

	public AskLeaveVO() {
		super();
	}

	public AskLeaveVO(String iD, String content, Date startTime, Date endTime, Date postedDate, int type, int status,
			int dealResult, String releasePeople, int recipient) {
		super();
		ID = iD;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.postedDate = postedDate;
		this.type = type;
		this.status = status;
		this.dealResult = dealResult;
		this.releasePeople = releasePeople;
		this.recipient = recipient;
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

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDealResult() {
		return dealResult;
	}

	public void setDealResult(int dealResult) {
		this.dealResult = dealResult;
	}

	public String getReleasePeople() {
		return releasePeople;
	}

	public void setReleasePeople(String releasePeople) {
		this.releasePeople = releasePeople;
	}

	public int getRecipient() {
		return recipient;
	}

	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}

	@Override
	public String toString() {
		return "AskLeaveVO [ID=" + ID + ", content=" + content + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", postedDate=" + postedDate + ", type=" + type + ", status=" + status + ", dealResult=" + dealResult
				+ ", releasePeople=" + releasePeople + ", recipient=" + recipient + "]";
	}
}
