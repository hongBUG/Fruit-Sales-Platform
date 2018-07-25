package com.xu.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xu.dao.AccessoryDao;
import com.xu.entity.Accessory;
import com.xu.service.AccessoryService;

@Service
public class AccessoryServiceImpl implements AccessoryService {

	@Autowired
	AccessoryDao accessoryDao;
	
	@Override
	public Accessory get(Serializable id) {
		return accessoryDao.get(id);
	}

	@Override
	public List<Accessory> find(Map map) {
		return accessoryDao.find(map);
	}

	@Override
	public void insert(Accessory accessory) {
		accessoryDao.insert(accessory);
	}

	@Override
	public void update(Accessory accessory) {
		accessoryDao.update(accessory);
	}

	@Override
	public void delete(Serializable[] ids) {
		accessoryDao.delete(ids);
	}

	@Override
	public void deleteById(Serializable id) {
		accessoryDao.deleteById(id);
	}

	@Override
	public int deleteByFruitId(String fruitId) {
		return accessoryDao.deleteByFruitId(fruitId);
	}

}
