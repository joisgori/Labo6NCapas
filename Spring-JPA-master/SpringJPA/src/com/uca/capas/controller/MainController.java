package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	//Objeto logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain(){
		log.info("Entrando a función init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			//Selecciono todos los elementos en la tabla student
		 students = studentDao.findAll();
		 log.info("Termino de buscar en la base datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE, "Exception occur", e);
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView insert(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("form");
		return mav;
		
	}
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s){
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			//Selecciono todos los elementos en la tabla student
		 
		 log.info("Agrego un nuevo usuario");
		 studentDao.save(s, 1);
		}
		catch(Exception e){
			log.info("Error:"+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
		
	}

}
