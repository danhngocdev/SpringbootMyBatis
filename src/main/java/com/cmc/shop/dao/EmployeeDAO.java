package com.cmc.shop.dao;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cmc.shop.model.Employee;
//import com.github.pagehelper.Page;
import com.cmc.shop.model.Todo;


@Mapper
public interface EmployeeDAO {
	
	void save(Employee emp);
	
	void delete(String empId);
	
	void update(Employee emp);
	
	Employee find(String empId);
	
	List<Employee> findAll();
	
	List<Employee> findByNameEmp(String name);
	
    List<Employee> findByDate(Date dateFrom,Date dateTo);
    
 
    
//    List<Employee> listPaging(Pageable pageable);
//    
//    Page<Employee> findAllList(Pageable pageable);

}
