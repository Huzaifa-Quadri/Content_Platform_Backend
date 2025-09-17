package com.myapp.ContentPlatform.service;

import com.myapp.ContentPlatform.model.user.Role;
import com.myapp.ContentPlatform.model.user.User;
import com.myapp.ContentPlatform.payload.responses.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface CustomUserDetailsService extends UserDetailsService {
    Response getPostsByUser(String username);
    Response getStoriesByUser(String username);
    Response addNewUser(User newUser, Authentication authentication, PasswordEncoder passwordEncoder);
    Response updateUser(String username, User updUser, Authentication authentication, PasswordEncoder passwordEncoder);
    Response deleteUser(String username, Authentication authentication);
    Response setUserRole(String username, Authentication authentication, Role role);
}