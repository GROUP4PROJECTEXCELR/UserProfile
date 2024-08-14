package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByEmail(String email);
}
