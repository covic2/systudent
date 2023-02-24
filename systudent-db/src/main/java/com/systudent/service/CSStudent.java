package com.systudent.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systudent.dao.DAOStudent;
import com.systudent.model.Student;

@Service
public class CSStudent {
	@Autowired
	private DAOStudent daoStudent;
	
	public Student saveData(Student student) {
		//return daoStudent.save(student);
		/*Student s=new Student();
		s.setEnrollment("test");
		s.setName("testN");
		s.setLastName("testP");
		s.setSurName("testM");
		*/
		System.out.println(student);
		return daoStudent.save(student);
	}
	
	public List<Student> getAll(){
		List<Student> result = 
			  StreamSupport.stream(daoStudent.findAll().spliterator(), false)
			    .collect(Collectors.toList());
		return result;
		
	}
}
