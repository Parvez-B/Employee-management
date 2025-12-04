package com.dyashin.employeespringjpaapp.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
  
@Data
public class EmployeeReq {
	 
	private int id;
	
	@NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name max length is 50")
    private String fname;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name max length is 50")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 120, message = "Email max length is 120")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Size(max = 15, message = "Phone number max length is 15")
    private String phoneNumber;

    @NotNull(message = "Age is required")
    @Positive(message = "Age must be positive")
    private Integer age;

    @NotNull(message = "Date of birth is required")
    private LocalDate dob;

    @NotBlank(message = "Gender is required")
    @Size(max = 10)
    private String gender;
 
    @NotNull(message = "Joining date is required")
    private LocalDate joiningDate;

    @NotNull(message = "Department number is required")
    private Integer deptNumber;

    @NotBlank(message = "Designation is required")
    @Size(max = 50)
    private String designation;

    @NotNull(message = "Experience is required")
    @PositiveOrZero(message = "Experience must be zero or positive")
    private Integer experience;

    @NotNull(message = "Salary is required")
    @PositiveOrZero(message = "Salary must be zero or positive")
    private Double salary;

}
