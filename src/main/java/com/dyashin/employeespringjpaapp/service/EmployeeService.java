package com.dyashin.employeespringjpaapp.service;

import java.util.List;

import com.dyashin.employeespringjpaapp.dto.EmployeeDto;
import com.dyashin.employeespringjpaapp.exception.EmployeeException;
import com.dyashin.employeespringjpaapp.request.EmployeeReq;

public interface EmployeeService {

	public boolean insertData(EmployeeReq reqdto);
 
	public boolean delete(int id) throws EmployeeException;
 
	public boolean update(int id, EmployeeReq dataDto);

	public List<EmployeeDto> allData(); 

	public EmployeeDto getDataById(int id) throws EmployeeException;

	public long EmployeeCount();

	public Double MaxSalary();

	public Double MinSalary();
	
	public List<EmployeeDto> SearchEmployeebyDesignation(String designation); 

}
