package com.cmc.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cmc.shop.model.Employee;
import com.cmc.shop.model.Todo;

@Mapper
public interface TodoDAO {
	    List<Todo> getByType(String type);
	    
		void save(Todo todo);
		
		Todo find(int id);
		
		
		void delete(int id);
		
		void update(Todo todo);
}
