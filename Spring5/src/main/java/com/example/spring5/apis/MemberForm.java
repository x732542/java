package com.example.spring5.apis;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberForm {
	@NotBlank(message = "Account 不可空白")
	@Email(message = "Email 格式錯誤")
	private String account;
	
	@Size(min=6,  message = "密碼長度>=6")
	private String passwd;
	
	@NotBlank(message = "Name 不可空白")
	private String name;
	
}
