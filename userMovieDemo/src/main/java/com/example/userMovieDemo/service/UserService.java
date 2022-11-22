package com.example.userMovieDemo.service;

import com.example.userMovieDemo.domain.Movie;
import com.example.userMovieDemo.domain.User;
import com.example.userMovieDemo.exception.UserAlreadyFoundException;
import com.example.userMovieDemo.exception.UserNotFoundException;

public interface UserService {
    public User addUser(User user)throws UserAlreadyFoundException;
    public User addMovieForUser(String email, Movie movie) throws UserNotFoundException;
}
