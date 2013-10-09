package com.egt.persistence.bean;

public class Criteria {
	private String table;
	private String column;
	private Object value;
	private String param;
	
	public Criteria(String column, Object value) {
		// By Default use name as param
		this( null, column, value, column);
	}
	
	public Criteria(String table, String column, Object value ) {
		// By Default use name as param
		this( table, column, value, column);
	}
	
	public Criteria(String table, String column, Object value, String param) {
		super();
		this.table = table;
		this.column = column;
		this.value = value;
		this.param = param;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}

	
}
