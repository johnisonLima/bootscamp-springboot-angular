package com.example.santader_dev_week.service.impl;

import org.springframework.stereotype.Service;

import com.example.santader_dev_week.domain.model.User;
import com.example.santader_dev_week.domain.repository.UserRepository;
import com.example.santader_dev_week.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User create(User user) {
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }
    
}