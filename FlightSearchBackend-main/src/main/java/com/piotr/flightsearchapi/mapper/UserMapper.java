package com.piotr.flightsearchapi.mapper;

import com.piotr.flightsearchapi.domain.CreateUserRequest;
import com.piotr.flightsearchapi.domain.dto.CreateUserRequestDto;
import com.piotr.flightsearchapi.domain.dto.UpdateUserEmailRequestDto;
import com.piotr.flightsearchapi.domain.dto.UpdateUserPasswordRequestDto;
import com.piotr.flightsearchapi.domain.dto.UserDto;
import com.piotr.flightsearchapi.domain.entity.User;

public interface UserMapper {

    CreateUserRequest fromDTO(CreateUserRequestDto dto);
    String passwordFromDTO (UpdateUserPasswordRequestDto dto);
    String emailFromDTO (UpdateUserEmailRequestDto dto);
    UserDto toDTO(User user);

}
