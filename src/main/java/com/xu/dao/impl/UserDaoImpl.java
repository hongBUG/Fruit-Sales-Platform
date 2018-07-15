package com.xu.dao.impl;

import org.springframework.stereotype.Repository;

import com.xu.dao.UserDao;
import com.xu.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public UserDaoImpl() {
		// 设置命名空间
		super.setNamespace("com.xu.mapping.UserMapper");
	}
}
