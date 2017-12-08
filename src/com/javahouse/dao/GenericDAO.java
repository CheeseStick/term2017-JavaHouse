package com.javahouse.dao;

public interface GenericDAO<V, K> {
	public void insert(V vo) throws Exception;
	public void update(V vo) throws Exception;
	public void delete(K key) throws Exception;
	
	public V select(K key) throws Exception;
}
