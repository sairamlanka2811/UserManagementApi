package com.apex.userManagement.repository;

import com.apex.userManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // finding a user by username
    Optional<User> findByUsername(String username);
}
