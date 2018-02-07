package com.situ.xuexiao.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FindNoticeByCondition {

	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;

	public FindNoticeByCondition() {
		super();
	}

	public FindNoticeByCondition(String title, Date startTime, Date endTime) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "FindNoticeByCondition [title=" + title + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
