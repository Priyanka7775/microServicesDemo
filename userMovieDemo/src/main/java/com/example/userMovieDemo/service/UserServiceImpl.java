package com.example.userMovieDemo.service;

import com.example.userMovieDemo.domain.Movie;
import com.example.userMovieDemo.domain.User;
import com.example.userMovieDemo.exception.UserAlreadyFoundException;
import com.example.userMovieDemo.exception.UserNotFoundException;
import com.example.userMovieDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User addUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        return userRepository.insert(user);
        }

    @Override
    public User addMovieForUser(String email, Movie movie) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        User user = userRepository.findByEmail(email);
        if(user.getMovies()==null) {
            user.setMovies(Arrays.asList(movie));
        }else{
            List<Movie> movies = user.getMovies();
            movies.add(movie);
            user.setMovies(movies);
        }
        return userRepository.save(user);
    }

    }






