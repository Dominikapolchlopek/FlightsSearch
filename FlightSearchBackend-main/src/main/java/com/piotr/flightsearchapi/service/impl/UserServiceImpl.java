package com.piotr.flightsearchapi.service.impl;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.repository.UserRepository;
import com.piotr.flightsearchapi.security.jwt.JwtUtils;
import com.piotr.flightsearchapi.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> getUserbyEmail(String Email){
        return Optional.ofNullable(userRepository.findByEmail(Email));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        if (getUserbyEmail(request.Email()).isPresent()) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        User user = new User(null, request.Email(), passwordEncoder.encode(request.PasswordHash()));
        return userRepository.save(user);
    }

    @Override
    public User loginUser(CreateUserRequest request) {
        User user = userRepository.findByEmail(request.Email());

        if (user == null) {
            throw new IllegalArgumentException("Wrong email or password");
        }
        if (!passwordEncoder.matches(request.PasswordHash(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Wrong email or password");
        }

        return user;
    }

    @Override
    public User updateUserEmail(Integer Id, String Email) {
        User newUser = userRepository.findByEmail(Email);
        if(!(newUser == null)){
            throw new IllegalArgumentException("User with this email already exists");
        }
        User user = userRepository.findById(Id)
            .orElseThrow(() -> new IllegalArgumentException("User with this id does not exist"));
        user.setEmail(Email);
        return userRepository.save(user);
    }

    @Override
    public User updateUserPassword(Integer Id, String PasswordHash) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("User with this id does not exist"));
        if(user.getPasswordHash().equals(PasswordHash)){
            throw new IllegalArgumentException("Passwords must be different");
        }
        user.setPasswordHash(passwordEncoder.encode(PasswordHash));
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer Id) {
        Optional<User> user = userRepository.findById(Id);
        userRepository.delete(user.get());
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    @Override
    public User findUserByEmailAndPassword(String Email, String PasswordHash){
        return userRepository.findByEmailAndPassword(Email, PasswordHash);
    }


}
