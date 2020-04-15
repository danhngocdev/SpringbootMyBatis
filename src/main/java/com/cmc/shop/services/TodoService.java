package com.cmc.shop.services;

import java.util.ArrayList;
import java.util.List;

import com.cmc.shop.model.Employee;
import com.cmc.shop.model.Todo;

public interface TodoService {
    void createPost(Todo todo);
	
	void deletePost(int id);
	
	void updatePost(Todo todo);
	
	public ArrayList<Todo> getByType(String type);
}
