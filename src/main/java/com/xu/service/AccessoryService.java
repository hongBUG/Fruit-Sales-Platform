package com.xu.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xu.entity.Accessory;

public interface AccessoryService {

	/**
	 * 查询一个
	 * @param id
	 * @return
	 */
	public Accessory get(Serializable id);
	
	/**
	 * 根据条件查询多个结果
	 * @param map
	 * @return
	 */
	public List<Accessory> find(Map map);
	
	/**
	 * 插入
	 * @param accessory
	 */
	public void insert(Accessory accessory);
	
	/**
	 * 修改
	 * @param accessory
	 */
	public void update(Accessory accessory);
	
	/**
	 * 按id批量删除
	 * @param ids
	 */
	public void delete(Serializable[] ids);
	
	/**
	 * 按id删除
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 根据fruitId删除所有
	 * @param fuitId
	 * @return
	 */
	public int deleteByFruitId(String fruitId);
}
