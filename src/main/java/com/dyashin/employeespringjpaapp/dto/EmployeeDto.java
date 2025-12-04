package com.dyashin.employeespringjpaapp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees_dto")
@Getter 
@Setter
@JsonRootName("Employee")
public class EmployeeDto { 
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fname",nullable = false)
	private String fname;

	@Column(name = "last_name",nullable = false)
	private String lastName;

	@Column(name = "email",nullable = false)
	private String email;

	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;

	@Column(name = "age",nullable = false)
	private Integer age;

	@Column(name = "DOB",nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	@Column(name = "gender",nullable = false)
	private String gender;

	@Column(name = "joining_date",nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	@Column(name = "dept_number",nullable = false)
	private Integer deptNumber;

	@Column(name = "designation",nullable = false) 
	private String designation;

	@Column(name = "experience",nullable = false)
	private Integer experience;

	@Column(name = "salary",nullable = false)
	private double salary;
}
