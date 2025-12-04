package com.dyashin.employeespringjpaapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyashin.employeespringjpaapp.dao.EmployeeDao;
import com.dyashin.employeespringjpaapp.dto.EmployeeDto;
import com.dyashin.employeespringjpaapp.exception.EmployeeException;
import com.dyashin.employeespringjpaapp.request.EmployeeReq;
import com.dyashin.employeespringjpaapp.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public boolean insertData(EmployeeReq reqdto) {
		EmployeeDto dto = new EmployeeDto();
		dto.setLastName(reqdto.getLastName());
		dto.setFname(reqdto.getFname());
		dto.setEmail(reqdto.getEmail());
		dto.setAge(reqdto.getAge());
		dto.setPhoneNumber(reqdto.getPhoneNumber());
		dto.setDob(reqdto.getDob());
		dto.setGender(reqdto.getGender());
		dto.setJoiningDate(reqdto.getJoiningDate());
		dto.setDeptNumber(reqdto.getDeptNumber()); 
		dto.setDesignation(reqdto.getDesignation());
		dto.setExperience(reqdto.getExperience());
		dto.setSalary(reqdto.getSalary());

		EmployeeDto entity = dao.save(dto);
		if (entity != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(int id) throws EmployeeException {
		Optional<EmployeeDto> data = dao.findById(id);

		if (!data.isPresent()) {
			return false;
		}

		dao.deleteById(id);
		return true;
	}

	@Override
	public boolean update(int id, EmployeeReq dataDto) {

		Optional<EmployeeDto> data = dao.findById(id);

		if (!data.isPresent()) {
			return false;
		}
		EmployeeDto employeeDto = data.get();

		employeeDto.setId(id);
		employeeDto.setFname(dataDto.getFname());
		employeeDto.setLastName(dataDto.getLastName());
		employeeDto.setEmail(dataDto.getEmail());
		employeeDto.setAge(dataDto.getAge());
		employeeDto.setPhoneNumber(dataDto.getPhoneNumber());
		employeeDto.setDob(dataDto.getDob());
		employeeDto.setGender(dataDto.getGender());
		employeeDto.setJoiningDate(dataDto.getJoiningDate());
		employeeDto.setDeptNumber(dataDto.getDeptNumber());
		employeeDto.setDesignation(dataDto.getDesignation());
		employeeDto.setExperience(dataDto.getExperience());
		employeeDto.setSalary(dataDto.getSalary());

		EmployeeDto update = dao.save(employeeDto);

		return update != null;
	}

	@Override
	public List<EmployeeDto> allData() {
		List<EmployeeDto> list = dao.findAll();
		return list;
	}

	@Override
	public EmployeeDto getDataById(int id) throws EmployeeException { 
		
		  return dao.findById(id)
	                .orElseThrow(() -> new EmployeeException("Employee not found with id: " + id));


//		Optional<EmployeeDto> data = dao.findById(id);
//
//		if (!data.isPresent()) {
//			return false;
//		}
//
//
//		return data.get();
	}

	@Override
	public long EmployeeCount() {
		return dao.count();
	}

	@Override
	public Double MaxSalary() {
		return dao.maxSalary();
	}

	@Override
	public Double MinSalary() {
		return dao.minSalary();
	}

	@Override
	public List<EmployeeDto> SearchEmployeebyDesignation(String designation) {
		List<EmployeeDto> list = dao.getByDesignation(designation);
		return list;
	}
}
