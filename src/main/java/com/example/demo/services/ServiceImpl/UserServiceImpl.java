package com.example.demo.services.serviceImpl;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired //automatic injection of dependencies
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findUser(long id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) throw new NotFoundException("No se encontró dicho usuario"+ id);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteUser(long id) {
        repository.deleteById(id); //first, finds the user with findById and then, deletes it. If a user with that id does not exits, throws an exception
        return false;
    }

    @Override
    public User updateUser(long id,User newUser) {
        Optional<User> oldUser = repository.findById(id);
        if(oldUser.isEmpty()) throw new NotFoundException("No se encontró dicho usuario"+ id);
        newUser.setIdUser(oldUser.get().getIdUser());
        repository.save(newUser);
        return newUser;
    }
}
