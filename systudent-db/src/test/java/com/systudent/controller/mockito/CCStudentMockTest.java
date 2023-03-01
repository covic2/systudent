package com.systudent.controller.mockito;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;

import com.systudent.controller.CCStudent;
import com.systudent.dao.DAOStudent;
import com.systudent.model.Student;
import com.systudent.service.CSStudent;


//@WebMvcTest(CCStudent.class)
@ExtendWith(MockitoExtension.class)
public class CCStudentMockTest {
	
    private MockMvc mockMvc;
    
    @Mock
	private DAOStudent daoStudentMock;
	
    @Mock
	private CSStudent csStudent;
	
	@InjectMocks
	private CCStudent ccStudent;
	
	@BeforeEach
    void setUp() throws Exception {
		
		Student student1=new Student();
		student1.setEnrollment("333");
		student1.setName("test");
		student1.setLastName("test");
		student1.setSurName("test");
		List<Student> l= new ArrayList<Student>();
		l.add(student1);
		//Iterable<Student> value = Arrays.asList(student1);
		//when(daoStudentMock.findAll()).thenReturn(value);
		when(csStudent.getAll()).thenReturn(l);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(new CCStudent()).build();
		
       
		
		
       
       	
    }
	
	//@Test
     //public void testData() throws Exception {
        /*
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/test"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(containsString("test")));
		*/
		 //this.mockMvc.perform(MockMvcRequestBuilders.get("/student/all"))
         //.andExpect(status().isOk());
		/*final ResultActions result = mockMvc.perform(
				MockMvcRequestBuilders.get("/student/test"));
		System.out.println("res: "+result);*/
		
		//this.mockMvc.perform(get("/student/all")).andDo(print()).andExpect(status().isOk())
		//.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
		//.andExpect(content().string(containsString("test")));
		//assertEquals("test", "test");
		
		 /*ResultActions result = this.mockMvc.perform(get("/student/all").contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));
		 result.andDo(print());
		 result.andExpect(status().isOk());*/
		 //.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1));
    //}
}
