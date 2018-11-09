package com.mohit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.dao.StudentDAO;
import com.mohit.model.Student;
import com.mohit.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	@Override
	public boolean registerStudent(Student student) {
		boolean isRegister=false;
		boolean saveStudent = getStudentDAO().saveStudent(student);
		System.out.println("boolean saveStudent value:"+saveStudent);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}

	@Override
	public Student validateStudentCredential(String email, String password) {
		Student student = getStudentDAO().getStudentDetailsByEmailAndPassword(email, password);
		return student;
	}
}
