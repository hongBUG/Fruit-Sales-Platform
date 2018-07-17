package com.xu.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import com.xu.entity.Retailer;

public interface RetailerService {

	/**
	 * 查询一条数据
	 * @param id
	 * @return
	 */
	public Retailer get(Serializable id);
	
	/**
	 * 根据条件查询多个结果
	 * @param map
	 * @return
	 */
	public List<Retailer> find(Map map);
	
	/**
	 * 插入， 用实体作为参数
	 * @param retailer
	 */
	public void insert(Retailer retailer);
	
	/**
	 * 修改，用实体作为参数
	 * @param retailer
	 */
	public void update(Retailer retailer);
	
	/**
	 * 根据Id删除一条记录
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 批量删除 ，支持整形和字符型
	 * @param ids
	 */
	public void delete(Serializable[] ids);
	
	/**
	 * 根据条件统计结果集数量
	 * @param map
	 * @return
	 */
	public int count(Map map);
}
