package com.cmc.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cmc.shop.model.Employee;
import com.cmc.shop.services.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	
	
	//ListPaginate
//	   @RequestMapping(value = "/test",method = RequestMethod.GET)
//	   public Page<Employee> findAllList(Pageable pageable){
//		   Page<Employee> list = empService.findAllList(pageable);
//		 return list;
//		 
//	 }
//	list ALL
     
	
	@RequestMapping(value = "/employees",method =  RequestMethod.GET)
	public List<Employee> getAll(){
		List<Employee> listemp = empService.getAllEmployee();
		return listemp;
	}


//	hien thi chi tiet thong tin 1 nhan vien
	@RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
	public Employee getPostOne(@PathVariable String id) {
		Employee emp = empService.getPostOne(id);
		return emp;
	}
	
	
//	xoa mot nhan vien
	@RequestMapping(value = "/employees/delete/{id}",method =  RequestMethod.DELETE)
	public boolean delete(@PathVariable String id) {
		boolean check  = false;
		
		try {
			empService.deletePost(id);
			check = true;
		} catch (Exception e) {
		      e.printStackTrace();
		      check = false;
		}
		
		return check;	
	}

	

//	luu mot nhan vien vao db
	@RequestMapping(value = "employee/insert",method =  RequestMethod.POST,consumes = {"application/JSON", "application/XML"})
	@ResponseBody  
	public boolean insert(@RequestBody Employee emp) {
		boolean check = false;
//		if (emp.getEmp_name() != "") {

	   try {
		   empService.createPost(emp);
		   check = true;
	} catch (Exception e) {
		e.printStackTrace();
		check = false;
	}
     return check;
	}
   
	@RequestMapping(value = "employee/update",method =  RequestMethod.PUT,consumes = {"application/JSON", "application/XML"}) 
	@ResponseBody
	public boolean update(@RequestBody Employee emp) {
		boolean check = false;
//		if (emp.getEmp_name() != "") {
		
		

	   try {
		   empService.updatePost(emp);
		   check = true;
	} catch (Exception e) {
		
		e.printStackTrace();
		check = false;
	}
     return check;
	}

//	tim kiem
	//@GetMapping(value = "employee/search")
//	@RequestMapping(value ="employee/?search={search}",method = RequestMethod.GET)
//	public String search(@RequestParam("search") String name) {
//		if (name.equals("")) {
//			return "null";
//		}
//		
//		try {
//			
//			empService.findByNameEmp(name);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return "";
//	}
	@RequestMapping(value ="employee/searchs/{name}",method = RequestMethod.GET)
	public List<Employee> findByName(@PathVariable String name){
		if (name.equals(" ")) {
			return null;
		}
		 try {
			List<Employee> listByName = empService.findByNameEmp(name);
			return listByName;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
		
		
	}
	@RequestMapping(value ="employee/findByDate",method = RequestMethod.GET)
	public List<Employee> findByDate(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo){	
		 try {
			List<Employee> listByDate = empService.findByDate(dateFrom, dateTo);
			return listByDate;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		 return null;
	}
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));   
	}
}
