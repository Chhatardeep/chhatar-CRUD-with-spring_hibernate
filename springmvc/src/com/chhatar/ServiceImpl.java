package com.chhatar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Service(value="Servicech")
public class ServiceImpl implements Servicech{

	@Autowired
	DAO dao;
	
	@Override
	public void add(Alien a) {
	
		dao.addData(a);
	}

	@Override
	public void update(Alien a,@RequestParam("aname") String name) {
		dao.updateData(a,name);
		
	}

	@Override
	public void delete(@RequestParam("y1") int i,Alien a) {
		
		dao.deleteData(i,a);
	}

	@Override
	public Object find(Alien a) {
		
		return this.dao.findData(a);
	}

	@Override
	public List<Alien> getAll(Alien a) {
		return this.dao.getAllData(a);
	}

	

}
