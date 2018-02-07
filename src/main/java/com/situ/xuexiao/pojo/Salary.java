package com.situ.xuexiao.pojo;

import org.springframework.context.annotation.Primary;

public class Salary {
	private Integer sequenceNO;
	private String ID;
	private double base;
	private double reward;
	private double sale;
	private double tax;
	private String other;
	private double actual;

	public Salary() {
		super();
	}

	public Salary(Integer sequenceNO, String iD, double base, double reward, double sale, double tax, String other,
			double actual) {
		super();
		this.sequenceNO = sequenceNO;
		ID = iD;
		this.base = base;
		this.reward = reward;
		this.sale = sale;
		this.tax = tax;
		this.other = other;
		this.actual = actual;
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

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public double getActual() {
		return actual;
	}

	public void setActual(double actual) {
		this.actual = actual;
	}

	@Override
	public String toString() {
		return "Salary [sequenceNO=" + sequenceNO + ", ID=" + ID + ", base=" + base + ", reward=" + reward + ", sale="
				+ sale + ", tax=" + tax + ", other=" + other + ", actual=" + actual + "]";
	}

}
