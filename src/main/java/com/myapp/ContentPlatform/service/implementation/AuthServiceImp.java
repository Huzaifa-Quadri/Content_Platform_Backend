package com.myapp.ContentPlatform.service.implementation;

import com.myapp.ContentPlatform.model.user.Role;
import com.myapp.ContentPlatform.model.user.User;
import com.myapp.ContentPlatform.payload.requests.AuthRequest;
import com.myapp.ContentPlatform.payload.requests.RegisterRequest;
import com.myapp.ContentPlatform.payload.responses.ApiResponse;
import com.myapp.ContentPlatform.payload.responses.AuthResponse;
import com.myapp.ContentPlatform.payload.responses.Response;
import com.myapp.ContentPlatform.repository.UserRepository;
import com.myapp.ContentPlatform.service.AuthService;
import com.myapp.ContentPlatform.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public Response register(RegisterRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
        if (optionalUser.isPresent()) {
            return new ApiResponse("Email address is already registered.", HttpStatus.CONFLICT);
        } else {
            User user = User.builder().firstname(request.getFirstname()).lastname(request.getLastname())
                    .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).
                    role(Role.USER).build();

            userRepository.save(user);
            return new ApiResponse("Registration success", HttpStatus.OK);
        }
    }


    @Override
    public Response authenticate(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public PasswordEncoder getEncoder() {
        return passwordEncoder;
    }
}