package com.cmc.shop.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cmc.shop.model.Employee;
//import com.github.pagehelper.Page;
import com.cmc.shop.model.Todo;

public interface EmployeeService {
	
	void createPost(Employee emp);
	
	void deletePost(String empId);
	
	void updatePost(Employee emp);
	
	public ArrayList<Employee> getAllEmployee();
	
	public Employee getPostOne(String id);
	
	public ArrayList<Employee> findByNameEmp(String name);

	public ArrayList<Employee> findByDate(Date dateFrom,Date dateTo);
	
	
//	public  ArrayList<Employee> listPaging(Pageable pageable);
//	
//	public Page<Employee> findAllList(Pageable pageable);
}
