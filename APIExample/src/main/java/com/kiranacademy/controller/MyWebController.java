package com.kiranacademy.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kiranacademy.entity.User;

@Controller
public class MyWebController {

	
	@Autowired
	SessionFactory factory;

	@RequestMapping("hello")
	public String hello() {

		return "hello";
	}


	@RequestMapping("hi")
	public String hi() {
		return "hi";
	}


	@RequestMapping("add")
	public ModelAndView add(Integer num1, Integer num2) {
		int sum = num1 + num2;

		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.setViewName("result");
		modelAndView.addObject("addition", sum);

		return modelAndView;
	}

	@RequestMapping("login")
	public String login() {
		return "login";//login.jsp page  anme
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}

	@RequestMapping("validate")
	public ModelAndView validate(String username, String password) {
		
		Session  session = factory.openSession();
		User userFromDb =  session.get(User.class, username);
	
		ModelAndView modelAndView =  new ModelAndView();
		
		if(userFromDb == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "Invalid username");
		}
		else if(userFromDb.getPassword().equals(password)) {
			
			List<User> list =  session.createCriteria(User.class).list();
			
			System.out.println(list);
			modelAndView.setViewName("welcome");
			modelAndView.addObject("usersfromdb", list);			
			modelAndView.addObject("userimage", userFromDb.getImagepath());
		}	
		else {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "Invalid password");
		}
		return modelAndView;
	}

	//User class object will be created automatically and it will have data coming from browser
	@RequestMapping("saveUserData")
	public ModelAndView saveUserData(User userfrombrowser, HttpServletRequest request) {
		
		MultipartFile filedata = userfrombrowser.getImages();
		
		String fileName = filedata.getOriginalFilename();
		System.out.println(fileName);
		
		File file = new File(request.getServletContext().getRealPath("/images"), fileName);
		
		try {
			filedata.transferTo(file);
			System.out.println("FILE UPLOADED SUCCESSFULLY");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		Session session = factory.openSession();
		Transaction tx =  session.beginTransaction();
		
		userfrombrowser.setImagepath(fileName);
		
		session.save(userfrombrowser);
		tx.commit();
		
		modelAndView.setViewName("login");
		modelAndView.addObject("message", "Registration Successful. Pls login now");
		
		return modelAndView;
	}
	
}
