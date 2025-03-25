package com.example.santader_dev_week.service.impl;

import java.util.NoSuchElementException;

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
            .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
        throw new IllegalArgumentException("User already exists");
        }
        return userRepository.save(user);
    }
    
}