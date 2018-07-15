package com.xu.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.xu.entity.User;

public interface UserService {

	/**
	 * 根据Id 查找一条记录  常用于修改
	 * @param id
	 * @return
	 */
	public User get(Serializable id);

	/**
	 * 根据条件查询多个结果
	 * @param map
	 * @return
	 */
	public List<User> find(Map map);
	
	/**
	 * 插入实体
	 * @param user
	 */
	public void Insert(User user);
	
	/**
	 * 根据实体进行修改
	 * @param user
	 */
	public void update(User user);
	
	
	/**
	 * 按照id进行删除  删除一条
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 按照id进行删除  删除多条  支持字符串和整型
	 * @param ids
	 */
	public void delete(Serializable[] ids);
}
