package com.myapp.ContentPlatform.controller;

import com.myapp.ContentPlatform.payload.requests.AuthRequest;
import com.myapp.ContentPlatform.payload.requests.RegisterRequest;
import com.myapp.ContentPlatform.payload.responses.Response;
import com.myapp.ContentPlatform.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody RegisterRequest request) {
        Response response = authService.register(request);
        return new ResponseEntity<>(response, response.getStatus());
    }


    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthRequest request) {
        Response response = authService.authenticate(request);
        return new ResponseEntity<>(response, response.getStatus());
    }
}