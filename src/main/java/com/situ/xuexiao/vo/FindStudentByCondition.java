package com.situ.xuexiao.vo;

public class FindStudentByCondition {

	private String name;
	private Integer gender;
	private Integer pageIndex;
	private Integer pageSize;

	public FindStudentByCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FindStudentByCondition(String name, Integer gender, Integer pageIndex, Integer pageSize) {
		super();
		this.name = name;
		this.gender = gender;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "FindStudentByCondition [name=" + name + ", gender=" + gender + ", pageIndex=" + pageIndex
				+ ", pageSize=" + pageSize + "]";
	}

}
