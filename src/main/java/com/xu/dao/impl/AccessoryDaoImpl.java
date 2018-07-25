package com.xu.dao.impl;

import org.springframework.stereotype.Repository;

import com.xu.dao.AccessoryDao;
import com.xu.entity.Accessory;

@Repository
public class AccessoryDaoImpl extends BaseDaoImpl<Accessory> implements AccessoryDao{

	public AccessoryDaoImpl() {
		super.setNamespace("com.xu.mapping.AccessoryMapper");
	}

	@Override
	public int deleteByFruitId(String fruitId) {
		return this.getSqlSession().delete(this.getNamespace() + ".deleteByFruitId", fruitId);
	}
}
