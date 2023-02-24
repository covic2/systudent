package com.systudent.controller;

import java.util.List;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systudent.component.LoggerProducer;
import com.systudent.model.Student;
import com.systudent.service.CSStudent;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;

@RestController
@EnableEurekaClient
@RequestMapping("/student")
public class CCStudent {
	//private static final Logger LOG = Logger.getLogger(CCStudent.class.getName());

	
	@Autowired
	private CSStudent csStudent;
	
	@Autowired
	private LoggerProducer loggerProducer;
	
	@PostMapping(value="/save", consumes = "application/json", produces = "application/json")
	public Student saveStudent(@RequestBody Student student) {
		//LOG.log(Level.INFO, "/save");
	  return csStudent.saveData(student);
	}
	
	@GetMapping(value="/all", produces = "application/json")
	public List<Student> getAll(){
		//LOG.log(Level.INFO, "/all ");
		return csStudent.getAll();
		
	}
	
	@GetMapping("/test")
	public String test() {
		//LOG.log(Level.INFO, "/test " );
		loggerProducer.sendMessage("[ModuleDB][CCStudent] message test");
		return "test";
	}
}