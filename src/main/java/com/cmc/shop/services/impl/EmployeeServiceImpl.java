package com.cmc.shop.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmc.shop.dao.EmployeeDAO;
import com.cmc.shop.model.Employee;
import com.cmc.shop.model.Todo;
import com.cmc.shop.services.EmployeeService;
//import com.github.pagehelper.Page;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO empDAO;

	@Override
	public void createPost(Employee emp) {
		this.empDAO.save(emp);
		
	}

	@Override
	public void deletePost(String empId) {
		this.empDAO.delete(empId);
		
	}

	@Override
	public void updatePost(Employee emp) {
		this.empDAO.update(emp);
		
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		
		return (ArrayList<Employee>) empDAO.findAll();
	}

	@Override
	public Employee getPostOne(String id) {
		
		return empDAO.find(id);
	}

	@Override
	public ArrayList<Employee> findByNameEmp(String name) {
		String s = "%"+name+"%";
		return (ArrayList<Employee>) empDAO.findByNameEmp(s);
	}

	@Override
	public ArrayList<Employee> findByDate(Date dateFrom, Date dateTo) {
		
		return (ArrayList<Employee>) empDAO.findByDate(dateFrom, dateTo);
	}






//	@Override
//	public ArrayList<Employee> listPaging(org.springframework.data.domain.Pageable pageable) {
//		// TODO Auto-generated method stub
//		return (ArrayList<Employee>) empDAO.findAllList(pageable);
//	}
//
//	@Override
//	public Page<Employee> findAllList(org.springframework.data.domain.Pageable pageable) {
//		// TODO Auto-generated method stub
//		return (Page<Employee>) empDAO.findAllList(pageable);
//	}



	

}
