package com.myapp.ContentPlatform.service;


import com.myapp.ContentPlatform.payload.requests.AuthRequest;
import com.myapp.ContentPlatform.payload.requests.RegisterRequest;
import com.myapp.ContentPlatform.payload.responses.Response;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthService {
    Response register(RegisterRequest request);
    Response authenticate(AuthRequest request);
    PasswordEncoder getEncoder();


}