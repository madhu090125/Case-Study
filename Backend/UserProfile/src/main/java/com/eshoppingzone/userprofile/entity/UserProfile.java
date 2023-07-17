package com.eshoppingzone.userprofile.entity;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userservice")
public class UserProfile {
	
	@Id
	private String profileId;
	private String personalInfo;
	@Email(message = "Email must be valid")
	@NotEmpty(message = "Email cannot be empty")
	@Indexed(unique = true)
	private String email;
	@Size(min = 6, message = "length must be greater then 6")
	private String gender;
	private long mobileNo;

}
