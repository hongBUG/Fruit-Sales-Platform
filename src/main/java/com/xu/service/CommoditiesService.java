package com.xu.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xu.entity.Commodities;

public interface CommoditiesService {

	/**
	 * 根据id查询单条数据
	 * @param id
	 * @return
	 */
	public Commodities get(Serializable id);
	
	/**
	 * 根据条件查询记录集合
	 * @param map
	 * @return
	 */
	public List<Commodities> find(Map map);
	
	/**
	 * 插入
	 * @param commodities
	 */
	public void insert(Commodities commodities);
	
	/**
	 * 修改
	 * @param commodities
	 */
	public void update(Commodities commodities);
	
	/**
	 * 删除单挑数据
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 删除多条数据
	 * @param ids
	 */
	public void delete(Serializable[] ids);
	
	/**
	 * 查询符合条件的结果数量
	 * @param map
	 * @return
	 */
	public int count(Map map);
}
