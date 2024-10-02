package com.digitalSupport.seasonalInformation.repository;

import com.digitalSupport.seasonalInformation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
