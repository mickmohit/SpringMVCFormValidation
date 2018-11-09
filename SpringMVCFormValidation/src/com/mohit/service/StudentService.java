package com.mohit.service;

import com.mohit.model.Student;

public interface StudentService {
	public abstract Student validateStudentCredential(String email,	String password);
	public abstract boolean registerStudent(Student student);

}