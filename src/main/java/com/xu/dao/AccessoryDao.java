package com.xu.dao;

import com.xu.entity.Accessory;

public interface AccessoryDao extends BaseDao<Accessory> {

	public int deleteByFruitId(String fruitId);
}
