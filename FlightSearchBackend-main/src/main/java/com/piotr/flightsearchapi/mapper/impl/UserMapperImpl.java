package com.piotr.flightsearchapi.mapper.impl;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.dto.CreateUserRequestDto;
import com.piotr.flightsearchapi.domain.dto.UpdateUserEmailRequestDto;
import com.piotr.flightsearchapi.domain.dto.UpdateUserPasswordRequestDto;
import com.piotr.flightsearchapi.domain.dto.UserDto;
import com.piotr.flightsearchapi.domain.entity.User;
import com.piotr.flightsearchapi.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public CreateUserRequest fromDTO(CreateUserRequestDto dto) {
        return new CreateUserRequest(
                dto.Email(),
                dto.PasswordHash()
        );
    }

    @Override
    public String passwordFromDTO(UpdateUserPasswordRequestDto dto) {
        return dto.PasswordHash();
    }

    @Override
    public String emailFromDTO(UpdateUserEmailRequestDto dto) {
        return dto.Email();
    }

    @Override
    public UserDto toDTO(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPasswordHash()
        );
    }
}
