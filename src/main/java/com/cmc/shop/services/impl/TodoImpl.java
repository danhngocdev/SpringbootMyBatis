package com.cmc.shop.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.shop.dao.EmployeeDAO;
import com.cmc.shop.dao.TodoDAO;
import com.cmc.shop.model.Todo;
import com.cmc.shop.services.TodoService;

@Service
@Transactional
public class TodoImpl implements TodoService{

	
	@Autowired
	private TodoDAO todoDAO;

	@Override
	public void createPost(Todo todo) {
		this.todoDAO.save(todo);
		
	}

	@Override
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		this.todoDAO.delete(id);
	}

	@Override
	public void updatePost(Todo todo) {
		// TODO Auto-generated method stub
		this.todoDAO.update(todo);
	}

	@Override
	public ArrayList<Todo> getByType(String type) {
	    return (ArrayList<Todo>) todoDAO.getByType(type);
	}

	@Override
	public Todo find(int id) {
		// TODO Auto-generated method stub
		return todoDAO.find(id);
	} 
	

}
