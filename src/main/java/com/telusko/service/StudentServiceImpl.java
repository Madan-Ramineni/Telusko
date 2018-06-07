package com.telusko.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telusko.dao.StudentDAO;
import com.telusko.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Transactional
	public void addStudent(Student student) {
		this.studentDAO.addStudent(student);
	}

	@Transactional
	public List<Student> GetTopStudents(String vAgeGropu, String vCity) {
		String vMinAge = null;
		String vMaxAge = null;
		
		if (vAgeGropu!= "Other") {
			vMinAge = vAgeGropu.substring(0, 2);
			vMaxAge = vAgeGropu.substring(3,5);
			System.out.println(vMinAge );
			System.out.println(vMaxAge);
		}
		return this.studentDAO.GetTopStudents(vMinAge, vMaxAge, vCity);
	}

}
