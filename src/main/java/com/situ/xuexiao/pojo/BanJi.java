package com.situ.xuexiao.pojo;

import java.io.Serializable;

public class BanJi implements Serializable {

	private Integer sequenceNO;
	private String ID;
	private String name;

	public BanJi(Integer sequenceNO, String iD, String name) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.name = name;
	}

	public BanJi() {
		super();
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

	@Override
	public String toString() {
		return "BanJi [sequenceNO=" + sequenceNO + ", ID=" + ID + ", name=" + name + "]";
	}

}
