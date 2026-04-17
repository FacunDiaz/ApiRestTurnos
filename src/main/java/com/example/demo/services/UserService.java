package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUser(long id);

    List<User> findAllUsers();

    boolean deleteUser(long id);

    User updateUser(long id,User newUser);
}
