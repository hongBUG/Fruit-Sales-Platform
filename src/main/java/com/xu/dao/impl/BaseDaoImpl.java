package com.xu.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.xu.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T>{

	@Autowired
	// mybatis-spring1.0不需要此方法  1.2需要
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String namespace; // 命名空间
	public String getNamespace() {
		return this.namespace;
	}
	public void setNamespace(String ns) {
		this.namespace = ns;
	}
	
	public List<T> find(Map map) {
		List<T> oList = this.getSqlSession().selectList(namespace + ".find", map);
		return oList;
	}
	
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(namespace + ".get", id);
	}
	
	public void insert(T entity) {
		this.getSqlSession().insert(namespace + ".insert", entity);
	}
	
	public void update(T entity) {
		this.getSqlSession().update(namespace + ".update", entity);
	}
	
	public void deleteById(Serializable id) {
		this.getSqlSession().delete(namespace + ".deleteById", id);
	}
	
	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(namespace + ".delete", ids);
	}
}
