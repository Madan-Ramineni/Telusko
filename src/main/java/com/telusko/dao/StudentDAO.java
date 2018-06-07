package com.telusko.dao;

import java.util.List;

import com.telusko.model.Student;

public interface StudentDAO {

		public void addStudent(Student p);
		public List<Student> GetTopStudents(String pMinAge, String pMaxAge, String vCity);


}
