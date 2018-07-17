package com.xu.dao;

import java.util.Map;

import com.xu.entity.Retailer;

public interface RetailerDao extends BaseDao<Retailer> {

	/**
	 * 根据条件统计结果集数量
	 * @param map
	 * @return
	 */
	public int count(Map map);
}
