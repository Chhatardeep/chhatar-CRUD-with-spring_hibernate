package com.chhatar;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@Autowired
	Servicech service;

	@RequestMapping("/add")
	public ModelAndView add(@ModelAttribute("insert") Alien a) {
		try {
			service.add(a);
			ModelAndView mv = new ModelAndView("index.jsp");

			mv.addObject("insert1", "Value is inserted");
			return mv;
		} catch (Exception e) {

			ModelAndView mv1 = new ModelAndView("index.jsp");
			mv1.addObject("insert2", "this emp id is already exist");
			return mv1;
		}

	}

	@RequestMapping("/get")
	public ModelAndView getAll(Alien a) {
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("employes",service.getAll(a));
		
		return mv;

	}

	@RequestMapping("/update")
	public String upadate(Alien a, HttpServletRequest request, HttpServletResponse response) {

		service.update(a, request, response);
		return "index.jsp";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("y1") int i, Alien a) {
		try {
			service.delete(i, a);

		} catch (Exception e) {
			return "display.jsp";

		}
		return "index.jsp";
	}

	@RequestMapping("/find")
	public ModelAndView find(Alien a) {
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("result1", service.find(a));
		return mv;
	}

}
