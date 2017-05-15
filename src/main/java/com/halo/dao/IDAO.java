package com.halo.dao;

import java.util.List;

public interface IDAO<T> {
	
	public T selectOne(T t);
	
	public void addOne(T t);
	
	public void deleteOne(T t);
	
	public void updateOne(T t);
	
	public List<T> query(T t);

}
