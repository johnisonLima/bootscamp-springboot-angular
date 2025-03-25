package com.example.api_rest.service;

import com.example.api_rest.dominan.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
    
}
