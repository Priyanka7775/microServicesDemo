package com.example.userMovieDemo.service;

import com.example.userMovieDemo.domain.Movie;
import com.example.userMovieDemo.domain.User;
import com.example.userMovieDemo.exception.UserAlreadyFoundException;
import com.example.userMovieDemo.exception.UserNotFoundException;
import com.example.userMovieDemo.proxy.UserProxy;
import com.example.userMovieDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProxy userProxy;
    public UserServiceImpl(UserRepository userRepository,UserProxy userProxy){
        this.userProxy=userProxy;
        this.userRepository=userRepository;
    }
    @Override
    public User addUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        User user1 = userRepository.save(user);
        if(!(user1.getEmail().isEmpty())){
            ResponseEntity responseEntity = userProxy.saveUser(user);
            System.out.println(responseEntity.getBody());
        }
        return user1;
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






