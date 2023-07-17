package com.eshoppingzone.userprofile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshoppingzone.userprofile.entity.UserProfile;
import com.eshoppingzone.userprofile.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	private UserProfileRepository userrepo;

//	@Override
//	public UserProfile getByProfileId(String profileId) {
//		Optional<UserProfile> findById = userrepo.findById(profileId);
//		if(findById.isPresent()) 
//		return findById.get() ;
//		else
//		return findById.orElse(null);	
//	}

	@Override
	public UserProfile addNewProfile(UserProfile userprofile) {
		return userrepo.insert(userprofile);
	}

	@Override
	public List<UserProfile> viewAll() {
		return userrepo.findAll();
	}
//
//	@Override
//	public List<UserProfile> getByProfileId(String id) {
//		return ;
//	}

	@Override
	public UserProfile getByProfileId(String id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).get();
	}

	@Override
	public UserProfile updateProfile(UserProfile userprofile) {
		Optional<UserProfile> findById = userrepo.findById(userprofile.getProfileId());
		if(findById.isPresent()) {
			return userrepo.save(userprofile);
		}
		return null;
		
	}

}
