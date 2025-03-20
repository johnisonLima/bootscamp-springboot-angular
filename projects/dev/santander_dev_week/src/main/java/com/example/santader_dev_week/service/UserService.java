package com.example.santader_dev_week.service;

import com.example.santader_dev_week.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);

}
