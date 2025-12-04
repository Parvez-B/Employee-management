 package com.dyashin.employeespringjpaapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dyashin.employeespringjpaapp.dto.EmployeeDto;

public interface EmployeeDao extends JpaRepository<EmployeeDto, Integer> {

	 @Query("SELECT e FROM EmployeeDto e WHERE e.designation = :designation")
	    List<EmployeeDto> getByDesignation(@Param("designation") String designation);

	    @Query("SELECT MAX(e.salary) FROM EmployeeDto e")
	    Double maxSalary();
 
	    @Query("SELECT MIN(e.salary) FROM EmployeeDto e")
	    Double minSalary();
	    
	    
	    
	    
	   
} 
