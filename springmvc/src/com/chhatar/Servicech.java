package com.chhatar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface Servicech {

	public void add(Alien a);
	public void update(Alien a,@RequestParam("aname") String name);
	public void delete(@RequestParam("y1") int i,Alien a);
	public Object find(Alien a);
	public List<Alien> getAll(Alien a);
	
}
