package com.eshoppingzone.userprofile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.userprofile.entity.UserProfile;
import com.eshoppingzone.userprofile.service.UserProfileService;
import com.eshoppingzone.userprofile.service.UserProfileServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userservice;
	
	@GetMapping("/view")
	public List<UserProfile> viewAll() {
		return userservice.viewAll();
	}
	
	@GetMapping("/user/{profileId}")
	public UserProfile getProfileById(@PathVariable("profileId") String profileId){
		return userservice.getByProfileId(profileId);	
	}
	
	@PostMapping("/add")
	public UserProfile addNewProfile(@RequestBody UserProfile userprofile){
		return userservice.addNewProfile(userprofile);
	}
	
	@PutMapping("/update")
	public UserProfile updateProfile(@RequestBody UserProfile userprofile) {
		return userservice.updateProfile(userprofile);
	}
}
