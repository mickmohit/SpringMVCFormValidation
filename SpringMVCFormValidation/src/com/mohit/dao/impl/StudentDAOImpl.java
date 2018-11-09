package com.mohit.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mohit.dao.StudentDAO;
import com.mohit.model.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Override
	@Transactional(readOnly=false)
	public boolean saveStudent(Student student) {
		int id = (Integer)hibernateTemplate.save(student);
		System.out.println("id value:"+id);
		System.out.println("Student created " +student);
		if(id>0)
			
			return true;
		
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Student getStudentDetailsByEmailAndPassword(String email,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(Student.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<Student> findByCriteria = (List<Student>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
}
