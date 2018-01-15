package com.oraclejava.mvc2.dao;

import java.util.List;

public interface PhoneDao<T> {
	public List<T> getAllEntity();
	public List<T> findByField(String field, String find);
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public void removeEntity(T entity);
	public void removeEntity(Integer id);
}
