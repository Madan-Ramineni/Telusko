package com.telusko.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.telusko.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private HibernateTemplate hb;

	public void setHb(HibernateTemplate hb) {
		this.hb = hb;
	}

	public void addStudent(Student p) {
		hb.save(p);
	}

	@SuppressWarnings("unchecked")
	public List<Student> GetTopStudents(String pMinAge, String pMaxAge, String vCity) {

		ArrayList TopStudent = new ArrayList();

		Object[] params = { pMaxAge, pMinAge, vCity };
		List<Student> studentsList = (List<Student>) hb
				.find("from Student where age< ? and age >= ? and city = ?  order by Marks desc ", params);
		if (!studentsList.isEmpty()) {

			for (int i = 0; i < studentsList.size(); i++) {
				TopStudent.add(studentsList.get(i));
				if (i== 5) {
					break;
				}
			}

		}
		return TopStudent;
	}

}
