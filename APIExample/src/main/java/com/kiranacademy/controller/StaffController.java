package com.kiranacademy.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranacademy.entity.Staff;

@RestController
public class StaffController {
	
	
	@Autowired
	SessionFactory factory;
	
	
	
	@RequestMapping("getallstaff")//1
	public List<Staff> getAllStaff(){
		
		Session session =factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		
		List<Staff> list = criteria.list();
		
		return list;
	}
	
	
	@RequestMapping("getstaffbyid")//2
	public Staff getStaffById(Integer staffid) {
		
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("staffid", staffid));
		
		List<Staff> list = criteria.list();
		
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	
	@RequestMapping("getspecificstaff/{staffid}")//2
	public Staff getSpecificStaff(@PathVariable int staffid) {
		
		Session session = factory.openSession();
		
		Criteria criteria =  session.createCriteria(Staff.class);
		
		criteria.add(Restrictions.eq("staffid", staffid));
		
		List<Staff> list = criteria.list();
		
		return list.get(0);
	}
	
	
	
	@PostMapping("savestaff")//3
	public String saveStaff(@RequestBody Staff staff) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(staff);
		
		tx.commit();
		
		return "Staff member added";
	}
	
	
	@RequestMapping("getstaffbysalarymorethan/{salary}")//4
	public List<Staff> getStaffBySalaryMoreThan(@PathVariable int salary){
		
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		
		criteria.add(Restrictions.gt("salary", salary));
		
		List<Staff> list = criteria.list();
		
		return list;
	}
	
	
	@RequestMapping("getstaffbyexp/{fromyear}/{toyear}")//5
	public List<Staff> getStaffByExperience(@PathVariable int fromyear,@PathVariable int toyear){
		
		Session session =  factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", fromyear, toyear));
		
		List<Staff> list = criteria.list();
		
		return list;
	}
	
	
	@RequestMapping("getMaxSalaryStaff")//6
	public List<Staff> getMaxSalaryStaff() {
		
		Session session = factory.openSession();
		
		Criteria criteria1 = session.createCriteria(Staff.class);
		criteria1.setProjection(Projections.max("salary"));
		
		List<Integer> salaryList = criteria1.list();
		
		int maxSalary = 0;
		if(salaryList != null)
			maxSalary = salaryList.get(0);
		
		
		Criteria criteria2= session.createCriteria(Staff.class);
		criteria2.add(Restrictions.eq("salary", maxSalary));
		
		List<Staff> list = criteria2.list();
		
		if(list != null)
			return list;
		else
			return null;
	}
	
	
	
	
	
	
	
	
	@PostMapping("updatesalary")//7
	public String updateSalary(@RequestBody Staff staff) {
		
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		
		session.update(staff);
		
		tx.commit();
		
		return "Staff Updated";
	}
	
	
	
	@RequestMapping("updatestaffsalary/{staffid}/{salary}")//7
	public String updateStaffSalary(@PathVariable int staffid, @PathVariable int salary) {
		
		Session session = factory.openSession();
		
		
		Transaction tx = session.beginTransaction();
		
		Staff staff = session.load(Staff.class, staffid);
		
		staff.setSalary(salary);
		
		session.update(staff);
		
		tx.commit();
		
		return "Salary updated for staffid "+staffid;
	}
	
	@RequestMapping("getminexpstaffname")//8
	public String getMinExpStaffName() {
		
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.min("experience"));
		
		List<Integer> list1 = criteria.list();
		
		int minExp = list1.get(0);
		
		Criteria criteria2 = session.createCriteria(Staff.class);
		criteria2.add(Restrictions.eq("experience", minExp));
		criteria2.setProjection(Projections.property("name"));
		
		List<String> staffName = criteria2.list();
		
		return staffName.get(0);
	}
	
	
	@RequestMapping("gettrainerstaff")
	public List<Staff> getTrainerStaff(){
		
		Session session = factory.openSession();
		
		Criteria criteria =  session.createCriteria(Staff.class);
		
		criteria.add(Restrictions.eq("profile", "trainer"));
		
		List<Staff> list = criteria.list();
		
		return list;
	}
	
	@RequestMapping("getnontrainerstaff")
	public List<Staff> getNonTrainerStaff(){
		
		
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		
		criteria.add(Restrictions.ne("profile", "trainer"));
		
		List<Staff> list = criteria.list();
		
		return list;
	}

}
