package com.piotr.flightsearchapi.controller;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.dto.*;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.mapper.UserMapper;
import com.piotr.flightsearchapi.repository.UserRepository;
import com.piotr.flightsearchapi.security.jwt.JwtUtils;
import com.piotr.flightsearchapi.service.UserService;
import com.piotr.flightsearchapi.service.impl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody CreateUserRequestDto createUserRequestDto
            ) {
        CreateUserRequest createUserRequest = userMapper.fromDTO(createUserRequestDto);
        User user = userService.createUser(createUserRequest);
        UserDto createdUserDto = userMapper.toDTO(user);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @Valid @RequestBody CreateUserRequestDto createUserRequestDto
    ) {
        CreateUserRequest createUserRequest = userMapper.fromDTO(createUserRequestDto);

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(createUserRequest.Email(), createUserRequest.PasswordHash()));

        User user = userService.loginUser(createUserRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        UserDto createdUserDto = userMapper.toDTO(user);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(createdUserDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie jwtCookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body("Logout successful");
    }

    @PutMapping("/{userId}/email")
    public ResponseEntity<UserDto> updateUsersEmail(
            @PathVariable Integer userId,
            @Valid @RequestBody UpdateUserEmailRequestDto updateUserEmailRequestDto){
        String Email = userMapper.emailFromDTO(updateUserEmailRequestDto);
       User user = userService.updateUserEmail(userId, Email);
       UserDto updatedUserDto = userMapper.toDTO(user);
       return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }


    @PutMapping("/{userId}/password")
    public ResponseEntity<UserDto> updateUsersPassword(
            @PathVariable Integer userId,
            @Valid @RequestBody UpdateUserPasswordRequestDto updateUserPasswordRequestDto){
        String Password = userMapper.passwordFromDTO(updateUserPasswordRequestDto);
        User user = userService.updateUserPassword(userId, Password);
        UserDto updatedUserDto = userMapper.toDTO(user);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> eraseUser(
            @PathVariable Integer userId
    ){
        userService.deleteUser(userId);
        ResponseCookie jwtCookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body("Account deletion successful");
    }


}
