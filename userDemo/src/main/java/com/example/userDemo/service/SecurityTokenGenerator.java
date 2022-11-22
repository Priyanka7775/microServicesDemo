package com.example.userDemo.service;

import com.example.userDemo.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
