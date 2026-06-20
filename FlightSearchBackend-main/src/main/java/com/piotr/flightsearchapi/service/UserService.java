package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserbyEmail(String Email);

    User createUser(CreateUserRequest request);

    User loginUser(CreateUserRequest request);

    User updateUserEmail(Integer Id, String Email);

    User updateUserPassword(Integer Id, String PasswordHash);

    void deleteUser(Integer Id);

    List<User> findAllUsers();

    User findUserByEmail(String Email);

    User findUserByEmailAndPassword(String Email, String PasswordHash);
}
