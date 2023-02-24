package com.systudent.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.systudent.model.Student;

@Repository
public interface DAOStudent extends CrudRepository<Student,String>{

}
