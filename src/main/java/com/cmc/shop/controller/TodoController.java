package com.cmc.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.shop.model.Employee;
import com.cmc.shop.model.Todo;
import com.cmc.shop.services.EmployeeService;
import com.cmc.shop.services.TodoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	@RequestMapping(value = "/toto/gettype",method =  RequestMethod.GET)
	public List<Todo> getAll(@Param("type")String type){
		List<Todo> listemp = todoService.getByType(type);
		return listemp;
	}
	
	
//	xoa mot nhan vien
	@RequestMapping(value = "/todo/delete/{id}",method =  RequestMethod.DELETE)
	public boolean delete(@PathVariable int id) {
		boolean check  = false;
		
		try {
			todoService.deletePost(id);
			check = true;
		} catch (Exception e) {
		      e.printStackTrace();
		      check = false;
		}
		
		return check;	
	}
//	luu mot nhan vien vao db
	@RequestMapping(value = "todo/insert",method =  RequestMethod.POST,consumes = {"application/JSON", "application/XML"})
	@ResponseBody  
	public boolean insert(@RequestBody Todo todo) {
		boolean check = false;
//		if (emp.getEmp_name() != "") {
            
	   try {
		   todoService.createPost(todo);
		   check = true;
	} catch (Exception e) {
		e.printStackTrace();
		check = false;
	}
     return check;
	}
   
	@RequestMapping(value = "todo/update",method =  RequestMethod.PUT,consumes = {"application/JSON", "application/XML"}) 
	@ResponseBody
	public boolean update(@RequestBody Todo todo) {
		boolean check = false;
//		if (emp.getEmp_name() != "") {
		
		

	   try {
		   todoService.updatePost(todo);
		   check = true;
	} catch (Exception e) {
		
		e.printStackTrace();
		check = false;
	}
     return check;
	}
    
}
