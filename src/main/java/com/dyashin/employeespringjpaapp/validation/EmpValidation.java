package com.dyashin.employeespringjpaapp.validation;

import com.dyashin.employeespringjpaapp.exception.EmployeeException;
import com.dyashin.employeespringjpaapp.request.EmployeeReq;

public class EmpValidation {

	public static void validateFields(EmployeeReq dto) throws EmployeeException {

		if (dto.getId() < 0) {
			throw new EmployeeException("Employee Id must be positive");
		}

		if (dto.getFname() == null || dto.getFname().trim().isEmpty()) {
			throw new EmployeeException("First name cannot be empty");
		}

		if (!dto.getFname().matches("^[A-Za-z\\s]+$")) {
			throw new EmployeeException("First name must contain only alphabets");
		}

		if (dto.getLastName() == null || dto.getLastName().trim().isEmpty()) {
			throw new EmployeeException("Last name cannot be empty");
		}

		if (!dto.getLastName().matches("^[A-Za-z\\s]+$")) {
			throw new EmployeeException("Last name must contain only alphabets");
		}

		if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
			throw new EmployeeException("Email cannot be empty");
		}

		if (!dto.getEmail().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
			throw new EmployeeException("Invalid email format");
		}

		if (dto.getPhoneNumber() == null || !dto.getPhoneNumber().matches("^[0-9]{10}$")) {
			throw new EmployeeException("Phone number must be 10 digits");
		}

		if (dto.getAge() <= 0) {
			throw new EmployeeException("Age must be greater than 0");
		}

		if (dto.getDob() == null) {
			throw new EmployeeException("Date of birth is required");
		}

		if (dto.getGender() == null || dto.getGender().trim().isEmpty()) {
			throw new EmployeeException("Gender is required");
		}

		if (dto.getJoiningDate() == null) {
			throw new EmployeeException("Joining date is required");
		}

//	        if (dto.getJoiningDate().isBefore(dto.getDob())) {
//	            throw new EmployeeException("Joining date cannot be before Date of Birth");
//	        }

		if (dto.getDeptNumber() <= 0) {
			throw new EmployeeException("Department number must be positive");
		}

		if (dto.getDesignation() == null || dto.getDesignation().trim().isEmpty()) {
			throw new EmployeeException("Designation cannot be empty");
		}

		if (!dto.getDesignation().matches("^[A-Za-z\\s]+$")) {
			throw new EmployeeException("Designation must contain only alphabets");
		}

		if (dto.getExperience() < 0) {
			throw new EmployeeException("Experience cannot be negative");
		}

		if (dto.getSalary() <= 0) {
			throw new EmployeeException("Salary must be greater than 0");
		}
	}
 
	public static void validateId(int id) throws EmployeeException {
		if (id < 0) {
			throw new EmployeeException("Employee Id must be positive");
		}
	}

	public static void validateMobile(String mobile) throws EmployeeException {
		if (mobile == null || !mobile.matches("^[0-9]{10}$")) {
			throw new EmployeeException("Mobile number must be 10 digits");
		}
	}

	public static void validateName(String name) throws EmployeeException {
		if (name == null || name.trim().isEmpty()) {
			throw new EmployeeException("Name cannot be empty");
		}
	}

	public static void validateSalary(double salary) throws EmployeeException {
		if (salary <= 0) {
			throw new EmployeeException("Salary must be positive");
		}
	}
}
