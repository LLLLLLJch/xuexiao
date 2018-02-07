package com.situ.xuexiao.pojo;

import java.util.Date;

public class Attence {
	private Integer sequenceNO;
	private String ID;
	private Date riqi;
	private Integer qiandao;
	private Integer qiantui;
	private String remark;

	public Attence() {
		super();
	}

	public Attence(Integer sequenceNO, String iD, Date riqi, Integer qiandao, Integer qiantui, String remark) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.riqi = riqi;
		this.qiandao = qiandao;
		this.qiantui = qiantui;
		this.remark = remark;
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

	public Date getRiqi() {
		return riqi;
	}

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	public Integer getQiandao() {
		return qiandao;
	}

	public void setQiandao(Integer qiandao) {
		this.qiandao = qiandao;
	}

	public Integer getQiantui() {
		return qiantui;
	}

	public void setQiantui(Integer qiantui) {
		this.qiantui = qiantui;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Attence [sequenceNO=" + sequenceNO + ", ID=" + ID + ", riqi=" + riqi + ", qiandao=" + qiandao
				+ ", qiantui=" + qiantui + ", remark=" + remark + "]";
	}

}
