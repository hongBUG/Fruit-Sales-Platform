package com.xu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	public T get(Serializable id);  // 只查询一个数据  常用于修改
	public List<T> find(Map map);  // 根据条件查询多个结果
	public void insert(T entity);  // 插入  用实体作为参数
	public void update(T entity);  // 更新  用实体作为参数
	public void deleteById(Serializable id);  // 按id删除  删除一条；支持整形和字符串类型id
	public void delete(Serializable[] ids); // 按id批量删除  支持整形和字符串类型的id
}
