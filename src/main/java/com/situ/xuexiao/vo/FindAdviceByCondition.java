package com.situ.xuexiao.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.situ.xuexiao.pojo.Category;

public class FindAdviceByCondition {

	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	private Integer category_id;

	public FindAdviceByCondition() {
		super();
	}

	public FindAdviceByCondition(String title, Date startTime, Date endTime, Integer category_id) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.category_id = category_id;
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

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "FindAdviceByCondition [title=" + title + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", category_id=" + category_id + "]";
	}

}
