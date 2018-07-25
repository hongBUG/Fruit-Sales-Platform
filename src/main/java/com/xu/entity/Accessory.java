package com.xu.entity;

/**
 * 附属品实体类
 * @author xu
 *
 */
public class Accessory {

	private String accessoryId;
	private String fruitId;
	private String name;
	private double price;
	private String createTime;
	/**
	 * @return the accessoryId
	 */
	public String getAccessoryId() {
		return accessoryId;
	}
	/**
	 * @param accessoryId the accessoryId to set
	 */
	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}
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
