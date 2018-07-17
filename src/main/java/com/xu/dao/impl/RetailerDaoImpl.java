package com.xu.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xu.dao.BaseDao;
import com.xu.dao.RetailerDao;
import com.xu.entity.Retailer;

@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {

	// 设置命名空间
	public RetailerDaoImpl() {
		super.setNamespace("com.xu.mapping.RetailerMapper");
	}
	
	public int count(Map map) {
		return this.getSqlSession().selectOne(this.getNamespace() + ".count", map);
	}
}
