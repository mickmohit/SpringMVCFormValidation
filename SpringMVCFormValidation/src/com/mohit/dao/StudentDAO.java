package com.mohit.dao;

import com.mohit.model.Student;

public interface StudentDAO {
	public abstract boolean saveStudent(Student student);
	public Student getStudentDetailsByEmailAndPassword(String email,String password);
}