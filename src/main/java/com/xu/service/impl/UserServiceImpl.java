package com.xu.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xu.dao.UserDao;
import com.xu.entity.User;
import com.xu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}

	@Override
	public List<User> find(Map map) {
		return userDao.find(map);
	}

	@Override
	public void Insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteById(Serializable id) {
		userDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		userDao.delete(ids);
	}

}
