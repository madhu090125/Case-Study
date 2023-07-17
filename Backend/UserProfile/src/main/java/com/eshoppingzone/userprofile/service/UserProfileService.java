package com.eshoppingzone.userprofile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshoppingzone.userprofile.entity.UserProfile;

@Service
public interface UserProfileService {
	
//	public UserProfile getByProfileId(String profileId);

	public UserProfile addNewProfile(UserProfile userprofile);

	public List<UserProfile> viewAll();

	public UserProfile getByProfileId(String id);

	public UserProfile updateProfile(UserProfile userprofile);

//	public List<UserProfile> getByProfileId(String id);

}
