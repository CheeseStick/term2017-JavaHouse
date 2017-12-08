package com.javahouse.dao;

public interface GenericDAO<V, K> {
	public void insert(final V vo) throws Exception;
	public void update(final V vo) throws Exception;
	public void delete(final K key) throws Exception;
	
	public V select(final K key) throws Exception;
}
