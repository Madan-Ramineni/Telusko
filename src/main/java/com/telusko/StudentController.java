package com.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.model.Student;
import com.telusko.service.StudentService;;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Qualifier(value = "studentService")
	public void setStudenrService(StudentService ss) {
		this.studentService = ss;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest req, HttpServletResponse resp, Model mv) {

		String vName = req.getParameter("StudentName");
		System.out.println(vName);
		String vMarks = req.getParameter("Marks");
		String vCity = req.getParameter("City");
		String vAge = req.getParameter("Age");
		Student student = new Student();
		student.setAge(vAge);
		student.setMarks(vMarks);
		student.setCity(vCity);
		student.setName(vName);
		this.studentService.addStudent(student);

		
		 mv.addAttribute("Result", vName);

		return "Success.jsp";
	}

	@RequestMapping("/topstudents")
	public String topStudents(HttpServletRequest req, HttpServletResponse resp, Model model) {
		//ModelAndView model = new ModelAndView();
		String vAgeGropu = req.getParameter("AgeGroup");
		String vCity = req.getParameter("City");
		
		System.out.println(vAgeGropu + vCity);
		
		model.addAttribute("toppers", this.studentService.GetTopStudents(vAgeGropu, vCity));
		// model.addAttribute("listPersons", this.personService.listPersons());
		return "topstudents.jsp";
	}
}
