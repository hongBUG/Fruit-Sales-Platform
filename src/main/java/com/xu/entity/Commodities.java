package com.xu.entity;

public class Commodities extends Page{

	private String fruitId;
	private String name;
	private double price;
	private String locality;
	private String createTime;
	
	/**
	 * @return the fruitId
	 */
	public String getFruitId() {
		return fruitId;
	}
	/**
	 * @param fruitId the fruitId to set
	 */
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}
	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
