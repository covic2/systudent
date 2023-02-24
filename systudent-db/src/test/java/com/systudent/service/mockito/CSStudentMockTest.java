package com.systudent.service.mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.systudent.dao.DAOStudent;
import com.systudent.model.Student;
import com.systudent.service.CSStudent;



@ExtendWith(MockitoExtension.class)
public class CSStudentMockTest {
	@Mock
	private DAOStudent daoStudentMock;
	
	@InjectMocks
	private CSStudent csStudent;
	
	@BeforeEach
    void setMockOutput() {
		Student student1=new Student();
		student1.setEnrollment("11111");
		student1.setName("test");
		student1.setLastName("test");
		student1.setSurName("test");
		Iterable<Student> value = Arrays.asList(student1);
		when(daoStudentMock.findAll()).thenReturn(value);
    }
	
	@Test
	public void testFindTheGreatestFromAllData() {
		assertEquals("test", csStudent.getAll().get(0).getName());
	}
	
}
