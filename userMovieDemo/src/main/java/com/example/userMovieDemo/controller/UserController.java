package com.example.userMovieDemo.controller;

import com.example.userMovieDemo.domain.Movie;
import com.example.userMovieDemo.domain.User;
import com.example.userMovieDemo.exception.UserAlreadyFoundException;
import com.example.userMovieDemo.exception.UserNotFoundException;
import com.example.userMovieDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usermovieapp/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyFoundException{
        ResponseEntity responseEntity=null;
        try{
            user.setMovies(new ArrayList<>());
            responseEntity=new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyFoundException e){
            throw new UserAlreadyFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/addmovie/{email}")
    public ResponseEntity<?> addMovieForUser(@PathVariable String email,@RequestBody Movie movie) throws UserNotFoundException {
        ResponseEntity responseEntity=null;
        try{
            responseEntity=new ResponseEntity<>(userService.addMovieForUser(email,movie), HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
