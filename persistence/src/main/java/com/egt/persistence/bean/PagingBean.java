package com.egt.persistence.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagingBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_ROWS_PER_PAGE = 10;
	public static final String ORDER_DESC = "DESC";
	public static final String ORDER_ASC = "ASC";
		
	private long totalRows;
	private int rowsPerPage;
	private long currentPage;
	
	private String orderBy;		//Name of column
	private String orderMode;	//ASC or DESC
	private List<Order> orderList;		//For multi order by
	
	//Order style
	public class Order implements java.io.Serializable{
		String orderBy;
		String orderMode;
		
		public Order(String orderBy, String orderMode) {
			super();
			this.orderBy = orderBy;
			this.orderMode = orderMode;
		}
		
		public String getOrderBy() {
			return orderBy;
		}
		public void setOrderBy(String orderBy) {
			this.orderBy = orderBy;
		}
		public String getOrderMode() {
			return orderMode;
		}
		public void setOrderMode(String orderMode) {
			this.orderMode = orderMode;
		}		
	}
	
	public PagingBean() {
		this(DEFAULT_ROWS_PER_PAGE);
	}
	
	public PagingBean(int pageSize) {
		this(pageSize, 1);
	}
	
	public PagingBean(int rowsPerPage, long currentPage) {
		setCurrentPage(currentPage);
		setRowsPerPage(rowsPerPage);
		this.totalRows = 0;
		this.orderMode = " ASC ";
		orderList = new ArrayList<Order>();
	}
	
	public long getOffsetBegin() {
		return (currentPage-1)*rowsPerPage;
	}
	
	public long getOffsetEnd() {
		return (currentPage*rowsPerPage)-1;
	}
	
	public long getPageCount(){
		long result = totalRows/rowsPerPage + (totalRows%rowsPerPage==0?0:1);
		
		// return at least 1 page.
		// no chance for return 0
		if ( result <= 0 ) {
			result = 1;
		}
		return result;
	}
	
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		if(currentPage <=0) currentPage = 1;
		this.currentPage = currentPage;
	}
	
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		// is size under limit set size = 0 
		if(totalRows < 0) {
			totalRows = 0;
		} else {
			this.totalRows = totalRows;
			// adapt currentPage value to match current size 
			if(totalRows < currentPage * rowsPerPage) {
				currentPage = (totalRows/rowsPerPage) + 1;
			}
		}
	}
	
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		if( rowsPerPage <=0 ) rowsPerPage = 1;
		this.rowsPerPage = rowsPerPage;
	}
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		this.orderList.clear();
		addOrder( this.orderBy, this.orderMode );
	}

	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
		this.orderList.clear();		
		addOrder( this.orderBy, this.orderMode );		
	}	
	
	public void addOrder( String orderBy, String orderMode ){
		if( orderBy != null && orderBy.length() > 0 &&
			orderMode != null && orderMode.length() > 0 ){
			this.orderList.add( new Order( orderBy, orderMode ) );
		}
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
