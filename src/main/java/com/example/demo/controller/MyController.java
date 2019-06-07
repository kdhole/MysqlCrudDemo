package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;



@Controller
public class MyController {
	
	@Autowired
	StudentRepo studrepo;
	@RequestMapping("/")
public ModelAndView doHome()
{
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("lists",studrepo.findAll());
	return mv;
}
	
	
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public ModelAndView doSave(@RequestParam("Name") String Name,@RequestParam("City") String  City)
	{
		ModelAndView mv=new ModelAndView("redirect:/");
		Student stud=new Student();
		stud.setName(Name);
		stud.setCity(City);
		studrepo.save(stud);
		return mv;
	}
	 @RequestMapping(value="/view/{id}",method= RequestMethod.GET) 
	 public ModelAndView doView(@PathVariable("id") int id1)
	 { 
		 ModelAndView mv=new ModelAndView("view"); 
		 //int id1=Integer.parseInt("id");
		 mv.addObject("lists",studrepo.findById(id1)); 
		 return mv;
	 }
	/*
	 * @RequestMapping(value="/delete/{id}",method= RequestMethod.DELETE) public
	 * ModelAndView dodelete(@PathVariable("id") int id) { ModelAndView mv=new
	 * ModelAndView("redirect:/"); //int id1=Integer.parseInt("id");
	 * studrepo.deleteById(id); return mv; }
	 */
	 @RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE)
		public void delete(@PathVariable(value="id") long id){
			studrepo.deleteById(id);
		}
	
}
