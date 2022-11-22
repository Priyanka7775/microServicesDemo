package com.example.userDemo.service;

import com.example.userDemo.domain.User;
import com.example.userDemo.exception.UserAlreadyFoundException;
import com.example.userDemo.exception.UserNotFoundException;

public interface UserService {
    public User saveUser(User user) throws UserAlreadyFoundException;
    public User getAllByEmailAndPassword (String email,String password) throws UserNotFoundException;
}
