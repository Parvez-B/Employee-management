package com.dyashin.employeespringjpaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dyashin.employeespringjpaapp.dto.EmployeeDto;
import com.dyashin.employeespringjpaapp.exception.EmployeeException;
import com.dyashin.employeespringjpaapp.request.EmployeeReq;
import com.dyashin.employeespringjpaapp.service.EmployeeService;
import com.dyashin.employeespringjpaapp.validation.EmpValidation;

@RestController
@RequestMapping("/employee")
public class EmployeeConroller {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody EmployeeReq dto) throws EmployeeException {

		EmpValidation.validateFields(dto);

		boolean insert = employeeService.insertData(dto);
		if (insert) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Employee inserted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee insertion faild");

		}

	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody EmployeeReq dto) throws EmployeeException {

		EmpValidation.validateFields(dto);

		boolean update = employeeService.update(dto.getId(), dto);
		if (update) {
			return ResponseEntity.ok("Employee updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee update failed");

		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws EmployeeException {

		EmpValidation.validateId(id);

		boolean dalete = employeeService.delete(id);
		if (dalete) {
			return ResponseEntity.ok("Employee Delete successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee Deletetion faild");

		}

	}

	@GetMapping
	public ResponseEntity<?> getAlldata() {

		List<EmployeeDto> list = employeeService.allData();

		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(list);

	}

	@GetMapping("{id}")
	public ResponseEntity<?> getDataById(@PathVariable int id) throws EmployeeException {

		EmpValidation.validateId(id);

		EmployeeDto data = employeeService.getDataById(id);
		if (data != null) {
			return ResponseEntity.ok(data);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee insertion faild");

		}

	}

	@GetMapping("/count")
	public ResponseEntity<?> EmployeeCount() {
		long count = employeeService.EmployeeCount();
		if (count != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(count);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Employee record found");
		}

	}

	@GetMapping("/salary/min")
	public ResponseEntity<?> minSalary() {

		Double min = employeeService.MinSalary();
		if (min != null) {
			return ResponseEntity.ok(min);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 

	}

	@GetMapping("/salary/max")
	public ResponseEntity<?> MaxSalary() {
		Double max = employeeService.MaxSalary();
		if (max != null) {
			return ResponseEntity.ok(max);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@GetMapping("/search")
	public ResponseEntity<?> Employeedesignation(@RequestParam("designation") String designation) {

		List<EmployeeDto> list = employeeService.SearchEmployeebyDesignation(designation);

		if (list != null) {
			return ResponseEntity.ok(list); 
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
