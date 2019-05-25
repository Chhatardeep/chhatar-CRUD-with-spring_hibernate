package com.chhatar;

import java.util.ArrayList;
import java.util.List;

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

@Repository(value = "DAO")
public class DAOImpl extends DAO {

	@Override

	public void addData(Alien a) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory seg = con.buildSessionFactory(reg);
		Session s = seg.openSession();
		Transaction tx = s.beginTransaction();
		s.save(a);
		tx.commit();
	}

	@Override

	public void updateData(Alien a, @RequestParam("aname") String name) {

		Configuration cgf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cgf.getProperties()).buildServiceRegistry();
		SessionFactory ssn = cgf.buildSessionFactory(srg);
		Session session = ssn.openSession();
		Transaction tx = session.beginTransaction();
		a = (Alien) session.get(Alien.class, a.getAemp());
		a.setAname(name);
		session.update(a);
		tx.commit();
	}

	@Override

	public void deleteData(@RequestParam("y1") int i, Alien a) {
		Configuration cgf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cgf.getProperties()).buildServiceRegistry();
		SessionFactory ssn = cgf.buildSessionFactory(srg);
		Session session = ssn.openSession();
		Transaction tx = session.beginTransaction();
		a = (Alien) session.get(Alien.class, i);
		session.delete(a);
		tx.commit();

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
