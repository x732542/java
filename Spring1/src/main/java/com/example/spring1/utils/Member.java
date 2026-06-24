package com.example.spring1.utils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
	private Integer id;
	
	//@Email
	//private String email;
	
	//@Min(3)@Max(20)
	@NotBlank
	@Size(min = 3, max = 20)
	private String account;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$")
	private String passwd;
	
//	@Past
//	private String birthday;
	
//	@FutureOrPresent
//	private String pleaveDate;
	
//	@PositiveOrZero
//	private Integer age;
	
	
}