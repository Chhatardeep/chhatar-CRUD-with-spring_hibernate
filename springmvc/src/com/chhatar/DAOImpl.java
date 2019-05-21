package com.chhatar;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Repository(value = "DAO")
public class DAOImpl extends DAO {

	@Override
	@Transactional
	public void addData(Alien a) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory seg = con.buildSessionFactory(reg);
		Session s = seg.openSession();
		
		s.save(a);
		

	}

	@Override
	@Transactional
	public void updateData(Alien a, HttpServletRequest request, HttpServletResponse response) {
		int x = Integer.parseInt(request.getParameter("y1"));
		String y = request.getParameter("y2");

		Configuration cgf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cgf.getProperties()).buildServiceRegistry();
		SessionFactory ssn = cgf.buildSessionFactory(srg);
		Session session = ssn.openSession();
		
		a = (Alien) session.get(Alien.class, x);
		a.setAname(y);
		session.update(a);
	}

	@Override
	@Transactional
	public void deleteData(@RequestParam("y1") int i, Alien a) {
		Configuration cgf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cgf.getProperties()).buildServiceRegistry();
		SessionFactory ssn = cgf.buildSessionFactory(srg);
		Session session = ssn.openSession();
		a = (Alien) session.get(Alien.class, i);
		session.delete(a);

	}

	@Override
	@Transactional
	public Object findData(@ModelAttribute("result") Alien a) {

		Configuration cgf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cgf.getProperties()).buildServiceRegistry();
		SessionFactory ssn = cgf.buildSessionFactory(srg);
		Session session = ssn.openSession();

		a = (Alien) session.get(Alien.class, a.getAemp());
		Object o = a;

		return o;

	}

	@Override
	@Transactional
	public List<Alien> getAllData(Alien a) {

		
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory seg = con.buildSessionFactory(reg);
		Session s = seg.openSession();
		List<Alien> list = new ArrayList<Alien>();
		Query q = s.createQuery("from Alien");
		list = q.list();
		
		return list;
	}

}
