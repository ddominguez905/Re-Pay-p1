package com.example.service;

public interface AuthenticationService {
    boolean authenticate(String username, String password);
        void register (String username, String password);
    }

