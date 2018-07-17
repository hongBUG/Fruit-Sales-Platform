package com.xu.entity;

public class Page {
	private Integer currentPage;
	private Integer startPage;
	private Integer pageSize;
	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		if (currentPage == null)
			currentPage = 1;
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the startPage
	 */
	public Integer getStartPage() {
		if (startPage == null)
			startPage = 0;
		return startPage;
	}
	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		if (pageSize == null)
			pageSize = 10;
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
