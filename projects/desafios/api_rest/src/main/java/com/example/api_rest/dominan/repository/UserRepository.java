package com.example.api_rest.dominan.repository;

import org.springframework.stereotype.Repository;
import com.example.api_rest.dominan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
