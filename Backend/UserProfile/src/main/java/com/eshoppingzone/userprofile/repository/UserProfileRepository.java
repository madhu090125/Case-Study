package com.eshoppingzone.userprofile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshoppingzone.userprofile.entity.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String>{

}
