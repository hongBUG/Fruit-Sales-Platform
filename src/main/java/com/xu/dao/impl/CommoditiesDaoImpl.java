package com.xu.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xu.dao.CommoditiesDao;
import com.xu.entity.Commodities;

@Repository
public class CommoditiesDaoImpl extends BaseDaoImpl<Commodities> implements CommoditiesDao {

	public CommoditiesDaoImpl() {
		super.setNamespace("com.xu.mapping.Commodities");
	}

	@Override
	public int count(Map map) {
		return this.getSqlSession().selectOne(this.getNamespace() + ".count", map);
	}
	

}
