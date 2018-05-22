package com.createTable.pojo;

public class Table {

	private String ID;
	private String type;
	private String length;
	private String name;
	private String isEmpty;
	private String majorKey;
	private String foreignKey;
	private String linkTable;

	public Table() {
		super();
	}

	public Table(String iD, String type, String length, String name, String isEmpty, String majorKey, String foreignKey,
			String linkTable) {
		super();
		ID = iD;
		this.type = type;
		this.length = length;
		this.name = name;
		this.isEmpty = isEmpty;
		this.majorKey = majorKey;
		this.foreignKey = foreignKey;
		this.linkTable = linkTable;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(String isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getMajorKey() {
		return majorKey;
	}

	public void setMajorKey(String majorKey) {
		this.majorKey = majorKey;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getLinkTable() {
		return linkTable;
	}

	public void setLinkTable(String linkTable) {
		this.linkTable = linkTable;
	}

	@Override
	public String toString() {
		return "Table [ID=" + ID + ", type=" + type + ", length=" + length + ", name=" + name + ", isEmpty=" + isEmpty
				+ ", majorKey=" + majorKey + ", foreignKey=" + foreignKey + ", linkTable=" + linkTable + "]";
	}

}
