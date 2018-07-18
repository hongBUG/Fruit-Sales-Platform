package com.xu.dao;

import java.util.Map;

import com.xu.entity.Commodities;

public interface CommoditiesDao extends BaseDao<Commodities> {
	public int count(Map map);
}
