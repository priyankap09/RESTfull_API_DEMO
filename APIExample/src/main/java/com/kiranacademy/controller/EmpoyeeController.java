package com.kiranacademy.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:4200")
public class EmpoyeeController {
	
	@Autowired
	SessionFactory factory;
	
	@GetMapping("/get/employee/{eid}")
	public Employee getEmpoyee(@PathVariable int eid) {
		
		Session session = factory.openSession();
		return session.find(Employee.class,eid);
		
	}
	
	@DeleteMapping("/delete/employee/{eid}")
	public String deleteEmployee(@PathVariable int eid) {
		Session session = factory.openSession();
		
		Employee e = session.get(Employee.class, eid);
		
		session.delete(e);
		session.beginTransaction().commit();

		
		return "Employee deleted";
	}
	
	
	@PostMapping("/save/employee")
	public Employee saveEmployee(@RequestBody Employee e) {
		
		System.out.println("saving employee from POSTMAN");
		System.out.println(e);
		
		Session session =  factory.openSession();
		session.save(e);
		session.beginTransaction().commit();
		
		return e;
		
	}
	
	
	@PutMapping("/update/employee")
	public String updateEmployee(@RequestBody Employee e) {
		 Session session = factory.openSession();
		 session.update(e);
		 session.beginTransaction().commit();
		 return "Data Updated";
		
	}
	
	
	@GetMapping("/get/all/employee")
	public List<Employee> getAllEmployee(){
//		List<Employee> eList = new 
		
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> eList = criteria.list();
		
		return eList;
	}

	
	@GetMapping("/get/all/employee/by/condition/{salary}")
	public List<Employee> getAllEmployeeByCondition(@PathVariable int salary){
		
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.le("salary", salary));
		List<Employee> eList = criteria.list();
		
		return eList;
	}
}
